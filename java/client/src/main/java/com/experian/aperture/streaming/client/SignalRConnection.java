package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.RetryOptions;
import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;
import com.microsoft.signalr.HubConnectionState;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

/**
 * The SignalR client connection.
 */
final class SignalRConnection implements Connection {
    private static final String AUTH_TOKEN_HEADER = "Auth-Token";
    private HubConnection connection;
    private RetryOptions retryOptions;
    private Runnable resendCallback;
    private boolean streamingStopIntentionally;
    private final PublishSubject<ConnectionEvent> connectionEventSubject;

    SignalRConnection(final String url, final String authToken, final RetryOptions retryOptions) {
        this.connection = HubConnectionBuilder
                .create(url)
                .withAccessTokenProvider(Single.just(authToken))
                .withHeader(AUTH_TOKEN_HEADER, authToken)
                .build();
        this.connection.onClosed(this::onClosed);
        this.retryOptions = retryOptions;
        this.connectionEventSubject = PublishSubject.create();
    }

    @Override
    public <T> void subscribe(final String method, final ConnectionResponse<T> callback, final Class<T> param) {
        this.connection.on(method, callback::invoke, param);
    }

    @Override
    /* CHECKSTYLE_OFF: IllegalCatch */
    public void start() throws ConnectionException {
        try {
            this.startConnection();
        } catch (final RuntimeException ex) {
            if (ex.getMessage().contains(ResourceReader.getErrorMessageWithKey("SignalRNotFoundError"))) {
                throw new ConnectionException(ErrorCode.NOT_FOUND.getValue());
            } else if (!ex.getMessage().equals(ResourceReader.getErrorMessageWithKey("SignalRWebSocketError"))) {
                // Throw connection that is not related to "starting the WebSocket transport" error.
                // Note: The related "starting the WebSocket transport" error has been handle in OnClosed method
                throw new ConnectionException(ex.getMessage());
            }
        }
    }

    @Override
    public void stop() {
        this.streamingStopIntentionally = true;
        this.stopConnection();
    }

    @Override
    public Single<Void> send(final String method, final Object args) throws ConnectionException {
        if (this.connection.getConnectionState() == HubConnectionState.DISCONNECTED) {
            throw new ConnectionException("Your connection disconnected. Please restart the job from latest item successfully submitted.");
        }
        try {
            return this.invokeHubMethod(method, args);
        } catch (final NullPointerException ex) {
            final Runnable autoResendCallback = autoResend(method, args);
            runCallback(autoReconnect(autoResendCallback));
            return Single.error(ex);
        }
    }

    @Override
    public void setAutoResendCallback(final Runnable resendCallback) {
        this.resendCallback = resendCallback;
    }

    @Override
    public PublishSubject<ConnectionEvent> getConnectionEventSubject() {
        return this.connectionEventSubject;
    }

    private void onClosed(final Exception ex) {
        if (this.streamingStopIntentionally) {
            return;
        }
        if (ex == null) {
            // auto reconnect when server is stopped (exception is null)
            runCallback(autoReconnect(this.resendCallback));
            return;
        }
        boolean isInstanceOfRuntimeException = ex instanceof RuntimeException;
        if (!isInstanceOfRuntimeException) {
            return;
        }
        if (ex.getMessage().equals(ResourceReader.getErrorMessageWithKey("SignalRForbiddenError"))) {
            this.connectionEventSubject.onNext(ConnectionEvent.FORBIDDEN);
            return;
        } else if (ex.getMessage().equals(ResourceReader.getErrorMessageWithKey("SignalRUnauthorizedError"))) {
            this.connectionEventSubject.onNext(ConnectionEvent.UNAUTHORIZED);
            return;
        }
        // auto reconnect when no network available (exception is RuntimeException)
        runCallback(autoReconnect(this.resendCallback));
    }

    private Runnable autoResend(final String method, final Object args) {
        return () -> this.invokeHubMethod(method, args);
    }

    private void runCallback(final Runnable callback) {
        callback.run();
    }

    /* CHECKSTYLE_OFF: IllegalCatch */
    private Runnable autoReconnect(final Runnable autoResendCallback) {
        return () -> {
            if (!retryOptions.getEnableAutoReconnect()) {
                return;
            }
            int retryCount = retryOptions.getReconnectCount();
            // ensure the connection is stopped before connecting to server.
            this.stopConnection();
            while(connection.getConnectionState() == HubConnectionState.DISCONNECTED) {
                try {
                    startConnection();
                    this.streamingStopIntentionally = false;
                } catch (final RuntimeException ex) {
                    // delay some time before reconnecting.
                    waitTime(retryOptions.getRestartIntervalInMilliseconds());
                    retryCount--;
                }
                if (connection.getConnectionState() == HubConnectionState.DISCONNECTED && retryCount == 0) {
                    // hook to connection event when retries run out.
                    connectionEventSubject.onNext(ConnectionEvent.RECONNECT_FAILURE);
                    break;
                }
                if(connection.getConnectionState() == HubConnectionState.CONNECTED && autoResendCallback != null) {
                    runCallback(autoResendCallback);
                }
            }
        };
    }

    private void stopConnection() {
        this.connection.stop().blockingAwait();
    }

    private void startConnection() {
        this.connection.start().blockingAwait();
    }
    private Single<Void> invokeHubMethod (final String method, final Object args) {
        return this.connection.invoke(Void.class, method, args);
    }

    private void waitTime(final long waitTimeInMilliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(waitTimeInMilliseconds);
        } catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
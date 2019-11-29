package com.experian.aperture.streaming.client;

import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the connection contract.
 * */
public interface Connection {
    /**
     * Subscribes a method to connection.
     *
     * @param method The connection method to invoke.
     * @param callback The action to invoke request completed.
     * @param param The class of the response.
     * @param <T> The expected response object.
     * */
    <T> void subscribe(String method, ConnectionResponse<T> callback, Class<T> param);

    /**
     * To start the connection.
     *
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     * */
    void start() throws ConnectionException;

    /**
     * To stop the connection.
     * */
    void stop();

    /**
     * To send request to the connection.
     *
     * @param method The method to send the request.
     * @param args The request object.
     * @return A Single that yields the return value when the invocation has completed.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    Single<Void> send(String method, Object args) throws ConnectionException;

    /**
     * To set auto resend callback method to allow resend all requests that has not send to server.
     *
     * @param resendCallback The callback method to resend.
     * */
    void setAutoResendCallback(Runnable resendCallback);

    /**
     * Subscribes to connection events.
     * @return The connection event subject.
     */
    PublishSubject<ConnectionEvent> getConnectionEventSubject();
}

package com.experian.aperture.streaming.client;
import com.experian.aperture.streaming.client.response.ResponseBase;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.SingleSubject;
import javax.swing.*;
/**
 * Stub connection class.
 */
public class StubConnection implements Connection {
    private ResponseBase response;
    public StubConnection(final ResponseBase response) {
        this.response = response;
    }
    @Override
    public <T> void subscribe(final String method, final ConnectionResponse<T> callback, final Class<T> param) {
        callback.invoke((T) response);
    }
    @Override
    public void start() {
    }
    @Override
    public void stop() {
    }
    @Override
    public Single<Void> send(final String method, final Object args) {
        return SingleSubject.create();
    }

    @Override
    public void setAutoResendCallback(final Runnable resendCallback) {
    }

    @Override
    public PublishSubject<ConnectionEvent> getConnectionEventSubject() {
        return null;
    }
}
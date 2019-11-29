package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.ConnectionException;
import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.RequestProxyBase;

import java.util.List;

/**
 * Defines the request resend handler.
 */
public final class RequestResendHandler implements Runnable {
    private final RequestContext requestContext;
    private final Connection connection;
    private final ErrorResponseHandler errorResponseHandler;

    public RequestResendHandler(final RequestContext requestContext, final Connection connection, final ErrorResponseHandler errorResponseHandler) {
        this.requestContext = requestContext;
        this.connection = connection;
        this.errorResponseHandler = errorResponseHandler;
    }

    @Override
    public void run() {
        try {
            sendEmailRequests(this.requestContext.getEmailRequestList().getAll());
            sendPhoneRequests(this.requestContext.getPhoneRequestList().getAll());
            sendEnrichmentRequests(this.requestContext.getEnrichmentRequestList().getAll());
        } catch (final ConnectionException ex) {
            return;
        }
    }

    private void sendEmailRequests(final List<EmailValidationRequestProxy> proxies) throws ConnectionException {
        for (EmailValidationRequestProxy proxy : proxies) {
            send(StreamingMethod.EMAIL_REQUEST, proxy);
        }
    }

    private void sendPhoneRequests(final List<PhoneValidationRequestProxy> proxies) throws ConnectionException {
        for (PhoneValidationRequestProxy proxy : proxies) {
            send(StreamingMethod.PHONE_REQUEST, proxy);
        }
    }

    private void sendEnrichmentRequests(final List<EnrichmentRequestProxy> proxies) throws ConnectionException {
        for (EnrichmentRequestProxy proxy : proxies) {
            send(StreamingMethod.ENRICHMENT_REQUEST, proxy);
        }
    }

    private void send(final StreamingMethod method, final RequestProxyBase proxy) throws ConnectionException {
        this.connection
                .send(method.getValue(), proxy)
                .subscribe((aVoid, throwable) -> this.errorResponseHandler.handle(method, proxy.getReferenceId(), throwable.getMessage()));
    }
}
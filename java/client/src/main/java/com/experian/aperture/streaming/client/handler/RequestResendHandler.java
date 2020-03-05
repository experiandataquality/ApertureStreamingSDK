package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.ConnectionException;
import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.proxy.*;

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
            sendAddressRequests(this.requestContext.getAddressRequestList().getAll());
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

    private void sendAddressRequests(final List<AddressValidationRequestProxy> proxies) throws ConnectionException {
        for (AddressValidationRequestProxy proxy : proxies) {
            send(StreamingMethod.ADDRESS_REQUEST, proxy);
        }
    }

    private void send(final StreamingMethod method, final RequestProxyBase proxy) throws ConnectionException {
        this.connection
                .send(method.getValue(), proxy)
                .subscribe((aVoid, throwable) -> this.errorResponseHandler.handle(method, proxy.getReferenceId(), throwable.getMessage()));
    }
}
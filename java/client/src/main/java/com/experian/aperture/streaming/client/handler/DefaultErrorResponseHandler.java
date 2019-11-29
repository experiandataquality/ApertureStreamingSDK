package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponseFactory;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the default error response handler.
 */
final class DefaultErrorResponseHandler implements ErrorResponseHandler {
    private final RequestContext requestContext;
    private PublishSubject<FailRequestResponse> failRequestSubject;

    DefaultErrorResponseHandler(final RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public void handle(final StreamingMethod method, final String referenceId, final String errorMessage) {
        switch (method) {
            case EMAIL_REQUEST:
                this.requestContext.getEmailRequestList().remove(referenceId);
                break;
            case PHONE_REQUEST:
                this.requestContext.getPhoneRequestList().remove(referenceId);
                break;
            case ENRICHMENT_REQUEST:
                this.requestContext.getEnrichmentRequestList().remove(referenceId);
                break;
            default:
                return;
        }
        this.failRequestSubject.onNext(FailRequestResponseFactory.createFailRequestResponse(method, referenceId, errorMessage));
    }

    @Override
    public void setFailRequestSubject(final PublishSubject<FailRequestResponse> failRequestSubject) {
        this.failRequestSubject = failRequestSubject;
    }
}
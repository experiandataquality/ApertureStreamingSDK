package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import io.reactivex.subjects.PublishSubject;

final class DefaultResponseManager implements ResponseManager {
    private final Connection connection;
    private final RequestContext requestContext;
    private final PublishSubject<FailRequestResponse> failRequestSubject;
    private ErrorResponseHandler errorResponseHandler;

    DefaultResponseManager(final Connection connection, final RequestContext requestContext, final ErrorResponseHandler errorResponseHandler) {
        this.connection = connection;
        this.requestContext = requestContext;
        this.errorResponseHandler = errorResponseHandler;
        this.failRequestSubject = PublishSubject.create();
        this.errorResponseHandler.setFailRequestSubject(this.failRequestSubject);
    }

    @Override
    public void registerDefaultResponseHandlers() {
        this.connection.subscribe(StreamingMethod.EMAIL_RESPONSE.getValue(),
                new EmailResponseHandler(this.requestContext.getEmailRequestList()),
                EmailValidationResponse.class);
        this.connection.subscribe(StreamingMethod.PHONE_RESPONSE.getValue(),
                new PhoneResponseHandler(this.requestContext.getPhoneRequestList()),
                PhoneValidationResponse.class);
        this.connection.subscribe(StreamingMethod.ENRICHMENT_RESPONSE.getValue(),
                new EnrichmentResponseHandler(this.requestContext.getEnrichmentRequestList()),
                EnrichmentResponse.class);
    }

    @Override
    public void registerRequestResendHandler() {
        this.connection.setAutoResendCallback(new RequestResendHandler(this.requestContext, this.connection, this.errorResponseHandler));
    }

    @Override
    public void handleError(final StreamingMethod method, final String referenceId, final String errorMessage) {
        this.errorResponseHandler.handle(method, referenceId, errorMessage);
    }

    @Override
    public PublishSubject<FailRequestResponse> getFailRequestSubject() {
        return this.failRequestSubject;
    }
}
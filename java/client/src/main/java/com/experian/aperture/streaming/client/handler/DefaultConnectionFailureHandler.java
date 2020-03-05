package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.ConnectionEvent;
import com.experian.aperture.streaming.client.ErrorCode;
import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponseFactory;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the default connection failure handler.
 */
final class DefaultConnectionFailureHandler implements ConnectionFailureHandler {
    private final PublishSubject<ConnectionFailResponse> connectionFailureSubject;

    DefaultConnectionFailureHandler() {
        this.connectionFailureSubject = PublishSubject.create();
    }

    @Override
    public void handle(final ConnectionEvent connectionEvent,
                       final List<String> failEmailRequestReferenceIds,
                       final List<String> failPhoneRequestReferenceIds,
                       final List<String> failEnrichmentRequestReferenceIds,
                       final List<String> failAddressRequestReferenceIds) {
        switch (connectionEvent) {
            case RECONNECT_FAILURE:
                this.connectionFailureSubject.onNext(this.createConnectionFailResponse(ErrorCode.RECONNECT_FAILURE, failEmailRequestReferenceIds, failPhoneRequestReferenceIds, failEnrichmentRequestReferenceIds, failAddressRequestReferenceIds));
                break;
            case FORBIDDEN:
                this.connectionFailureSubject.onNext(this.createConnectionFailResponse(ErrorCode.FORBIDDEN_CONNECTION, failEmailRequestReferenceIds, failPhoneRequestReferenceIds, failEnrichmentRequestReferenceIds, failAddressRequestReferenceIds));
                break;
            case UNAUTHORIZED:
                this.connectionFailureSubject.onNext(this.createConnectionFailResponse(ErrorCode.UNAUTHORIZED_CONNECTION, failEmailRequestReferenceIds, failPhoneRequestReferenceIds, failEnrichmentRequestReferenceIds, failAddressRequestReferenceIds));
                break;
            default:
                return;
        }
    }

    @Override
    public PublishSubject<ConnectionFailResponse> getConnectionFailureSubject() {
        return this.connectionFailureSubject;
    }

    private ConnectionFailResponse createConnectionFailResponse(final ErrorCode error,
                                                                final List<String> failEmailRequestReferenceIds,
                                                                final List<String> failPhoneRequestReferenceIds,
                                                                final List<String> failEnrichmentRequestReferenceIds,
                                                                final List<String> failAddressRequestReferenceIds) {
        final List<FailRequestResponse> failRequestResponses = new ArrayList<>();
        final List<FailRequestResponse> emailFailRequestResponses =
                FailRequestResponseFactory.createFailRequestResponses(StreamingMethod.EMAIL_REQUEST, error, failEmailRequestReferenceIds);
        failRequestResponses.addAll(emailFailRequestResponses);
        final List<FailRequestResponse> phoneFailRequestResponses =
                FailRequestResponseFactory.createFailRequestResponses(StreamingMethod.PHONE_REQUEST, error, failPhoneRequestReferenceIds);
        failRequestResponses.addAll(phoneFailRequestResponses);
        final List<FailRequestResponse> enrichmentFailRequestResponses =
                FailRequestResponseFactory.createFailRequestResponses(StreamingMethod.ENRICHMENT_REQUEST, error, failEnrichmentRequestReferenceIds);
        failRequestResponses.addAll(enrichmentFailRequestResponses);
        final List<FailRequestResponse> addressFailRequestResponses =
                FailRequestResponseFactory.createFailRequestResponses(StreamingMethod.ADDRESS_RESPONSE, error, failAddressRequestReferenceIds);
        failRequestResponses.addAll(addressFailRequestResponses);
        return new ConnectionFailResponse(error, failRequestResponses);
    }
}
package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.ConnectionEvent;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import io.reactivex.subjects.PublishSubject;

import java.util.List;

/**
 * Defines the connection failure handler.
 */
public interface ConnectionFailureHandler {
    /**
     * Handles connection failure events.
     * @param connectionEvent The connection event.
     * @param failEmailRequestReferenceIds The list of fail email request reference Ids.
     * @param failPhoneRequestReferenceIds The list of fail phone request reference Ids.
     * @param failEnrichmentRequestReferenceIds The list of fail enrichment request reference Ids.
     * @param failAddressRequestReferenceIds The list of fail address request reference Ids.
     */
    void handle(ConnectionEvent connectionEvent,
                List<String> failEmailRequestReferenceIds,
                List<String> failPhoneRequestReferenceIds,
                List<String> failEnrichmentRequestReferenceIds,
                List<String> failAddressRequestReferenceIds);

    /**
     * Gets the connection failure subject.
     * @return The connection failure subject.
     */
    PublishSubject<ConnectionFailResponse> getConnectionFailureSubject();
}
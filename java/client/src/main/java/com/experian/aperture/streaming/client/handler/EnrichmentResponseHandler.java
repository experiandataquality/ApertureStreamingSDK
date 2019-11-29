package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;

/**
 * Defines the default enrichment response handler.
 */
public class EnrichmentResponseHandler extends BaseResponseHandler<EnrichmentResponse> {
    public EnrichmentResponseHandler(final RequestList requestList) {
        super(requestList);
    }
}
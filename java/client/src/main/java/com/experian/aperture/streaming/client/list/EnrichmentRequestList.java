package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;

import java.util.HashMap;

/**
 * Defines the enrichment request list methods.
 */
public class EnrichmentRequestList extends BaseRequestList<EnrichmentRequestProxy> {
    private HashMap<String, EnrichmentRequestProxy> requests = new HashMap<>();

    @Override
    public HashMap<String, EnrichmentRequestProxy> getRequests() {
        return this.requests;
    }
}
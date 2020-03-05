package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.AddressValidationRequestProxy;

import java.util.HashMap;

/**
 * Defines the address request list methods.
 */
public final class AddressRequestList extends BaseRequestList<AddressValidationRequestProxy> {
    private HashMap<String, AddressValidationRequestProxy> requests = new HashMap<>();

    @Override
    public HashMap<String, AddressValidationRequestProxy> getRequests() {
        return this.requests;
    }
}
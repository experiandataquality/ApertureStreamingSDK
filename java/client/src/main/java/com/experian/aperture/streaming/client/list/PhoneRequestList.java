package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;

import java.util.HashMap;

/**
 * Defines the phone request list methods.
 */
public class PhoneRequestList extends BaseRequestList<PhoneValidationRequestProxy> {
    private HashMap<String, PhoneValidationRequestProxy> requests = new HashMap<>();

    @Override
    public HashMap<String, PhoneValidationRequestProxy> getRequests() {
        return this.requests;
    }
}
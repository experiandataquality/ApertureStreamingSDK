package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;

import java.util.HashMap;

/**
 * Defines the email request list methods.
 */
public class EmailRequestList extends BaseRequestList<EmailValidationRequestProxy> {
    private HashMap<String, EmailValidationRequestProxy> requests = new HashMap<>();

    @Override
    public HashMap<String, EmailValidationRequestProxy> getRequests() {
        return this.requests;
    }
}
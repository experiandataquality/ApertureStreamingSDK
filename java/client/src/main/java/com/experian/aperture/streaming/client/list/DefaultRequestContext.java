package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;

/**
 * Defines the methods to access all request list.
 */
public class DefaultRequestContext implements RequestContext {

    private final EmailRequestList emailRequestList;
    private final PhoneRequestList phoneRequestList;
    private final EnrichmentRequestList enrichmentRequestList;

    public DefaultRequestContext() {
        this.emailRequestList = new EmailRequestList();
        this.phoneRequestList = new PhoneRequestList();
        this.enrichmentRequestList = new EnrichmentRequestList();
    }

    @Override
    public RequestList<EmailValidationRequestProxy> getEmailRequestList() {
        return this.emailRequestList;
    }

    @Override
    public RequestList<PhoneValidationRequestProxy> getPhoneRequestList() {
        return this.phoneRequestList;
    }

    @Override
    public RequestList<EnrichmentRequestProxy> getEnrichmentRequestList() {
        return this.enrichmentRequestList;
    }

    @Override
    public void clearAll() {
        this.emailRequestList.clear();
        this.phoneRequestList.clear();
        this.enrichmentRequestList.clear();
    }
}
package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.AddressValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;

/**
 * Defines the methods to access all request list.
 */
public interface RequestContext {
    /**
     * Gets the email request list.
     * @return The email request list.
     */
    RequestList<EmailValidationRequestProxy> getEmailRequestList();

    /**
     * Gets the phone request list.
     * @return The phone request list.
     */
    RequestList<PhoneValidationRequestProxy> getPhoneRequestList();

    /**
     * Gets the enrichment request list.
     * @return The enrichment request list.
     */
    RequestList<EnrichmentRequestProxy> getEnrichmentRequestList();

    /**
     * Gets the address request list.
     * @return The address request list.
     */
    RequestList<AddressValidationRequestProxy> getAddressRequestList();

    /**
     * Clears all requests.
     */
    void clearAll();
}
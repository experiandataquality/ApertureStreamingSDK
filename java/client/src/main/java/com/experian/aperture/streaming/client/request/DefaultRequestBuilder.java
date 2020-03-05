package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.request.address.DefaultAddressValidationRequestBuilder;
import com.experian.aperture.streaming.client.request.email.DefaultEmailValidationRequestBuilder;
import com.experian.aperture.streaming.client.request.enrichment.DefaultEnrichmentRequestBuilder;
import com.experian.aperture.streaming.client.request.phone.DefaultPhoneValidationRequestBuilder;
/**
 * Defines the default request builder.
 */
public final class DefaultRequestBuilder implements RequestBuilder {
    @Override
    public EmailValidationRequestBuilder withEmailRequest(final String referenceId) {
        return new DefaultEmailValidationRequestBuilder(referenceId);
    }

    @Override
    public PhoneValidationRequestBuilder withPhoneRequest(final String referenceId) {
        return new DefaultPhoneValidationRequestBuilder(referenceId);
    }

    @Override
    public EnrichmentRequestBuilder withEnrichmentRequest(final String referenceId) {
        return new DefaultEnrichmentRequestBuilder(referenceId);
    }

    @Override
    public AddressValidationRequestBuilder withAddressValidationRequest(final String referenceId) {
        return new DefaultAddressValidationRequestBuilder(referenceId);
    }
}
package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;

/**
 * Defines the request builder methods.
 */
public interface RequestBuilder {
    /**
     * Specifies EmailValidation request builder.
     *
     * @param referenceId the reference Id.
     * @return The email request builder.
     */
    EmailValidationRequestBuilder withEmailRequest(String referenceId);

    /**
     * Specifies PhoneValidation request builder.
     *
     * @param referenceId the reference Id.
     * @return The phone request builder.
     */
    PhoneValidationRequestBuilder withPhoneRequest(String referenceId);

    /**
     * Specifies Enrichment request builder.
     *
     * @param referenceId the reference Id.
     * @return The Enrichment request builder.
     */
    EnrichmentRequestBuilder withEnrichmentRequest(String referenceId);

    /**
     * Gets the default request builder.
     *
     * @return The default request builder.
     */
    static RequestBuilder builder() {
        return new DefaultRequestBuilder();
    }

    /**
     * Defines the PhoneValidation request builder.
     */
    interface PhoneValidationRequestBuilder {
        /**
         * Specifies to include a phone number.
         *
         * @param number the phone number.
         * @return The phone validation request builder.
         */
        PhoneValidationRequestBuilder withNumber(String number);

        /**
         * Specifies the type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
         * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
         *
         * @param outputFormat the phone number output format.
         * @return The phone validation request builder.
         */
        PhoneValidationRequestBuilder withOutputFormat(String outputFormat);

        /**
         * Sets the number of days to look back in cache for the validation result for this phone number. If the result is cached, the response will be returned faster. Acceptable values from 0 (no cache) to 30. If not specified, the default value, 7, will be used.
         *
         * @param cacheValueDays The cache value in days.
         * @return The phone validation request builder.
         */
        PhoneValidationRequestBuilder withCacheValueDays(int cacheValueDays);

        /**
         * Builds the phone validation request with the defined values.
         *
         * @return The phone validation request.
         */
        PhoneValidationRequest build();
    }

    /**
     * Defines the EmailValidation request builder.
     */
    interface EmailValidationRequestBuilder {
        /**
         * Specifies to include an email.
         *
         * @param email the phone number.
         * @return The email validation request builder.
         */
        EmailValidationRequestBuilder withEmail(String email);

        /**
         * Builds the email validation request with the defined values.
         *
         * @return The email validation request.
         */
        EmailValidationRequest build();
    }

    /**
     * Defines the Enrichment request builder.
     */
    interface EnrichmentRequestBuilder {
        /**
         * Specifies to include the country.
         *
         * @param country the country.
         * @return The enrichment request builder.
         */
        EnrichmentRequestBuilder withCountry(String country);

        /**
         * Specifies to include the keys.
         *
         * @param keys the datset keys.
         * @return The enrichment request builder.
         */
        EnrichmentRequestBuilder withKeys(EnrichmentDatasetKeys keys);

        /**
         * Specifies to include the attributes.
         *
         * @param attributes the dataset attributes.
         * @return The enrichment request builder.
         */
        EnrichmentRequestBuilder withAttributes(EnrichmentDatasetAttributes attributes);

        /**
         * Builds the enrichment request with the defined values.
         *
         * @return The enrichment request.
         */
        EnrichmentRequest build();
    }
}
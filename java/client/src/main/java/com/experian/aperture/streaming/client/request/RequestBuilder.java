package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
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
     * Specifies Address Validation request builder.
     *
     * @param referenceId the reference Id.
     * @return The address validation request builder.
     */
    AddressValidationRequestBuilder withAddressValidationRequest(String referenceId);

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

    /**
     * Defines the AddressValidation request builder.
     */
    interface AddressValidationRequestBuilder {
        /**
         * Specifies to include the country ISOs.
         * @param countryIso The country ISO list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withCountryIso(String countryIso);

        /**
         * Specifies to include the data sets.
         *
         * @param dataset The data set list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withDataset(String dataset);

        /**
         * Specifies to include the delivery service list.
         *
         * @param deliveryServices The delivery service list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withDeliveryService(String... deliveryServices);

        /**
         * Specifies to include the organizations.
         *
         * @param organizations The organization list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withOrganization(String... organizations);

        /**
         * Specifies to include the sub-buildings.
         *
         * @param subBuildings The sub-building list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withSubBuilding(String... subBuildings);

        /**
         * Specifies to include the buildings.
         *
         * @param buildings The building list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withBuilding(String... buildings);

        /**
         * Specifies to include the streets.
         *
         * @param streets The street list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withStreet(String... streets);

        /**
         * Specifies to include the localities.
         *
         * @param localities The locality list.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withLocality(String... localities);

        /**
         * Specifies to include the postal code.
         *
         * @param postalCode The postal code.
         * @return The address validation request builder.
         */
        AddressValidationRequestBuilder withPostalCode(String postalCode);

        /**
         * Builds the address validation request with the defined values.
         *
         * @return The address validation request.
         */
        AddressValidationRequest build();
    }
}
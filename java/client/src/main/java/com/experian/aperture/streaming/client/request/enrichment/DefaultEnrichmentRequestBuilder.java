package com.experian.aperture.streaming.client.request.enrichment;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBuilder;

/**
 * Defines the default Enrichment request builder.
 */
public final class DefaultEnrichmentRequestBuilder implements RequestBuilder.EnrichmentRequestBuilder {
    private String referenceId;
    private String country;
    private EnrichmentDatasetKeys keys;
    private EnrichmentDatasetAttributes attributes;
    private final String message = ResourceReader.getErrorMessageWithKey("ReferenceIdAlphanumericError");
    private final String referenceIdError = ResourceReader.getErrorMessageWithKey("ReferenceIdLengthError");
    private final String referenceIdRequiredEmptySpaces = ResourceReader.getErrorMessageWithKey("ReferenceIdRequiredEmptySpaceError");

    public DefaultEnrichmentRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaces);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, message);
        this.referenceId = referenceId;
    }

    /**
     * Specifies whether to include the country.
     *
     * @param country the country.
     * @return The enrichment request builder.
     */
    @Override
    public DefaultEnrichmentRequestBuilder withCountry(final String country) {
        Contract.requiresNotEmpty(country, ResourceReader.getErrorMessageWithKey("CountryIsoRequired"));
        this.country = country;
        return this;
    }

    /**
     * Specifies whether to include the keys.
     *
     * @param keys the keys.
     * @return The enrichment request builder.
     */
    @Override
    public DefaultEnrichmentRequestBuilder withKeys(final EnrichmentDatasetKeys keys) {
        Contract.requiresNotNull(keys, ResourceReader.getErrorMessageWithKey("EnrichmentKeyFieldRequired"));
        this.keys = keys;
        return this;
    }

    /**
     * Specifies whether to include the attributes.
     *
     * @param attributes the attributes.
     * @return The enrichment request builder.
     */
    @Override
    public DefaultEnrichmentRequestBuilder withAttributes(final EnrichmentDatasetAttributes attributes) {
        Contract.requiresNotNull(attributes, ResourceReader.getErrorMessageWithKey("EnrichmentAttributesFieldRequired"));
        this.attributes = attributes;
        return this;
    }

    /**
     * Builds the enrichment request with the defined values.
     *
     * @return The enrichment request.
     */
    @Override
    public EnrichmentRequest build() {
        return new EnrichmentRequest(this.referenceId, this.country, this.keys, this.attributes);
    }
}
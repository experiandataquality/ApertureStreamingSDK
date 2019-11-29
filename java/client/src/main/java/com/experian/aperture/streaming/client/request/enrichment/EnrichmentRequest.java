package com.experian.aperture.streaming.client.request.enrichment;

import com.experian.aperture.streaming.client.guard.Contract;

/**
 * The request model.
 */
public final class EnrichmentRequest {
    /**
     * Optional identifier that will be returned in the response. The only way to keep track of the request.
     */
    private String referenceId;

    /**
     * The 3-letter ISO country code.
     */
    private String countryIso;

    /**
     * Keys you can use to search datasets.
     */
    private EnrichmentDatasetKeys keys;

    /**
     * Datasets and their specific attributes.
     */
    private EnrichmentDatasetAttributes attributes;

    EnrichmentRequest(final String referenceId, final String countryIso, final EnrichmentDatasetKeys keys, final EnrichmentDatasetAttributes attributes) {
        Contract.requiresNotEmpty(referenceId, "The reference_id field is required.");
        Contract.requiresNotWhiteSpaces(referenceId, "The reference_id field must not be empty spaces.");
        Contract.requiresNotEmpty(countryIso, "The country_iso field is required.");
        Contract.requiresNotNull(keys, "The keys field is required.");
        Contract.requiresNotNull(attributes, "The attributes field is required.");
        this.referenceId = referenceId;
        this.countryIso = countryIso;
        this.keys = keys;
        this.attributes = attributes;
    }

    /**
     * Gets the referenceId.
     * @return The referenceId.
     */
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Gets the country.
     * @return The country.
     */
    public String getCountryIso() {
        return this.countryIso;
    }

    /**
     * Gets the keys.
     * @return The keys.
     */
    public EnrichmentDatasetKeys getKeys() {
        return this.keys;
    }

    /**
     * Gets the attributes.
     * @return The attributes.
     */
    public EnrichmentDatasetAttributes getAttributes() {
        return this.attributes;
    }
}

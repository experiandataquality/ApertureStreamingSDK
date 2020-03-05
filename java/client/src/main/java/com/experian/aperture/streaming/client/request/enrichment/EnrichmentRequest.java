package com.experian.aperture.streaming.client.request.enrichment;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBase;

/**
 * The request model.
 */
public final class EnrichmentRequest extends RequestBase {
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
        super(referenceId);
        Contract.requiresNotEmpty(countryIso, ResourceReader.getErrorMessageWithKey("CountryIsoRequired"));
        Contract.requiresNotNull(keys, ResourceReader.getErrorMessageWithKey("EnrichmentKeyFieldRequired"));
        Contract.requiresNotNull(attributes, ResourceReader.getErrorMessageWithKey("EnrichmentAttributesFieldRequired"));
        this.countryIso = countryIso;
        this.keys = keys;
        this.attributes = attributes;
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

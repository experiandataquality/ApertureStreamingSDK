package com.experian.aperture.streaming.client.request.enrichment;

/**
 * Defines the enrichment dataset attribtes builder methods.
 */
public interface EnrichmentDatasetAttributesBuilder {
    /**
     * Specifies to include the AusCvPerson.
     *
     * @param ausCvPersonList The ausCvPersonList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCvPersonList(AusCVPerson... ausCvPersonList);

    /**
     * Specifies to include AusCVHousehold.
     *
     * @param ausCvHouseholdList The ausCvHouseholdList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCvHouseholdList(AusCVHousehold... ausCvHouseholdList);

    /**
     * Specifies to include AusCVPostcode.
     *
     * @param ausCvPostcodeList The ausCvPostcodeList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCvPostcodeList(AusCVPostcode... ausCvPostcodeList);

    /**
     * Specifies to include Geocodes.
     *
     * @param geocodeList The geocodeList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withGeocodeList(Geocode... geocodeList);

    /**
     * Builds the enrichment dataset attributes with the defined values.
     *
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributes build();

    /**
     * Gets the default enrichment dataset attributes builder.
     *
     * @return The default enrichment dataset attributes builder.
     */
    static EnrichmentDatasetAttributesBuilder builder() {
        return new DefaultEnrichmentDatasetAttributesBuilder();
    }
}

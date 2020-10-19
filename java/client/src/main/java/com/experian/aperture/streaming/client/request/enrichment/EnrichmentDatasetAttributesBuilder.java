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
     * @param geocodesList The geocodesList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withGeocodesList(Geocodes... geocodesList);

    /**
     * Specifies whether to include USA regional geocodes.
     *
     * @param usaRegionalGeocodesList the usaRegionalGeocodesList.
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withUsaRegionalGeocodesList(UsaRegionalGeocodes... usaRegionalGeocodesList);

    /**
     * Specifies whether to include AUS regional geocodes.
     *
     * @param ausRegionalGeocodesList the ausRegionalGeocodesList.
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusRegionalGeocodesList(AusRegionalGeocodes... ausRegionalGeocodesList);

    /**
     * Specifies whether to include UK Location Essential.
     *
     * @param ukLocationEssentialList The ukLocationEssentialList.
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withUkLocationEssentialList(UkLocationEssential... ukLocationEssentialList);

    /**
     * Specifies whether to include Uk Location Complete.
     *
     * @param ukLocationCompleteList the ukLocationCompleteList.
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withUkLocationCompleteList(UkLocationComplete... ukLocationCompleteList);

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

package com.experian.aperture.streaming.client.request.enrichment;

/**
 * Defines the enrichment dataset attribtes builder methods.
 */
public interface EnrichmentDatasetAttributesBuilder {
    /**
     * Specifies to include the AusCVPerson.
     *
     * @param ausCVPersonList The ausCVPersonList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCVPersonList(AusCVPerson... ausCVPersonList);

    /**
     * Specifies to include AusCVHousehold.
     *
     * @param ausCVHouseholdList The ausCVHouseholdList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCVHouseholdList(AusCVHousehold... ausCVHouseholdList);

    /**
     * Specifies to include AusCVPostcode.
     *
     * @param ausCVPostcodeList The ausCvPostcodeList
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withAusCVPostcodeList(AusCVPostcode... ausCVPostcodeList);

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

    /*
    * Specifies whether to inclue NZL Regional Geocodes.
    *
    * @param nzlRegionalGeocodesList the nzlRegionalGeocodesList.
    * @return The enrichment dataset attributes builder.
    */
    EnrichmentDatasetAttributesBuilder withNzlRegionalGeocodesList(NzlRegionalGeocodes... nzlRegionalGeocodesList);

    /**
     * Specifies whether to include NZL CV Household.
     *
     * @param nzlCVHouseholdList the nzlCVHouseholdList.
     * @return The enrichment dataset attributes builder.
     */
    EnrichmentDatasetAttributesBuilder withNzlCVHouseholdList(NzlCVHousehold... nzlCVHouseholdList);

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

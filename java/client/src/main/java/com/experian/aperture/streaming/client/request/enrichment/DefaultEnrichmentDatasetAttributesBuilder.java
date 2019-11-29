package com.experian.aperture.streaming.client.request.enrichment;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the enrichment dataset attributes builder methods.
 */
public class DefaultEnrichmentDatasetAttributesBuilder implements EnrichmentDatasetAttributesBuilder {
    private List<AusCVPerson> ausCvPerson = new ArrayList<>();
    private List<AusCVHousehold> ausCvHousehold = new ArrayList<>();
    private List<AusCVPostcode> ausCvPostcode = new ArrayList<>();
    private List<Geocode> geocodes = new ArrayList<>();

    /**
     * Specifies whether to include ausCvPerson.
     *
     * @param ausCvPersonList the ausCvPersonList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCvPersonList(final AusCVPerson... ausCvPersonList) {
        for (AusCVPerson i : ausCvPersonList) {
            this.ausCvPerson.add(i);
        }
        return this;
    }

    /**
     * Specifies whether to include ausCvHousehold.
     *
     * @param ausCvHouseholdList the ausCvHouseholdList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCvHouseholdList(final AusCVHousehold... ausCvHouseholdList) {
        for (AusCVHousehold i : ausCvHouseholdList) {
            this.ausCvHousehold.add(i);
        }
        return this;
    }

    /**
     * Specifies whether to include ausCvPostcode.
     *
     * @param ausCvPostcodeList the ausCvPostcodeList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCvPostcodeList(final AusCVPostcode... ausCvPostcodeList) {
        for (AusCVPostcode i : ausCvPostcodeList) {
            this.ausCvPostcode.add(i);
        }
        return this;
    }

    /**
     * Specifies whether to include geocodes.
     *
     * @param geocodeList the geocodeList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withGeocodeList(final Geocode... geocodeList) {
        for (Geocode i: geocodeList) {
            this.geocodes.add(i);
        }
        return this;
    }

    /**
     * Builds the enrichment dataset attributes with the defined values.
     *
     * @return The Enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributes build() {
        final EnrichmentDatasetAttributes attributes = new EnrichmentDatasetAttributes();
        attributes.setAusCvHousehold(this.ausCvHousehold);
        attributes.setAusCvPerson(this.ausCvPerson);
        attributes.setAusCvPostcode(this.ausCvPostcode);
        attributes.setGeocode(this.geocodes);
        return attributes;
    }
}

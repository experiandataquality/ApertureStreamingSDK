package com.experian.aperture.streaming.client.request.enrichment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defines the enrichment dataset attributes builder methods.
 */
public class DefaultEnrichmentDatasetAttributesBuilder implements EnrichmentDatasetAttributesBuilder {
    private List<AusCVPerson> ausCvPerson = new ArrayList<>();
    private List<AusCVHousehold> ausCvHousehold = new ArrayList<>();
    private List<AusCVPostcode> ausCvPostcode = new ArrayList<>();
    private List<Geocodes> geocodes = new ArrayList<>();
    private List<UsaRegionalGeocodes> usaRegionalGeocodes = new ArrayList<>();
    private List<AusRegionalGeocodes> ausRegionalGeocodes = new ArrayList<>();
    private List<UkLocationEssential> ukLocationEssential = new ArrayList<>();
    private List<UkLocationComplete> ukLocationComplete = new ArrayList<>();

    /**
     * Specifies whether to include ausCvPerson.
     *
     * @param ausCvPersonList the ausCvPersonList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCvPersonList(final AusCVPerson... ausCvPersonList) {
        this.ausCvPerson.addAll(Arrays.asList(ausCvPersonList));
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
        this.ausCvHousehold.addAll(Arrays.asList(ausCvHouseholdList));
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
        this.ausCvPostcode.addAll(Arrays.asList(ausCvPostcodeList));
        return this;
    }

    /**
     * Specifies whether to include geocodes.
     *
     * @param geocodesList the geocodesList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withGeocodesList(final Geocodes... geocodesList) {
        this.geocodes.addAll(Arrays.asList(geocodesList));
        return this;
    }

    /**
     * Specifies whether to include USA regional geocodes.
     *
     * @param usaRegionalGeocodesList the usaRegionalGeocodesList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withUsaRegionalGeocodesList(final UsaRegionalGeocodes... usaRegionalGeocodesList) {
        this.usaRegionalGeocodes.addAll(Arrays.asList(usaRegionalGeocodesList));
        return this;
    }

    /**
     * Specifies whether to include AUS regional geocodes.
     *
     * @param ausRegionalGeocodesList the ausRegionalGeocodesList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withAusRegionalGeocodesList(final AusRegionalGeocodes... ausRegionalGeocodesList) {
        this.ausRegionalGeocodes.addAll(Arrays.asList(ausRegionalGeocodesList));
        return this;
    }

    /**
     * Specifies whether to include UK Location Essential.
     *
     * @param ukLocationEssentialList The ukLocationEssentialList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withUkLocationEssentialList(final UkLocationEssential... ukLocationEssentialList) {
        this.ukLocationEssential.addAll(Arrays.asList(ukLocationEssentialList));
        return this;
    }

    /**
     * Specifies whether to include Uk Location Complete.
     *
     * @param ukLocationCompleteList the ukLocationCompleteList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withUkLocationCompleteList(final UkLocationComplete... ukLocationCompleteList) {
        this.ukLocationComplete.addAll(Arrays.asList(ukLocationCompleteList));
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
        attributes.setAusCvHousehold(this.ausCvHousehold.size() > 0 ? this.ausCvHousehold : null);
        attributes.setAusCvPerson(this.ausCvPerson.size() > 0 ? this.ausCvPerson : null);
        attributes.setAusCvPostcode(this.ausCvPostcode.size() > 0 ? this.ausCvPostcode : null);
        attributes.setGeocodes(this.geocodes.size() > 0 ? this.geocodes : null);
        attributes.setUsaRegionalGeocodes(this.usaRegionalGeocodes.size() > 0 ? this.usaRegionalGeocodes : null);
        attributes.setAusRegionalGeocodes(this.ausRegionalGeocodes.size() > 0 ? this.ausRegionalGeocodes : null);
        attributes.setUkLocationEssential(this.ukLocationEssential.size() > 0 ? this.ukLocationEssential : null);
        attributes.setUkLocationComplete(this.ukLocationComplete.size() > 0 ? this.ukLocationComplete : null);
        return attributes;
    }
}

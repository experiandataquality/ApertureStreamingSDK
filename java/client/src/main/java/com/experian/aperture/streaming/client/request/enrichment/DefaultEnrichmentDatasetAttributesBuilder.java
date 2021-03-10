package com.experian.aperture.streaming.client.request.enrichment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defines the enrichment dataset attributes builder methods.
 */
@SuppressWarnings("checkstyle:ClassFanOutComplexity")
public class DefaultEnrichmentDatasetAttributesBuilder implements EnrichmentDatasetAttributesBuilder {
    private List<AusCVPerson> ausCVPerson = new ArrayList<>();
    private List<AusCVHousehold> ausCVHousehold = new ArrayList<>();
    private List<AusCVPostcode> ausCVPostcode = new ArrayList<>();
    private List<Geocodes> geocodes = new ArrayList<>();
    private List<UsaRegionalGeocodes> usaRegionalGeocodes = new ArrayList<>();
    private List<AusRegionalGeocodes> ausRegionalGeocodes = new ArrayList<>();
    private List<UkLocationEssential> ukLocationEssential = new ArrayList<>();
    private List<UkLocationComplete> ukLocationComplete = new ArrayList<>();
    private List<NzlRegionalGeocodes> nzlRegionalGeocodes = new ArrayList<>();
    private List<NzlCVHousehold> nzlCVHouseholds = new ArrayList<>();

    /**
     * Specifies whether to include ausCvPerson.
     *
     * @param ausCVPersonList the ausCvPersonList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCVPersonList(final AusCVPerson... ausCVPersonList) {
        this.ausCVPerson.addAll(Arrays.asList(ausCVPersonList));
        return this;
    }

    /**
     * Specifies whether to include ausCvHousehold.
     *
     * @param ausCVHouseholdList the ausCvHouseholdList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCVHouseholdList(final AusCVHousehold... ausCVHouseholdList) {
        this.ausCVHousehold.addAll(Arrays.asList(ausCVHouseholdList));
        return this;
    }

    /**
     * Specifies whether to include ausCvPostcode.
     *
     * @param ausCVPostcodeList the ausCvPostcodeList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public EnrichmentDatasetAttributesBuilder withAusCVPostcodeList(final AusCVPostcode... ausCVPostcodeList) {
        this.ausCVPostcode.addAll(Arrays.asList(ausCVPostcodeList));
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
     * Specifies whether to include NZL Regional Geocodes.
     *
     * @param nzlRegionalGeocodes the nzlRegionalGeocodes.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withNzlRegionalGeocodesList(final NzlRegionalGeocodes... nzlRegionalGeocodes) {
        this.nzlRegionalGeocodes.addAll(Arrays.asList(nzlRegionalGeocodes));
        return this;
    }

    /**
     * Specifies whether to include New Zealand ConsumerView Household.
     *
     * @param nzlCVHouseholdList the nzlCvHouseholdList.
     * @return The enrichment dataset attributes builder.
     */
    @Override
    public  EnrichmentDatasetAttributesBuilder withNzlCVHouseholdList(final NzlCVHousehold... nzlCVHouseholdList) {
        this.nzlCVHouseholds.addAll(Arrays.asList(nzlCVHouseholdList));
        return this;
    }

    /**
     * Builds the enrichment dataset attributes with the defined values.
     *
     * @return The Enrichment dataset attributes builder.
     */
    @SuppressWarnings("checkstyle:CyclomaticComplexity")
    @Override
    public EnrichmentDatasetAttributes build() {
        final EnrichmentDatasetAttributes attributes = new EnrichmentDatasetAttributes();
        attributes.setAusCVHousehold(this.ausCVHousehold.size() > 0 ? this.ausCVHousehold : null);
        attributes.setAusCVPerson(this.ausCVPerson.size() > 0 ? this.ausCVPerson : null);
        attributes.setAusCVPostcode(this.ausCVPostcode.size() > 0 ? this.ausCVPostcode : null);
        attributes.setGeocodes(this.geocodes.size() > 0 ? this.geocodes : null);
        attributes.setUsaRegionalGeocodes(this.usaRegionalGeocodes.size() > 0 ? this.usaRegionalGeocodes : null);
        attributes.setAusRegionalGeocodes(this.ausRegionalGeocodes.size() > 0 ? this.ausRegionalGeocodes : null);
        attributes.setUkLocationEssential(this.ukLocationEssential.size() > 0 ? this.ukLocationEssential : null);
        attributes.setUkLocationComplete(this.ukLocationComplete.size() > 0 ? this.ukLocationComplete : null);
        attributes.setNzlRegionalGeocodes(this.nzlRegionalGeocodes.size() > 0 ? this.nzlRegionalGeocodes : null);
        attributes.setNzlCVHousehold(this.nzlCVHouseholds.size() > 0 ? this.nzlCVHouseholds : null);
        return attributes;
    }
}

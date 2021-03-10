package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * The dataset name and related attributes.
 */
public final class EnrichmentMetadataDatasets {
    /**
     * The ConsumerView Australia - Household data.
     **/
    @SerializedName("aus_cv_household")
    private EnrichmentAusCVHouseholdMetadata ausCVHousehold;

    /**
     * The ConsumerView Australia - Person data.
     **/
    @SerializedName("aus_cv_person")
    private EnrichmentAusCVPersonMetadata ausCVPerson;

    /**
     * The ConsumerView Australia - Postcode data.
     **/
    @SerializedName("aus_cv_postcode")
    private EnrichmentAusCVPostcodeMetadata ausCVPostcode;

    /**
     * The Geocodes data.
     **/
    @SerializedName("geocodes")
    private EnrichmentGeocodesMetadata geocodes;

    /**
     * The USA Regional Geocodes data.
     **/
    @SerializedName("usa_regional_geocodes")
    private EnrichmentUsaRegionalGeocodesMetadata usaRegionalGeocodes;

    /**
     * The AUS Regional Geocodes data.
     **/
    @SerializedName("aus_regional_geocodes")
    private EnrichmentAusRegionalGeocodesMetadata ausRegionalGeocodes;

    /**
     * The UK Location Essential data.
     **/
    @SerializedName("uk_location_essential")
    private EnrichmentUkLocationEssentialMetadata ukLocationEssential;

    /**
     * The Uk Location Complete data.
     **/
    @SerializedName("uk_location_complete")
    private EnrichmentUkLocationCompleteMetadata ukLocationComplete;

    /**
     * The NZL Regional Geocodes data.
     **/
    @SerializedName("nzl_regional_geocodes")
    private EnrichmentNzlRegionalGeocodesMetadata nzlRegionalGeocodes;

    /**
     * The ConsumerView New Zealand - Household data.
     **/
    @SerializedName("nzl_cv_household")
    private EnrichmentNzlCVHouseholdMetadata nzlCVHousehold;


    /**
     * Gets the ausCVHousehold.
     * @return The ausCVHousehold.
     */
    public EnrichmentAusCVHouseholdMetadata getAusCVHousehold() {
        return this.ausCVHousehold;
    }

    /**
     * Sets the ausCVHousehold.
     * @param ausCVHousehold The ausCVHousehold.
     */
    public void setAusCvHousehold(final EnrichmentAusCVHouseholdMetadata ausCVHousehold) {
        this.ausCVHousehold = ausCVHousehold;
    }

    /**
     * Gets the ausCVPerson.
     * @return The ausCVPerson.
     */
    public EnrichmentAusCVPersonMetadata getAusCVPerson() {
        return this.ausCVPerson;
    }

    /**
     * Sets the ausCVPerson.
     * @param ausCVPerson The ausCVPerson.
     */
    public void setAusCVPerson(final EnrichmentAusCVPersonMetadata ausCVPerson) {
        this.ausCVPerson = ausCVPerson;
    }

    /**
     * Gets the ausCVPostcode.
     * @return The ausCVPostcode.
     */
    public EnrichmentAusCVPostcodeMetadata getAusCVPostcode() {
        return this.ausCVPostcode;
    }

    /**
     * Sets the ausCVPostcode.
     * @param ausCVPostcode The ausCVPostcode.
     */
    public void setAusCVPostcode(final EnrichmentAusCVPostcodeMetadata ausCVPostcode) {
        this.ausCVPostcode = ausCVPostcode;
    }

    /**
     * Gets the geocodes.
     * @return The geocodes.
     * */
    public EnrichmentGeocodesMetadata getGeocodes() {
        return this.geocodes;
    }

    /**
     * Sets the geocodes.
     * @param geocodes The geocodes.
     * */
    public void setGeocodes(final EnrichmentGeocodesMetadata geocodes) {
        this.geocodes = geocodes;
    }

    /**
     * Gets the USA regional geocodes.
     * @return The USA regional geocodes.
     * */
    public EnrichmentUsaRegionalGeocodesMetadata getUsaRegionalGeocodes() {
        return this.usaRegionalGeocodes;
    }

    /**
     * Sets the USA regional geocodes.
     * @param usaRegionalGeocodes The USA regional geocodes.
     * */
    public void setUsaRegionalGeocodes(final EnrichmentUsaRegionalGeocodesMetadata usaRegionalGeocodes) {
        this.usaRegionalGeocodes = usaRegionalGeocodes;
    }

    /**
     * Gets the AUS regional geocodes.
     * @return The AUS regional geocodes.
     * */
    public EnrichmentAusRegionalGeocodesMetadata getAusRegionalGeocodes() {
        return this.ausRegionalGeocodes;
    }

    /**
     * Sets the AUS regional geocodes.
     * @param ausRegionalGeocodes The AUS regional geocodes.
     * */
    public void setAusRegionalGeocodes(final EnrichmentAusRegionalGeocodesMetadata ausRegionalGeocodes) {
        this.ausRegionalGeocodes = ausRegionalGeocodes;
    }

    /**
     * Gets the UK Location Essential.
     * @return The UK Location Essential.
     * */
    public EnrichmentUkLocationEssentialMetadata getUkLocationEssential() {
        return this.ukLocationEssential;
    }

    /**
     * Sets the UK Location Essential.
     * @param ukLocationEssential The UK Location Essential.
     * */
    public void setUkLocationEssential(final EnrichmentUkLocationEssentialMetadata ukLocationEssential) {
        this.ukLocationEssential = ukLocationEssential;
    }

    /**
     * Gets the Uk Location Complete.
     * @return The Uk Location Complete.
     * */
    public EnrichmentUkLocationCompleteMetadata getUkLocationComplete() {
        return this.ukLocationComplete;
    }

    /**
     * Sets the Uk Location Complete.
     * @param ukLocationComplete The Uk Location Complete.
     * */
    public void setUkLocationComplete(final EnrichmentUkLocationCompleteMetadata ukLocationComplete) {
        this.ukLocationComplete = ukLocationComplete;
    }

    /**
     * Gets the NZL Regional Geocodes.
     * @return The NZL Regional Geocodes.
     * */
    public EnrichmentNzlRegionalGeocodesMetadata getNzlRegionalGeocodes() {
        return this.nzlRegionalGeocodes;
    }

    /**
     * Sets the NZL Regional Geocodes.
     * @param nzlRegionalGeocodes The NZL Regional Geocodes.
     * */
    public void setNzlRegionalGeocodes(final EnrichmentNzlRegionalGeocodesMetadata nzlRegionalGeocodes) {
        this.nzlRegionalGeocodes = nzlRegionalGeocodes;
    }

    /**
     * Gets the nzlCVHousehold.
     * @return The NzlCVHousehold.
     */
    public EnrichmentNzlCVHouseholdMetadata getNzlCVHousehold() {
        return this.nzlCVHousehold;
    }

    /**
     * Sets the nzlCVHousehold.
     * @param nzlCVHousehold The ausCVHousehold.
     */
    public void setNzlCvHousehold(final EnrichmentNzlCVHouseholdMetadata nzlCVHousehold) {
        this.nzlCVHousehold = nzlCVHousehold;
    }
}

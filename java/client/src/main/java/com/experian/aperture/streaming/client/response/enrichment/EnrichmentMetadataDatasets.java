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
    private EnrichmentAusCVHouseholdMetadata ausCvHousehold;

    /**
     * The ConsumerView Australia - Person data.
     **/
    @SerializedName("aus_cv_person")
    private EnrichmentAusCVPersonMetadata ausCvPerson;

    /**
     * The ConsumerView Australia - Postcode data.
     **/
    @SerializedName("aus_cv_postcode")
    private EnrichmentAusCVPostcodeMetadata ausCvPostcode;

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
     * Gets the ausCvHousehold.
     * @return The ausCvHousehold.
     */
    public EnrichmentAusCVHouseholdMetadata getAusCvHousehold() {
        return this.ausCvHousehold;
    }

    /**
     * Sets the ausCvHousehold.
     * @param ausCvHousehold The ausCvHousehold.
     */
    public void setAusCvHousehold(final EnrichmentAusCVHouseholdMetadata ausCvHousehold) {
        this.ausCvHousehold = ausCvHousehold;
    }

    /**
     * Gets the ausCvPerson.
     * @return The ausCvPerson.
     */
    public EnrichmentAusCVPersonMetadata getAusCvPerson() {
        return this.ausCvPerson;
    }

    /**
     * Sets the ausCvPerson.
     * @param ausCvPerson The ausCvPerson.
     */
    public void setAusCvPerson(final EnrichmentAusCVPersonMetadata ausCvPerson) {
        this.ausCvPerson = ausCvPerson;
    }

    /**
     * Gets the ausCvPostcode.
     * @return The ausCvPostcode.
     */
    public EnrichmentAusCVPostcodeMetadata getAusCvPostcode() {
        return this.ausCvPostcode;
    }

    /**
     * Sets the ausCvPostcode.
     * @param ausCvPostcode The ausCvPostcode.
     */
    public void setAusCvPostcode(final EnrichmentAusCVPostcodeMetadata ausCvPostcode) {
        this.ausCvPostcode = ausCvPostcode;
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
}

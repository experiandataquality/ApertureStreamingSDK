package com.experian.aperture.streaming.client.response.enrichment;

import com.experian.aperture.streaming.client.response.Result;
import com.google.gson.annotations.SerializedName;

/**
 * Details about the result. Includes the enriched data.
 */
public final class EnrichmentResult implements Result {
    /**
     * The ConsumerView Australia - Household data.
     **/
    @SerializedName("aus_cv_household")
    private EnrichmentDatasetAusCVHousehold ausCVHousehold;

    /**
     * The ConsumerView Australia - Person data.
     **/
    @SerializedName("aus_cv_person")
    private EnrichmentDatasetAusCVPerson ausCVPerson;

    /**
     * The ConsumerView Australia - Postcode data.
     **/
    @SerializedName("aus_cv_postcode")
    private EnrichmentDatasetAusCVPostcode ausCVPostcode;

    /**
     * The Geocodes data.
     **/
    @SerializedName("geocodes")
    private EnrichmentDatasetGeocodes geocodes;

    /**
     * The USA Regional Geocodes data.
     **/
    @SerializedName("usa_regional_geocodes")
    private EnrichmentDatasetUsaRegionalGeocodes usaRegionalGeocodes;

    /**
     * The AUS Regional Geocodes data.
     **/
    @SerializedName("aus_regional_geocodes")
    private EnrichmentDatasetAusRegionalGeocodes ausRegionalGeocodes;

    /**
     * The UK Location Essential data.
     **/
    @SerializedName("uk_location_essential")
    private EnrichmentDatasetUkLocationEssential ukLocationEssential;

    /**
     * The Uk Location Complete data.
     **/
    @SerializedName("uk_location_complete")
    private EnrichmentDatasetUkLocationComplete ukLocationComplete;

    /**
     * The NZL regional geocodes data.
     **/
    @SerializedName("nzl_regional_geocodes")
    private EnrichmentDatasetNzlRegionalGeocodes nzlRegionalGeocodes;

    /**
     * The ConsumerView New Zealand - Household data.
     **/
    @SerializedName("nzl_cv_household")
    private EnrichmentDatasetNzlCVHousehold nzlCVHousehold;

    /**
     * Gets the ausCVHousehold.
     * @return The ausCVHousehold.
     */
    public EnrichmentDatasetAusCVHousehold getAusCVHousehold() {
        return this.ausCVHousehold;
    }

    /**
     * Sets the ausCVHousehold.
     * @param ausCVHousehold The ausCVHousehold.
     */
    public void setAusCvHousehold(final EnrichmentDatasetAusCVHousehold ausCVHousehold) {
        this.ausCVHousehold = ausCVHousehold;
    }

    /**
     * Gets the ausCVPerson.
     * @return The ausCVPerson.
     */
    public EnrichmentDatasetAusCVPerson getAusCVPerson() {
        return this.ausCVPerson;
    }

    /**
     * Sets the ausCVPerson.
     * @param ausCVPerson The ausCVPerson.
     */
    public void setAusCvPerson(final EnrichmentDatasetAusCVPerson ausCVPerson) {
        this.ausCVPerson = ausCVPerson;
    }

    /**
     * Gets the ausCVPostcode.
     * @return The ausCVPostcode.
     */
    public EnrichmentDatasetAusCVPostcode getAusCVPostcode() {
        return this.ausCVPostcode;
    }

    /**
     * Sets the ausCVPostcode.
     * @param ausCVPostcode The ausCVPostcode.
     */
    public void setAusCvPostcode(final EnrichmentDatasetAusCVPostcode ausCVPostcode) {
        this.ausCVPostcode = ausCVPostcode;
    }

    /**
     * Gets the geocodes.
     * @return The geocodes.
     */
    public EnrichmentDatasetGeocodes getGeocodes() {
        return this.geocodes;
    }

    /**
     * Sets the geocodes.
     * @param geocodes The geocodes.
     */
    public void setGeocodes(final EnrichmentDatasetGeocodes geocodes) {
        this.geocodes = geocodes;
    }

    /**
     * Gets the USA regional geocodes.
     * @return The USA regional geocodes.
     */
    public EnrichmentDatasetUsaRegionalGeocodes getUsaRegionalGeocodes() {
        return this.usaRegionalGeocodes;
    }

    /**
     * Sets the USA regional geocodes.
     * @param usaRegionalGeocodes USA regional geocodes.
     */
    public void setUsaRegionalGeocodes(final EnrichmentDatasetUsaRegionalGeocodes usaRegionalGeocodes) {
        this.usaRegionalGeocodes = usaRegionalGeocodes;
    }

    /**
     * Gets the AUS regional geocodes.
     * @return The AUS regional geocodes.
     */
    public EnrichmentDatasetAusRegionalGeocodes getAusRegionalGeocodes() {
        return this.ausRegionalGeocodes;
    }

    /**
     * Sets the AUS regional geocodes.
     * @param ausRegionalGeocodes AUS regional geocodes.
     */
    public void setAusRegionalGeocodes(final EnrichmentDatasetAusRegionalGeocodes ausRegionalGeocodes) {
        this.ausRegionalGeocodes = ausRegionalGeocodes;
    }

    /**
     * Gets the UK Location Essential.
     * @return The UK Location Essential.
     */
    public EnrichmentDatasetUkLocationEssential getUkLocationEssential() {
        return this.ukLocationEssential;
    }

    /**
     * Sets the UK Location Essential.
     * @param ukLocationEssential UK Location Essential.
     */
    public void setUkLocationEssential(final EnrichmentDatasetUkLocationEssential ukLocationEssential) {
        this.ukLocationEssential = ukLocationEssential;
    }

    /**
     * Gets the Uk Location Complete.
     * @return The Uk Location Complete.
     */
    public EnrichmentDatasetUkLocationComplete getUkLocationComplete() {
        return this.ukLocationComplete;
    }

    /**
     * Sets the Uk Location Complete.
     * @param ukLocationComplete Uk Location Complete.
     */
    public void setUkLocationComplete(final EnrichmentDatasetUkLocationComplete ukLocationComplete) {
        this.ukLocationComplete = ukLocationComplete;
    }

    /**
     * Gets the NZL Regional Geocodes.
     * @return The NZL Regional Geocodes.
     */
    public EnrichmentDatasetNzlRegionalGeocodes getNzlRegionalGeocodes() {
        return this.nzlRegionalGeocodes;
    }

    /**
     * Sets the NZL Regional Geocodes.
     * @param nzlRegionalGeocodes NZL Regional Geocodes.
     */
    public void setNzlRegionalGeocodes(final EnrichmentDatasetNzlRegionalGeocodes nzlRegionalGeocodes) {
        this.nzlRegionalGeocodes = nzlRegionalGeocodes;
    }

    /**
     * Gets the nzlCVHousehold.
     * @return The nzlCVHousehold.
     */
    public EnrichmentDatasetNzlCVHousehold getNzlCvHousehold() {
        return this.nzlCVHousehold;
    }

    /**
     * Sets the nzlCVHousehold.
     * @param nzlCVHousehold The nzlCVHousehold.
     */
    public void setNzlCvHousehold(final EnrichmentDatasetNzlCVHousehold nzlCVHousehold) {
        this.nzlCVHousehold = nzlCVHousehold;
    }
}
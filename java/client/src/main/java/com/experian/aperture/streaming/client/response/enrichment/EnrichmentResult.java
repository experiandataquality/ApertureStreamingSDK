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
    private EnrichmentDatasetAusCVHousehold ausCvHousehold;

    /**
     * The ConsumerView Australia - Person data.
     **/
    @SerializedName("aus_cv_person")
    private EnrichmentDatasetAusCVPerson ausCvPerson;

    /**
     * The ConsumerView Australia - Postcode data.
     **/
    @SerializedName("aus_cv_postcode")
    private EnrichmentDatasetAusCVPostcode ausCvPostcode;

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
     * Gets the ausCvHousehold.
     * @return The ausCvHousehold.
     */
    public EnrichmentDatasetAusCVHousehold getAusCvHousehold() {
        return this.ausCvHousehold;
    }

    /**
     * Sets the ausCvHousehold.
     * @param ausCvHousehold The ausCvHousehold.
     */
    public void setAusCvHousehold(final EnrichmentDatasetAusCVHousehold ausCvHousehold) {
        this.ausCvHousehold = ausCvHousehold;
    }

    /**
     * Gets the ausCvPerson.
     * @return The ausCvPerson.
     */
    public EnrichmentDatasetAusCVPerson getAusCvPerson() {
        return this.ausCvPerson;
    }

    /**
     * Sets the ausCvPerson.
     * @param ausCvPerson The ausCvPerson.
     */
    public void setAusCvPerson(final EnrichmentDatasetAusCVPerson ausCvPerson) {
        this.ausCvPerson = ausCvPerson;
    }

    /**
     * Gets the ausCvPostcode.
     * @return The ausCvPostcode.
     */
    public EnrichmentDatasetAusCVPostcode getAusCvPostcode() {
        return this.ausCvPostcode;
    }

    /**
     * Sets the ausCvPostcode.
     * @param ausCvPostcode The ausCvPostcode.
     */
    public void setAusCvPostcode(final EnrichmentDatasetAusCVPostcode ausCvPostcode) {
        this.ausCvPostcode = ausCvPostcode;
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
}
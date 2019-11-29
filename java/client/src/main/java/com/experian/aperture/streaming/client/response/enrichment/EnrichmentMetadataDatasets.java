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
}

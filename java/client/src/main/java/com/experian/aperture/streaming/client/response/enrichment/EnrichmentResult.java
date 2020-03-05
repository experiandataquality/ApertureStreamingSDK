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
    private EnrichmentDatasetGeocode geocodes;

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
    public EnrichmentDatasetGeocode getGeocodes() {
        return this.geocodes;
    }

    /**
     * Sets the geocodes.
     * @param geocodes The geocodes.
     */
    public void setGeocodes(final EnrichmentDatasetGeocode geocodes) {
        this.geocodes = geocodes;
    }
}

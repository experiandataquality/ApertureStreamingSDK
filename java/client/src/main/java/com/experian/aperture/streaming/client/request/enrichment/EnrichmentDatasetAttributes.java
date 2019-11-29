package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Datasets and their specific attributes.
 */
public final class EnrichmentDatasetAttributes {
    /**
     * The dataset named Australia ConsumerView Person Data and its associated attributes.
     */
    @SerializedName("aus_cv_person")
    private List<AusCVPerson> ausCvPerson;

    /**
     * The dataset named Australia ConsumerView Household Data and its associated attributes.
     */
    @SerializedName("aus_cv_household")
    private List<AusCVHousehold> ausCvHousehold;

    /**
     * The dataset named Australia ConsumerView Postcode Data and its associated attributes.
     */
    @SerializedName("aus_cv_postcode")
    private List<AusCVPostcode> ausCvPostcode;

    /**
     * The list of Gecodes Data.
     */
    @SerializedName("geocodes")
    private List<Geocode> geocodes;

    /**
     * Gets the ausCvPerson.
     * @return The ausCvPerson.
     */
    public List<AusCVPerson> getAusCvPerson() {
        return this.ausCvPerson;
    }

    /**
     * Sets the ausCvPerson.
     * @param ausCvPerson The ausCvPerson.
     */
    public void setAusCvPerson(final List<AusCVPerson> ausCvPerson) {
        this.ausCvPerson = ausCvPerson;
    }

    /**
     * Gets the ausCvHousehold.
     * @return The ausCvHousehold.
     */
    public List<AusCVHousehold> getAusCvHousehold() {
        return this.ausCvHousehold;
    }

    /**
     * Sets the ausCvHousehold.
     * @param ausCvHousehold The ausCvHousehold.
     */
    public void setAusCvHousehold(final List<AusCVHousehold> ausCvHousehold) {
        this.ausCvHousehold = ausCvHousehold;
    }

    /**
     * Gets the ausCvPostcode.
     * @return The ausCvPostcode.
     */
    public List<AusCVPostcode> getAusCvPostcode() {
        return this.ausCvPostcode;
    }

    /**
     * Sets the ausCvPostcode.
     * @param ausCvPostcode The ausCvPostcode.
     */
    public void setAusCvPostcode(final List<AusCVPostcode> ausCvPostcode) {
        this.ausCvPostcode = ausCvPostcode;
    }

    /**
     * Gets the list of geocodes.
     * @return The list of geocodes.
     * */
    public List<Geocode> getGeocodes() {
        return this.geocodes;
    }

    /**
     * Sets the list of geocodes data.
     * @param geocodes The geocodes.
     * */
    public void setGeocode(final List<Geocode> geocodes) {
        this.geocodes = geocodes;
    }
}

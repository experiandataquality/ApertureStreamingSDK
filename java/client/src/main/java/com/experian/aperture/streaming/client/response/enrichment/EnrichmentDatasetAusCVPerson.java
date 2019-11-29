package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the Australian ConsumerView Person Data dataset.
 */
public final class EnrichmentDatasetAusCVPerson {
    /**
     * Unique Experian-assigned person identifier.
     * Example: 100000047
     */
    @SerializedName("pin")
    private String pin;

    /**
     * The consumer's gender.
     * Example: F
     */
    @SerializedName("gender")
    private String gender;

    /**
     * Unique Experian-assigned household identifier.
     * Example: 987654326
     */
    @SerializedName("hin")
    private String hin;

    /**
     * The linkage postal code.
     */
    @SerializedName("linkage_postcode")
    private String linkagePostcode;

    /**
     * Gets the pin.
     * @return The pin.
     */
    public String getPin() {
        return this.pin;
    }

    /**
     * Sets the pin.
     * @param pin The pin.
     */
    public void setPin(final String pin) {
        this.pin = pin;
    }

    /**
     * Gets the gender.
     * @return The gender.
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Sets the gender.
     * @param gender The gender.
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * Gets the hin.
     * @return The hin.
     */
    public String getHin() {
        return this.hin;
    }

    /**
     * Sets the hin.
     * @param hin The hin.
     */
    public void setHin(final String hin) {
        this.hin = hin;
    }

    /**
     * Gets the linkagePostcode.
     * @return The linkagePostcode.
     */
    public String getLinkagePostcode() {
        return this.linkagePostcode;
    }

    /**
     * Sets the linkagePostcode.
     * @param linkagePostcode The linkagePostcode.
     */
    public void setLinkagePostcode(final String linkagePostcode) {
        this.linkagePostcode = linkagePostcode;
    }
}

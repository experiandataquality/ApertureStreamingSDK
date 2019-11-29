package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the Australian ConsumerView Person Data dataset.
 */
public final class EnrichmentAusCVPersonMetadata {
    /**
     * Unique Experian-assigned person identifier.
     * Example: 100000047
     */
    @SerializedName("pin")
    private DatasetMetadata pin;

    /**
     * The consumer's gender.
     * Example: F
     */
    @SerializedName("gender")
    private DatasetMetadata gender;

    /**
     * Unique Experian-assigned household identifier.
     * Example: 987654326
     */
    @SerializedName("hin")
    private DatasetMetadata hin;

    /**
     * The linkage postal code.
     */
    @SerializedName("linkage_postcode")
    private DatasetMetadata linkagePostcode;

    /**
     * Gets the pin.
     * @return The pin.
     */
    public DatasetMetadata getPin() {
        return this.pin;
    }

    /**
     * Sets the pin.
     * @param pin The pin.
     */
    public void setPin(final DatasetMetadata pin) {
        this.pin = pin;
    }

    /**
     * Gets the gender.
     * @return The gender.
     */
    public DatasetMetadata getGender() {
        return this.gender;
    }

    /**
     * Sets the gender.
     * @param gender The gender.
     */
    public void setGender(final DatasetMetadata gender) {
        this.gender = gender;
    }

    /**
     * Gets the hin.
     * @return The hin.
     */
    public DatasetMetadata getHin() {
        return this.hin;
    }

    /**
     * Sets the hin.
     * @param hin The hin.
     */
    public void setHin(final DatasetMetadata hin) {
        this.hin = hin;
    }

    /**
     * Gets the linkagePostcode.
     * @return The linkagePostcode.
     */
    public DatasetMetadata getLinkagePostcode() {
        return this.linkagePostcode;
    }

    /**
     * Sets the linkagePostcode.
     * @param linkagePostcode The linkagePostcode.
     */
    public void setLinkagePostcode(final DatasetMetadata linkagePostcode) {
        this.linkagePostcode = linkagePostcode;
    }
}

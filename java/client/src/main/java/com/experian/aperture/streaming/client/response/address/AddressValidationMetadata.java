package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata containing additional data set specific values where relevant.
 */
public final class AddressValidationMetadata {
    /**
     * USPS Delivery Point Validation (DPV) data. Only returned for USA addresses.
     **/
    @SerializedName("dpv")
    private AddressValidationDPV dpv;

    /**
     * The specific identifier value related to the attribute.
     **/
    @SerializedName("code")
    private String code;

    /**
     * The description value related to the attribute.
     **/
    @SerializedName("message")
    private String message;

    /**
     * Gets the code.
     * @return The code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code.
     * @param code The code.
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * Gets the message.
     * @return The message.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message.
     * @param message The message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the dpv.
     * @return The dpv.
     */
    public AddressValidationDPV getDpv() {
        return this.dpv;
    }

    /**
     * Sets the dpv.
     * @param dpv The dpv.
     */
    public void setDpv(final AddressValidationDPV dpv) {
        this.dpv = dpv;
    }

}

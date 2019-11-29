package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * The dataset metadata.
 */
public final class DatasetMetadata {
    /**
     * Attribute-level metadata code.
     * Example: S200
     */
    @SerializedName("code")
    private String code;

    /**
     * Attribute-level metadata message.
     * Example: Match
     */
    @SerializedName("message")
    private String message;

    /**
     * The attribute's value that was returned by the API.
     */
    @SerializedName("value")
    private String value;

    /**
     * Gets the code.
     * @return The code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code. Attribute-level metadata code.
     * Example: S200
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
     * Sets the message. Attribute-level metadata message.
     * Example: Match
     * @param message The message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the value.
     * @return The value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Sets the value. The attribute'svalue that was returned by the API.
     * @param value The value.
     */
    public void setValue(final String value) {
        this.value = value;
    }
}

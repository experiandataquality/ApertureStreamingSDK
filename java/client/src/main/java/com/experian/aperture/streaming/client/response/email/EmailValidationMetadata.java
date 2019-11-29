package com.experian.aperture.streaming.client.response.email;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata containing additional data set specific values where relevant.
 */
public final class EmailValidationMetadata {
    /**
     * The specific identifier value related to the attribute.
     *
     * @return code
     **/
    @SerializedName("code")
    private String code;

    /**
     * The description value related to the attribute.
     *
     * @return message
     **/
    @SerializedName("message")
    private String message;

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
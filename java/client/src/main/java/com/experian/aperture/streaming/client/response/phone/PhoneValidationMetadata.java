package com.experian.aperture.streaming.client.response.phone;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata containing additional dataset specific values where relevant.
 */
public final class PhoneValidationMetadata {
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
     * Details related to the phone number, like Status or Country Name.
     **/
    @SerializedName("phone_detail")
    private PhoneValidationAdditionalPhoneInfo phoneDetail;

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

    public PhoneValidationAdditionalPhoneInfo getPhoneDetail() {
        return this.phoneDetail;
    }

    public void setPhoneDetail(final PhoneValidationAdditionalPhoneInfo phoneDetail) {
        this.phoneDetail = phoneDetail;
    }
}
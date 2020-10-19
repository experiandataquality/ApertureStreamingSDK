package com.experian.aperture.streaming.client.response.phone;

import com.experian.aperture.streaming.client.response.Result;
import com.google.gson.annotations.SerializedName;

/**
 * Details about the result. Includes the validated data and its confidence level.
 */
public final class PhoneValidationResult implements Result {
    /**
     * The phone number that is the subject of the validation.
     * Examples: 6175014020
     **/
    @SerializedName("number")
    private String number;

    /**
     * The validated phone number that is the subject of the validation.
     * Examples: 6175014020
     **/
    @SerializedName("validated_phone_number")
    private String validatedPhoneNumber;

    /**
     * The formatted phone number that is the subject of the validation.
     * Examples: 6175014020
     **/
    @SerializedName("formatted_phone_number")
    private String formattedPhoneNumber;

    /**
     * The type of phone number. Examples: Mobile, Landline.
     **/
    @SerializedName("phone_type")
    private String phoneType;

    /**
     * The outcome (confidence level) of the validation. Examples: Verified, Unknown.
     **/
    @SerializedName("confidence")
    private String confidence;

    /**
     * The portability date of the validation. Examples: 2012-06-27T09:32:09.000Z.
     **/
    @SerializedName("ported_date")
    private String portedDate;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getValidatedPhoneNumber() {
        return this.validatedPhoneNumber;
    }

    public void setValidatedPhoneNumber(final String validatedPhoneNumber) {
        this.validatedPhoneNumber = validatedPhoneNumber;
    }

    public String getFormattedPhoneNumber() {
        return this.formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(final String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public void setPhoneType(final String phoneType) {
        this.phoneType = phoneType;
    }

    public String getConfidence() {
        return this.confidence;
    }

    public void setConfidence(final String confidence) {
        this.confidence = confidence;
    }

    public String getPortedDate() {
        return this.portedDate;
    }

    public void setPortedDate(final String portedDate) {
        this.portedDate = portedDate;
    }
}
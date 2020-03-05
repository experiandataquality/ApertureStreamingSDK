package com.experian.aperture.streaming.client.response.email;

import com.experian.aperture.streaming.client.response.Result;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Details about the result. Includes the validated data and its confidence level.
 */
public final class EmailValidationResult implements Result {
    /**
     * The email address that is the subject of the validation.
     * Examples: support@experian.com
     *
     * @return email
     **/
    @SerializedName("email")
    private String email;

    /**
     * The outcome (confidence level) of the validation. Examples: Verified, Unknown.
     *
     * @return confidence
     **/
    @SerializedName("confidence")
    private String confidence;

    /**
     * The description value related to the attribute.
     *
     * @return message
     **/
    @SerializedName("message")
    private String message;

    /**
     * Additional information on the confidence level. Examples: verified, mailboxFull, unreachable.
     *
     * @return verbose
     **/
    @SerializedName("verbose")
    private String verbose;

    /**
     * A list of more likely email addresses. Suggestions include fixes to syntax errors in
     * the provided email address, typos in domains etc.
     *
     * @return The {@code EmailValidationResult}
     */
    @SerializedName("corrections")
    private List<String> corrections;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getConfidence() {
        return this.confidence;
    }

    public void setConfidence(final String confidence) {
        this.confidence = confidence;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getVerbose() {
        return this.verbose;
    }

    public void setVerbose(final String verbose) {
        this.verbose = verbose;
    }

    public List<String> getCorrections() {
        return this.corrections;
    }

    public void setCorrections(final List<String> corrections) {
        this.corrections = corrections;
    }
}
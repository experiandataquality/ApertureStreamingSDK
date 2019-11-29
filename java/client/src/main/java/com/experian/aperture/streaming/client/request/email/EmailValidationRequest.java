package com.experian.aperture.streaming.client.request.email;

import com.experian.aperture.streaming.client.guard.Contract;

/**
 * The email validation request model.
 */
public class EmailValidationRequest {
    /**
     * Identifier that will be returned in the response to help you track the request.
     */
    private String referenceId;

    /**
     * The email address that is the subject of the validation.
     * Examples: support@experian.com
     **/
    private String email;

    EmailValidationRequest(final String referenceId, final String email) throws  IllegalArgumentException {
        Contract.requiresNotEmpty(referenceId, "The reference_id field is required.");
        Contract.requiresNotWhiteSpaces(referenceId, "The reference_id field must not be empty spaces.");
        Contract.requiresNotEmpty(email, "The email field is required.");
        this.referenceId = referenceId;
        this.email = email;
    }

    /**
     * Gets the reference Id.
     * @return The reference Id.
     */
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Gets the email.
     * @return The email.
     */
    public String getEmail() {
        return this.email;
    }
}
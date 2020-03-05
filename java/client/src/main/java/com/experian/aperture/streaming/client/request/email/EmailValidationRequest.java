package com.experian.aperture.streaming.client.request.email;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBase;

/**
 * The email validation request model.
 */
public class EmailValidationRequest extends RequestBase {
    /**
     * The email address that is the subject of the validation.
     * Examples: support@experian.com
     **/
    private String email;

    EmailValidationRequest(final String referenceId, final String email) throws  IllegalArgumentException {
        super(referenceId);
        Contract.requiresNotEmpty(email, ResourceReader.getErrorMessageWithKey("EmailFieldRequired"));
        this.email = email;
    }

    /**
     * Gets the email.
     * @return The email.
     */
    public String getEmail() {
        return this.email;
    }
}
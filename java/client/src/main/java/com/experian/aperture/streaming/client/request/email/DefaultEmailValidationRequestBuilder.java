package com.experian.aperture.streaming.client.request.email;

import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBuilder;
/**
 * Defines the default EmailValidation request builder.
 */
public final class DefaultEmailValidationRequestBuilder implements RequestBuilder.EmailValidationRequestBuilder {
    private String email;
    private String referenceId;
    private final String message = "The field reference_id must be alphanumeric.";
    private final String referenceIdError = "The field reference_id must be less than 256 characters.";
    private final String referenceIdRequired = "The reference_id field is required.";
    private final String referenceIdRequiredEmptySpaces = "The reference_id field must not be empty spaces.";

    public DefaultEmailValidationRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaces);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, message);
        this.referenceId = referenceId;
    }

    @Override
    public RequestBuilder.EmailValidationRequestBuilder withEmail(final String email) {
        Contract.requiresNotEmpty(email, "The email field is required.");
        this.email = email;
        return this;
    }

    @Override
    public EmailValidationRequest build() {
        return new EmailValidationRequest(this.referenceId, this.email);
    }
}

package com.experian.aperture.streaming.client.request.email;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBuilder;
/**
 * Defines the default EmailValidation request builder.
 */
public final class DefaultEmailValidationRequestBuilder implements RequestBuilder.EmailValidationRequestBuilder {
    private String email;
    private String referenceId;
    private final String message = ResourceReader.getErrorMessageWithKey("ReferenceIdAlphanumericError");
    private final String referenceIdError = ResourceReader.getErrorMessageWithKey("ReferenceIdLengthError");
    private final String referenceIdRequiredEmptySpaces = ResourceReader.getErrorMessageWithKey("ReferenceIdRequiredEmptySpaceError");

    public DefaultEmailValidationRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaces);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, message);
        this.referenceId = referenceId;
    }

    @Override
    public RequestBuilder.EmailValidationRequestBuilder withEmail(final String email) {
        Contract.requiresNotEmpty(email, ResourceReader.getErrorMessageWithKey("EmailFieldRequired"));
        this.email = email;
        return this;
    }

    @Override
    public EmailValidationRequest build() {
        return new EmailValidationRequest(this.referenceId, this.email);
    }
}

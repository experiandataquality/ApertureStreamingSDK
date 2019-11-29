package com.experian.aperture.streaming.client.request.phone;

import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBuilder;
/**
 * Defines the default PhoneValidation request builder.
 */
public final class DefaultPhoneValidationRequestBuilder implements RequestBuilder.PhoneValidationRequestBuilder {
    private final String defaultOutputFormat = "E164";
    private final int defaultCacheValueDays = 7;
    private String number;
    private String referenceId;
    private String outputFormat = defaultOutputFormat;
    private int cacheValueDays = defaultCacheValueDays;
    private final String message = "The field reference_id must be alphanumeric.";
    private final String referenceIdError = "The field reference_id must be less than 256 characters.";
    private final String referenceIdRequired = "The reference_id field is required.";
    private final String referenceIdRequiredEmptySpaces = "The reference_id field must not be empty spaces.";

    public DefaultPhoneValidationRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaces);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, message);
        this.referenceId = referenceId;
    }

    @Override
    public RequestBuilder.PhoneValidationRequestBuilder withNumber(final String number) {
        Contract.requiresNotEmpty(number, "The number field is required.");
        this.number = number;
        return this;
    }

    @Override
    public RequestBuilder.PhoneValidationRequestBuilder withOutputFormat(final String outputFormat) {
        this.outputFormat = outputFormat;
        return this;
    }

    @Override
    public RequestBuilder.PhoneValidationRequestBuilder withCacheValueDays(final int cacheValueDays) {
        this.cacheValueDays = cacheValueDays;
        return this;
    }

    @Override
    public PhoneValidationRequest build() {
        return new PhoneValidationRequest(this.referenceId, this.number, this.outputFormat, this.cacheValueDays);
    }
}

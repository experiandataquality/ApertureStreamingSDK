package com.experian.aperture.streaming.client.request.phone;

import com.experian.aperture.streaming.client.ResourceReader;
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
    private String countryIso;
    private boolean getPortedDate;
    private String outputFormat = defaultOutputFormat;
    private int cacheValueDays = defaultCacheValueDays;
    private final String message = ResourceReader.getErrorMessageWithKey("ReferenceIdAlphanumericError");
    private final String referenceIdError = ResourceReader.getErrorMessageWithKey("ReferenceIdLengthError");
    private final String referenceIdRequiredEmptySpaces = ResourceReader.getErrorMessageWithKey("ReferenceIdRequiredEmptySpaceError");

    public DefaultPhoneValidationRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaces);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, message);
        this.referenceId = referenceId;
    }

    @Override
    public RequestBuilder.PhoneValidationRequestBuilder withNumber(final String number) {
        Contract.requiresNotEmpty(number, ResourceReader.getErrorMessageWithKey("PhoneNumberRequired"));
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
    public RequestBuilder.PhoneValidationRequestBuilder withCountryIso(final String countryIso) {
        this.countryIso = countryIso;
        return this;
    }

    @Override
    public RequestBuilder.PhoneValidationRequestBuilder withGetPortedDate(final boolean getPortedDate) {
        this.getPortedDate = getPortedDate;
        return this;
    }

    @Override
    public PhoneValidationRequest build() {
        return new PhoneValidationRequest(this.referenceId, this.number, this.outputFormat, this.cacheValueDays, this.countryIso, this.getPortedDate);
    }
}
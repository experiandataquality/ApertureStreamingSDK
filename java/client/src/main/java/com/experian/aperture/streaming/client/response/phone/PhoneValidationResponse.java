package com.experian.aperture.streaming.client.response.phone;

import com.experian.aperture.streaming.client.response.ResponseBase;
import com.experian.aperture.streaming.client.response.ResponseError;
import com.google.gson.annotations.SerializedName;

/**
 * The response model.
 */
public final class PhoneValidationResponse extends ResponseBase<PhoneValidationResult> {
    /**
     * Metadata containing additional dataset specific values where relevant.
     **/
    @SerializedName("metadata")
    private final PhoneValidationMetadata metadata;

    @SuppressWarnings("checkstyle:parameterNumber")
    public PhoneValidationResponse(final String referenceId,
                                   final String transactionId,
                                   final ResponseError error,
                                   final PhoneValidationResult result,
                                   final PhoneValidationMetadata metadata,
                                   final long rateLimit,
                                   final long rateRemaining,
                                   final long rateReset) {
        super(referenceId, transactionId, error, result, rateLimit, rateRemaining, rateReset);
        this.metadata = metadata;
    }

    public PhoneValidationMetadata getMetadata() {
        return this.metadata;
    }
}
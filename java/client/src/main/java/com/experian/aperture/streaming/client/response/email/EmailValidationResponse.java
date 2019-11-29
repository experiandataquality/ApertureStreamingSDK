package com.experian.aperture.streaming.client.response.email;

import com.experian.aperture.streaming.client.response.ResponseBase;
import com.experian.aperture.streaming.client.response.ResponseError;
import com.google.gson.annotations.SerializedName;

/**
 * The response model.
 */
public final class EmailValidationResponse extends ResponseBase<EmailValidationResult> {
    /**
     * Metadata containing additional dataset specific values where relevant.
     *
     * @return metadata
     **/
    @SerializedName("metadata")
    private final EmailValidationMetadata metadata;

    @SuppressWarnings("checkstyle:parameterNumber")
    public EmailValidationResponse(final String referenceId,
                                   final String transactionId,
                                   final ResponseError error,
                                   final EmailValidationResult result,
                                   final EmailValidationMetadata metadata,
                                   final Long rateLimit,
                                   final Long rateRemaining,
                                   final Long rateReset) {
        super(referenceId, transactionId, error, result, rateLimit, rateRemaining, rateReset);
        this.metadata = metadata;
    }

    public EmailValidationMetadata getMetadata() {
        return this.metadata;
    }
}
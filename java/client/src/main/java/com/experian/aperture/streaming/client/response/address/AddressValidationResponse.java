package com.experian.aperture.streaming.client.response.address;

import com.experian.aperture.streaming.client.response.ResponseBase;
import com.experian.aperture.streaming.client.response.ResponseError;
import com.google.gson.annotations.SerializedName;

/**
 * The response model.
 */
public final class AddressValidationResponse extends ResponseBase<AddressValidationResult> {
    /**
     * Metadata containing additional dataset specific values where relevant.
     **/
    @SerializedName("metadata")
    private final AddressValidationMetadata metadata;

    @SuppressWarnings("checkstyle:parameterNumber")
    public AddressValidationResponse(final String referenceId,
                                   final String transactionId,
                                   final ResponseError error,
                                   final AddressValidationResult result,
                                   final AddressValidationMetadata metadata,
                                   final Long rateLimit,
                                   final Long rateRemaining,
                                   final Long rateReset) {
        super(referenceId, transactionId, error, result, rateLimit, rateRemaining, rateReset);
        this.metadata = metadata;
    }

    public AddressValidationMetadata getMetadata() {
        return this.metadata;
    }
}

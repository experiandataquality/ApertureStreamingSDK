package com.experian.aperture.streaming.client.response.enrichment;

import com.experian.aperture.streaming.client.response.ResponseBase;
import com.experian.aperture.streaming.client.response.ResponseError;
import com.google.gson.annotations.SerializedName;

/**
 * The response model.
 */
public final class EnrichmentResponse extends ResponseBase<EnrichmentResult> {
    /**
     * The metadata model.
     **/
    @SerializedName("metadata")
    private EnrichmentMetadata metadata;

    @SuppressWarnings("checkstyle:parameterNumber")
    public EnrichmentResponse(final String referenceId,
                              final String transactionId,
                              final ResponseError error,
                              final EnrichmentResult result,
                              final EnrichmentMetadata metadata,
                              final long rateLimit,
                              final long rateRemaining,
                              final long rateReset) {
        super(referenceId, transactionId, error, result, rateLimit, rateRemaining, rateReset);
        this.metadata = metadata;
    }

    public EnrichmentMetadata getMetadata() {
        return metadata;
    }
}

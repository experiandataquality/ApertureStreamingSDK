package com.experian.aperture.streaming.client.response;

import com.experian.aperture.streaming.client.ErrorCode;
import com.experian.aperture.streaming.client.StreamingMethod;

/**
 * Fail request response model.
 */
public final class FailRequestResponse {
    private final StreamingMethod method;
    private final String referenceId;
    private final ErrorCode error;

    public FailRequestResponse(final StreamingMethod method, final String referenceId, final ErrorCode error) {
        this.method = method;
        this.referenceId = referenceId;
        this.error = error;
    }

    /**
     * Gets the streaming method name.
     * @return The method name.
     */
    public StreamingMethod getMethod() {
        return method;
    }

    /**
     * Gets the reference Id of the request.
     * @return The reference Id.
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Gets the error message.
     * @return The error message.
     */
    public ErrorCode getError() {
        return error;
    }
}
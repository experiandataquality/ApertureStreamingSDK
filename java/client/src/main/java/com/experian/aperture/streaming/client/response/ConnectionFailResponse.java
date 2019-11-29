package com.experian.aperture.streaming.client.response;

import com.experian.aperture.streaming.client.ErrorCode;

import java.util.List;

/**
 * Connection fail response model.
 */
public final class ConnectionFailResponse {
    private final ErrorCode error;
    private final List<FailRequestResponse> failRequests;

    public ConnectionFailResponse(final ErrorCode error, final List<FailRequestResponse> failRequests) {
        this.error = error;
        this.failRequests = failRequests;
    }

    /**
     * Gets the error message.
     * @return The error message.
     */
    public ErrorCode getError() {
        return error;
    }

    /**
     * Gets the list of fail requests.
     * @return The fail request list.
     */
    public List<FailRequestResponse> getFailRequests() {
        return failRequests;
    }
}
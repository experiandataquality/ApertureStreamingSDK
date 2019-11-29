package com.experian.aperture.streaming.client.response;

import com.experian.aperture.streaming.client.ErrorCode;
import com.experian.aperture.streaming.client.StreamingMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the fail request response factory methods.
 */
public final class FailRequestResponseFactory {
    private static final String rateLimitErrorCode = "429 (Too Many Request)";
    private static final String entitlementFailedErrorCode = "401 (Unauthorized)";
    private static final String memoryErrorCode = "503 (Service Unavailable)";

    private FailRequestResponseFactory() { }

    /**
     * Creates a fail request response based on the method, reference Id and error message.
     * @param method The validation request method.
     * @param referenceId The reference id of the requests.
     * @param errorMessage The error message thrown from the server.
     * @return The FailRequestResponse.
     */
    public static FailRequestResponse createFailRequestResponse(final StreamingMethod method, final String referenceId, final String errorMessage) {
        if (errorMessage.contains(rateLimitErrorCode)) {
            return new FailRequestResponse(method, referenceId, ErrorCode.RATE_LIMIT_ERROR);
        } else if (errorMessage.contains(entitlementFailedErrorCode)) {
            return new FailRequestResponse(method, referenceId, ErrorCode.ENTITLEMENT_FAILED_ERROR);
        } else if (errorMessage.contains(memoryErrorCode)) {
            return new FailRequestResponse(method, referenceId, ErrorCode.MEMORY_ERROR);
        } else {
            return new FailRequestResponse(method, referenceId, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Creates a list of reconnect fail request responses.
     * @param method The validation request method.
     * @param error The error code.
     * @param referenceIds The list of reference ids.
     * @return The list of fail request responses.
     */
    public static ArrayList<FailRequestResponse> createFailRequestResponses(final StreamingMethod method, final ErrorCode error, final List<String> referenceIds) {
        ArrayList<FailRequestResponse> failRequestResponses = new ArrayList<>();
        for (String referenceId : referenceIds) {
            failRequestResponses.add(new FailRequestResponse(method, referenceId, error));
        }
        return failRequestResponses;
    }
}
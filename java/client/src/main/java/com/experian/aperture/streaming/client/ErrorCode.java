package com.experian.aperture.streaming.client;

/**
 * Defines the type of error that the hub produces.
 */
public enum ErrorCode {
    RATE_LIMIT_ERROR("429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests."),
    ENTITLEMENT_FAILED_ERROR("401 (Unauthorized) The request is not authorized. Check you have entered a valid Token from a deployment that contains an active product license."),
    MEMORY_ERROR("503 (Service Unavailable) The hub is currently busy or down for maintenance. Check status.edq.com or wait 5 minutes and try again."),
    INTERNAL_SERVER_ERROR("500 (Internal server error) An unknown error has occurred."),
    RECONNECT_FAILURE("Failed to re-establish the connection. Please restart the job from latest item successfully submitted."),
    FORBIDDEN_CONNECTION("403 (Forbidden) Failed to establish the connection. This token may have been exceeded the maximum connection limit. Please check all the active connections."),
    UNAUTHORIZED_CONNECTION("401 (Unauthorized) Failed to establish the connection. This token is not authorized. Check you have entered a valid Token from a deployment that contains an active product license."),
    NOT_FOUND("404 (Not Found) Failed to establish the connection. This URL is not valid. Please check you have entered a valid Hub URL.");

    private String value;

    ErrorCode(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
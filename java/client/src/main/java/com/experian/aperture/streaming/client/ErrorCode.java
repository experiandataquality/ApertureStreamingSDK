package com.experian.aperture.streaming.client;

/**
 * Defines the type of error that the hub produces.
 */
public enum ErrorCode {
    RATE_LIMIT_ERROR(ResourceReader.getErrorMessageWithKey("TooManyRequestError")),
    ENTITLEMENT_FAILED_ERROR(ResourceReader.getErrorMessageWithKey("EntitlementFailedError")),
    MEMORY_ERROR(ResourceReader.getErrorMessageWithKey("MemoryError")),
    INTERNAL_SERVER_ERROR(ResourceReader.getErrorMessageWithKey("InternalServerError")),
    RECONNECT_FAILURE(ResourceReader.getErrorMessageWithKey("ReconnectError")),
    FORBIDDEN_CONNECTION(ResourceReader.getErrorMessageWithKey("ForbiddenConnectionError")),
    UNAUTHORIZED_CONNECTION(ResourceReader.getErrorMessageWithKey("UnauthorizedConnectionError")),
    NOT_FOUND(ResourceReader.getErrorMessageWithKey("NotFoundError"));

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
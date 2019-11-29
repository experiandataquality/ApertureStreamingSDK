package com.experian.aperture.streaming.client.guard;

/**
 * Guard methods.
 */
public final class Contract {
    private Contract() { }
    /**
     * Throw an exception if the value is null.
     * @param value The value.
     * @param message The exception message.
     */
    public static void requiresNotNull(final Object value, final String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception if the value is an empty string.
     * @param value The string value.
     * @param message The exception message.
     */
    public static void requiresNotEmpty(final String value, final String message) {
        requiresNotNull(value, message);
        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception if the value is an empty string.
     * @param value The string value.
     * @param message The exception message.
     */
    public static void requiresNotWhiteSpaces(final String value, final String message) {
        requiresNotNull(value, message);
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception if the value doesn't fall in the specified range.
     * @param start The start of the range.
     * @param end The end of the range.
     * @param valueToValidate The value to validate.
     * @param message The response error message.
     * @throws IllegalArgumentException throws the exception.
     */
    public static void requiresWithinRange(final long start, final long end, final long valueToValidate, final String message) {
        if (valueToValidate < start || valueToValidate > end) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception of the value is below the specified minimum value.
     * @param minimumValue The minimum value.
     * @param valueToValidate The value to validate.
     * @param message The response error message.
     * @throws IllegalArgumentException throws the exception.
     */
    public static void requiresGreaterOrEqualThan(final long minimumValue, final long valueToValidate, final String message) {
        if (valueToValidate < minimumValue) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception if the reference id contain illegal characters.
     * @param referenceId The reference id of the requests.
     * @param message The response error message.
     * @throws IllegalArgumentException throws the exception.
     */
    public static void requiresReferenceIdAlphanumeric(final String referenceId, final String message) {
        if (!referenceId.matches("[A-Za-z0-9-:\\s]+")) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throw an exception if the reference id is more than 256 characters..
     * @param referenceId The reference id of the requests.
     * @param message The response error message.
     * @throws IllegalArgumentException throws the exception.
     */
    public static void requiresReferenceIdWithinRange(final String referenceId, final String message) {
        if (referenceId.length() > 256) {
            throw new IllegalArgumentException(message);
        }
    }
}
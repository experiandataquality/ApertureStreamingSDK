package com.experian.aperture.streaming.client.options.email;

import java.time.Duration;

/**
 * The email validation options.
 */
public final class EmailValidationOptions {
    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 3 seconds to 15 seconds.
     */
    private Duration timeout;

    /**
     * Specifies to return additional metadata in response.
     */
    private boolean addMetadata;

    EmailValidationOptions(final boolean addMetadata, final Duration timeout) {
        this.addMetadata = addMetadata;
        this.timeout = timeout;
    }

    /**
     * Gets the timeout to specify the waiting time for validation
     * response.
     * @return The timeout in seconds.
     */
    public Duration getTimeout() {
        return this.timeout;
    }

    /**
     * Gets the additional metadata option. An option that indicates
     * whether to return additional metadata in response.
     * @return The additional metadata option.
     */
    public boolean getAddMetadata() {
        return this.addMetadata;
    }
}
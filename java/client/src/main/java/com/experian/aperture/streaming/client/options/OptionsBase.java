package com.experian.aperture.streaming.client.options;

import java.time.Duration;

/**
 * The base class for OptionsBase.
 */
public abstract class OptionsBase {
    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 3 seconds to 5 seconds.
     */
    private Duration timeout;

    public OptionsBase(final Duration timeout) {
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
}

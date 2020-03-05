package com.experian.aperture.streaming.client.options.email;

import com.experian.aperture.streaming.client.options.OptionsBase;

import java.time.Duration;

/**
 * The email validation options.
 */
public final class EmailValidationOptions extends OptionsBase {

    /**
     * Specifies to return additional metadata in response.
     */
    private boolean addMetadata;

    EmailValidationOptions(final boolean addMetadata, final Duration timeout) {
        super(timeout);
        this.addMetadata = addMetadata;
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
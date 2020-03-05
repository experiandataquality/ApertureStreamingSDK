package com.experian.aperture.streaming.client.options.address;

import com.experian.aperture.streaming.client.options.OptionsBase;

import java.time.Duration;

/**
 * The address validation options.
 */
public final class AddressValidationOptions extends OptionsBase {
    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 3 seconds to 15 seconds.
     */
    private Duration timeout;

    /**
     * Specifies to return additional metadata in response.
     */
    private boolean addMetadata;

    /**
     * Specifies to return include components in response.
     */
    private boolean includeComponents;

    AddressValidationOptions(final boolean addMetadata, final Duration timeout, final boolean includeComponents) {
        super(timeout);
        this.addMetadata = addMetadata;
        this.includeComponents = includeComponents;
    }

    /**
     * Gets the additional metadata option. An option that indicates
     * whether to return additional metadata in response.
     * @return The additional metadata option.
     */
    public boolean getAddMetadata() {
        return this.addMetadata;
    }

    /**
     * Gets the additional include components option. An option that indicates
     * whether to return additional components in response.
     * @return The additional components option.
     */
    public boolean getIncludeComponents() {
        return this.includeComponents;
    }
}

package com.experian.aperture.streaming.client.options.address;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.options.OptionsBuilder;

import java.time.Duration;

/**
 * Defines the default AddressValidation options builder.
 */
public final class DefaultAddressValidationOptionsBuilder implements OptionsBuilder.AddressValidationOptionsBuilder {
    private final String message = ResourceReader.getErrorMessageWithKey("AddressTimeoutFieldRange");
    private final Duration defaultTimeout = Duration.ofSeconds(15);
    private final boolean defaultAddMetadata = true;
    private final boolean defaultIncludeComponents = false;
    private boolean includeComponents = defaultIncludeComponents;
    private Duration timeout = defaultTimeout;
    private final boolean addMetadata;

    public DefaultAddressValidationOptionsBuilder(final boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 2 seconds to 15 seconds.
     * @param timeout the timeout in seconds.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.AddressValidationOptionsBuilder withTimeout(final Duration timeout) {
        Contract.requiresWithinRange(2, 15, timeout.getSeconds(), message);
        this.timeout = timeout;
        return this;
    }

    /**
     * Specifies whether to return include components in response.
     *
     * @param includeComponents the match rule.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.AddressValidationOptionsBuilder withIncludeComponents(final boolean includeComponents) {
        this.includeComponents = includeComponents;
        return this;
    }

    /**
     * Builds the options when sending streaming request with the defined values.
     * @return The address validation options.
     */
    public AddressValidationOptions build() {
        return new AddressValidationOptions(this.addMetadata, this.timeout, this.includeComponents);
    }

    /**
     * Gets the default address validation options values.
     *
     * @return The default address validation options.
     */
    @Override
    public AddressValidationOptions getDefault() {
        return new AddressValidationOptions(defaultAddMetadata, defaultTimeout, defaultIncludeComponents);
    }
}

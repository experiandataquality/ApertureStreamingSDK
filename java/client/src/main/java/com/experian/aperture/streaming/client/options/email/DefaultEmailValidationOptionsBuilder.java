package com.experian.aperture.streaming.client.options.email;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.options.OptionsBuilder;

import java.time.Duration;

/**
 * Defines the default EmailValidation options builder.
 */
public final class DefaultEmailValidationOptionsBuilder implements OptionsBuilder.EmailValidationOptionsBuilder {
    private final String message = ResourceReader.getErrorMessageWithKey("EmailTimeoutFieldRange");
    private final Duration defaultTimeout = Duration.ofSeconds(3);
    private final boolean defaultAddMetadata = true;
    private Duration timeout = defaultTimeout;
    private final boolean addMetadata;

    public DefaultEmailValidationOptionsBuilder(final boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 3 seconds to 5 seconds.
     * @param timeout the timeout in seconds.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.EmailValidationOptionsBuilder withTimeout(final Duration timeout) {
        Contract.requiresWithinRange(3, 15, timeout.getSeconds(), message);
        this.timeout = timeout;
        return this;
    }

    /**
     * Builds the options when sending streaming request with the defined values.
     * @return The email validation options.
     */
    public EmailValidationOptions build() {
        return new EmailValidationOptions(this.addMetadata, this.timeout);
    }

    /**
     * Gets the default email validation options values.
     *
     * @return The default email validation options.
     */
    @Override
    public EmailValidationOptions getDefault() {
        return new EmailValidationOptions(defaultAddMetadata, defaultTimeout);
    }
}

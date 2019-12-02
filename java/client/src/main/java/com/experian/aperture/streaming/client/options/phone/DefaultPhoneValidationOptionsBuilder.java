package com.experian.aperture.streaming.client.options.phone;

import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.options.OptionsBuilder;

import java.time.Duration;

/**
 * Defines the default PhoneValidation options builder.
 */
public final class DefaultPhoneValidationOptionsBuilder implements OptionsBuilder.PhoneValidationOptionsBuilder {
    private final String message = "The field timeout must be between 2 and 15.";
    private final boolean defaultAddMetadata = true;
    private final String defaultOutputFormat = "E164";
    private final int defaultCacheValueDays = 7;
    private final Duration defaultTimeout = Duration.ofSeconds(15);
    private final boolean addMetadata;
    private String outputFormat = defaultOutputFormat;
    private int cacheValueDays = defaultCacheValueDays;
    private Duration timeout = defaultTimeout;

    public DefaultPhoneValidationOptionsBuilder(final boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    /**
     * Specifies the type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
     * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
     * @param outputFormat The output format.
     * @return The phone validation options builder.
     */
    @Override
    public OptionsBuilder.PhoneValidationOptionsBuilder withOutputFormat(final String outputFormat) {
        this.outputFormat = outputFormat;
        return this;
    }

    /**
     * Specifies the number of days to look back in cache for the validation result for this phone number.
     * If the result is cached, the response will be returned faster. Acceptable values from 0 (no cache) to 30.
     * If not specified, the default value, 7, will be used.
     * Examples: 7.
     * @param cacheValueDays The cache value in days.
     * @return The phone validation options builder.
     */
    @Override
    public OptionsBuilder.PhoneValidationOptionsBuilder withCacheValueDays(final int cacheValueDays) {
        this.cacheValueDays = cacheValueDays;
        return this;
    }

    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 3 seconds to 5 seconds.
     * @param timeout the timeout in seconds.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.PhoneValidationOptionsBuilder withTimeout(final Duration timeout) {
        Contract.requiresWithinRange(2, 15, timeout.getSeconds(), message);
        this.timeout = timeout;
        return this;
    }

    /**
     * Builds the options when sending streaming request with the defined values.
     * @return The phone validation options.
     */
    @Override
    public PhoneValidationOptions build() {
        return new PhoneValidationOptions(this.outputFormat, this.cacheValueDays, this.addMetadata, this.timeout);
    }

    /**
     * Gets the default phone validation options values.
     *
     * @return The default phone validation options.
     */
    @Override
    public PhoneValidationOptions getDefault() {
        return new PhoneValidationOptions(defaultOutputFormat, defaultCacheValueDays, defaultAddMetadata, defaultTimeout);
    }
}

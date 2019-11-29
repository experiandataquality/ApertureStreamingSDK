package com.experian.aperture.streaming.client.options;

import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;

import java.time.Duration;

/**
 * Defines the options builder methods.
 */
public interface OptionsBuilder {
    /**
     * Specifies EmailValidation options builder.
     *
     * @param addMetadata the addMetadata.
     * @return The email validation options builder.
     */
    EmailValidationOptionsBuilder withEmailOptions(boolean addMetadata);

    /**
     * Specifies PhoneValidation options builder.
     *
     * @param addMetadata the addMetadata.
     * @return The phone validation options builder.
     */
    PhoneValidationOptionsBuilder withPhoneOptions(boolean addMetadata);

    /**
     * Specifies Enrichment options builder.
     *
     * @param addMetadata the addMetadata.
     * @return The Enrichment options builder.
     */
    EnrichmentOptionsBuilder withEnrichmentOptions(boolean addMetadata);

    /**
     * Gets the default options builder.
     *
     * @return The default options builder.
     */
    static OptionsBuilder builder() {
        return new DefaultOptionsBuilder();
    }

    /**
     * Defines the EmailValidation options builder.
     */
    interface EmailValidationOptionsBuilder {
        /**
         * Specifies the timeout waiting for validation response.
         * Duration should be between 3 seconds to 5 seconds.
         * @param timeout the timeout in seconds.
         * @return The options builder.
         */
        EmailValidationOptionsBuilder withTimeout(Duration timeout);

        /**
         * Builds the options when sending streaming request with the defined values.
         * @return The email validation options.
         */
        EmailValidationOptions build();

        /**
         * Gets the default email validation options values.
         *
         * @return The default email validation options.
         */
        EmailValidationOptions getDefault();
    }

    /**
     * Defines the PhoneValidation options builder.
     */
    interface PhoneValidationOptionsBuilder {
        /**
         * Specifies the type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
         * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
         * @param outputFormat The output format.
         * @return The phone validation options builder.
         */
        PhoneValidationOptionsBuilder withOutputFormat(String outputFormat);

        /**
         * Specifies the number of days to look back in cache for the validation result for this phone number.
         * If the result is cached, the response will be returned faster. Acceptable values from 0 (no cache) to 30.
         * If not specified, the default value, 7, will be used.
         * Examples: 7.
         * @param cacheValueDays The cache value in days.
         * @return The phone validation options builder.
         */
        PhoneValidationOptionsBuilder withCacheValueDays(int cacheValueDays);

        /**
         * Specifies the timeout waiting for validation response.
         * Duration should be between 3 seconds to 5 seconds.
         * @param timeout the timeout in seconds.
         * @return The options builder.
         */
        PhoneValidationOptionsBuilder withTimeout(Duration timeout);

        /**
         * Builds the options when sending streaming request with the defined values.
         * @return The phone validation options.
         */
        PhoneValidationOptions build();

        /**
         * Gets the default phone validation options values.
         *
         * @return The default phone validation options.
         */
        PhoneValidationOptions getDefault();
    }

    /**
     * Defines the Enrichment options builder.
     */
    interface EnrichmentOptionsBuilder {
        /**
         * Specifies whether to return match rule in response.
         * @param matchRule the match rule.
         * @return The options builder.
         */
        EnrichmentOptionsBuilder withMatchRule(String matchRule);
        /**
         * Specifies whether to return linkage rule in response.
         * @param linkageRule the linkage rule.
         * @return The options builder.
         */
        EnrichmentOptionsBuilder withLinkageRule(String linkageRule);

        /**
         * Builds the options when sending streaming request with the defined values.
         * @return The enrichment validation options.
         */
        EnrichmentOptions build();

        /**
         * Gets the default enrichment options values.
         *
         * @return The default enrichment options.
         */
        EnrichmentOptions getDefault();

    }
}
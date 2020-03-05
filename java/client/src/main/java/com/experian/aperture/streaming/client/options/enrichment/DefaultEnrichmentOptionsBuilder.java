package com.experian.aperture.streaming.client.options.enrichment;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.options.OptionsBuilder;

import java.time.Duration;

/**
 * Defines the default Enrichment options builder.
 */
public final class DefaultEnrichmentOptionsBuilder implements OptionsBuilder.EnrichmentOptionsBuilder {
    private final String message = ResourceReader.getErrorMessageWithKey("EnrichmentTimeoutFieldRange");
    private final boolean defaultAddMetadata = true;
    private final Duration defaultTimeout = Duration.ofSeconds(15);
    private final boolean addMetadata;
    private String matchRule;
    private String linkageRule;
    private Duration timeout = defaultTimeout;

    public DefaultEnrichmentOptionsBuilder(final boolean addMetadata) {
        this.addMetadata = addMetadata;
    }

    /**
     * Specifies whether to return match rule in response.
     * @param matchRule the match rule.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.EnrichmentOptionsBuilder withMatchRule(final String matchRule) {
        this.matchRule = matchRule;
        return this;
    }

    /**
     * Specifies whether to return linkage rule in response.
     * @param linkageRule the linkage rule.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.EnrichmentOptionsBuilder withLinkageRule(final String linkageRule) {
        this.linkageRule = linkageRule;
        return this;
    }

    /**
     * Specifies the timeout waiting for validation response.
     * Duration should be between 2 seconds to 15 seconds.
     * @param timeout the timeout in seconds.
     * @return The options builder.
     */
    @Override
    public OptionsBuilder.EnrichmentOptionsBuilder withTimeout(final Duration timeout) {
        Contract.requiresWithinRange(2, 15, timeout.getSeconds(), message);
        this.timeout = timeout;
        return this;
    }

    /**
     * Builds the options when sending streaming request with the defined values.
     * @return The enrichment validation options.
     */
    @Override
    public EnrichmentOptions build() {
        return new EnrichmentOptions(this.addMetadata, this.matchRule, this.linkageRule, this.timeout);
    }

    /**
     * Gets the default enrichment validation options values.
     *
     * @return The default enrichment validation options.
     */
    @Override
    public EnrichmentOptions getDefault() {
        return new EnrichmentOptions(defaultAddMetadata, null, null, defaultTimeout);
    }
}

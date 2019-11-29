package com.experian.aperture.streaming.client.options.enrichment;

import com.experian.aperture.streaming.client.options.OptionsBuilder;

/**
 * Defines the default Enrichment options builder.
 */
public final class DefaultEnrichmentOptionsBuilder implements OptionsBuilder.EnrichmentOptionsBuilder {
    private final boolean defaultAddMetadata = true;
    private final boolean addMetadata;
    private String matchRule;
    private String linkageRule;

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
     * Builds the options when sending streaming request with the defined values.
     * @return The enrichment validation options.
     */
    @Override
    public EnrichmentOptions build() {
        return new EnrichmentOptions(this.addMetadata, this.matchRule, this.linkageRule);
    }

    /**
     * Gets the default enrichment validation options values.
     *
     * @return The default enrichment validation options.
     */
    @Override
    public EnrichmentOptions getDefault() {
        return new EnrichmentOptions(defaultAddMetadata, null, null);
    }
}

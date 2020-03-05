package com.experian.aperture.streaming.client.options.enrichment;

import com.experian.aperture.streaming.client.options.OptionsBase;

import java.time.Duration;

/**
 * The enrichment validation options.
 */
public final class EnrichmentOptions extends OptionsBase {
    /**
     * Ignore, currently only "Strict" is supported.
     */
    private String matchRule;

    /**
     * Ignore, currently only "None" is supported.
     */
    private String linkageRule;

    /**
     * Specifies to return additional metadata in response.
     */
    private boolean addMetadata;

    EnrichmentOptions(final boolean addMetadata, final String matchRule, final String linkageRule, final Duration timeout) {
        super(timeout);
        this.addMetadata = addMetadata;
        this.matchRule = matchRule;
        this.linkageRule = linkageRule;
    }

    /**
     * Gets the match rule.
     * @return The match rule.
     */
    public String getMatchRule() {
        return this.matchRule;
    }

    /**
     * Gets the linkage rule.
     * @return The linkage rule.
     */
    public String getLinkageRule() {
        return this.linkageRule;
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
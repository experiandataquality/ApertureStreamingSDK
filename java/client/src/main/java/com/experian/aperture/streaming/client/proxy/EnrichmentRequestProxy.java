package com.experian.aperture.streaming.client.proxy;

import com.experian.aperture.streaming.client.Versions;
import com.experian.aperture.streaming.client.request.enrichment.EnrichmentRequest;
import com.experian.aperture.streaming.client.request.enrichment.EnrichmentDatasetKeys;
import com.experian.aperture.streaming.client.request.enrichment.EnrichmentDatasetAttributes;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.google.gson.annotations.SerializedName;

/**
 * Proxy class for enrichment request.
 */
public final class EnrichmentRequestProxy extends RequestProxyBase {
    @SerializedName("keys")
    private final EnrichmentDatasetKeys keys;

    @SerializedName("attributes")
    private final EnrichmentDatasetAttributes attributes;

    @SerializedName("country_iso")
    private final String countryIso;

    @SerializedName("match_rule")
    private final String matchRule;

    @SerializedName("linkage_rule")
    private final String linkageRule;

    public EnrichmentRequestProxy(final EnrichmentRequest request, final EnrichmentOptions options) {
        super(Versions.ENRICHMENT_REQUEST, request.getReferenceId(), options.getAddMetadata());
        this.keys = request.getKeys();
        this.attributes = request.getAttributes();
        this.countryIso = request.getCountryIso();
        this.matchRule = options.getMatchRule();
        this.linkageRule = options.getLinkageRule();
    }

    public EnrichmentDatasetKeys getKeys() {
        return this.keys;
    }

    public EnrichmentDatasetAttributes getAttributes() {
        return this.attributes;
    }

    public String getCountryIso() {
        return this.countryIso;
    }

    public String getMatchRule() {
        return this.matchRule;
    }

    public String getLinkageRule() {
        return this.linkageRule;
    }
}

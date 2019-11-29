package com.experian.aperture.streaming.client.request.enrichment;

/**
 * Defines the enrichment dataset keys builder methods.
 */
public class DefaultEnrichmentDatasetKeysBuilder implements EnrichmentDatasetKeysBuilder {
    private String pin;
    private String emailAddress;
    private String mobile;
    private String dpid;
    private String gnafPid;
    private String hin;
    private String postcode;
    private String globalAddressKey;

    /**
     * Specifies whether to include a pin.
     *
     * @param pin the pin.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withPin(final String pin) {
        this.pin = pin;
        return this;
    }

    /**
     * Specifies whether to include a emailAddress.
     *
     * @param emailAddress the emailAddress.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Specifies whether to include a mobile.
     *
     * @param mobile the mobile.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withMobile(final String mobile) {
        this.mobile = mobile;
        return this;
    }

    /**
     * Specifies whether to include a dpid.
     *
     * @param dpid the dpid.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withDpid(final String dpid) {
        this.dpid = dpid;
        return this;
    }

    /**
     * Specifies whether to include a gnafPid.
     *
     * @param gnafPid the gnafPid.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withGnafPid(final String gnafPid) {
        this.gnafPid = gnafPid;
        return this;
    }

    /**
     * Specifies whether to include a hin.
     *
     * @param hin the hin.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withHin(final String hin) {
        this.hin = hin;
        return this;
    }

    /**
     * Specifies whether to include a postcode.
     *
     * @param postcode the postcode.
     * @return The enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeysBuilder withPostcode(final String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Specifies whether to include global address key.
     * @param globalAddressKey The global address key.
     * @return The enrichment dataset keys builder.
     * */
    @Override
    public EnrichmentDatasetKeysBuilder withGlobalAddressKey(final String globalAddressKey) {
        this.globalAddressKey = globalAddressKey;
        return this;
    }

    /**
     * Builds the enrichment DatasetKeys with the defined values.
     *
     * @return The Enrichment dataset keys builder.
     */
    @Override
    public EnrichmentDatasetKeys build() {
        final EnrichmentDatasetKeys keys = new EnrichmentDatasetKeys();
        keys.setPin(this.pin);
        keys.setEmailAddress(this.emailAddress);
        keys.setMobile(this.mobile);
        keys.setDpid(this.dpid);
        keys.setGnafPid(this.gnafPid);
        keys.setHin(this.hin);
        keys.setPostcode(this.postcode);
        keys.setGlobalAddressKey(this.globalAddressKey);
        return keys;
    }
}

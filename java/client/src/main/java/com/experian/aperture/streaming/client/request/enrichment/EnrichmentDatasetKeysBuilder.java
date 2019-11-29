package com.experian.aperture.streaming.client.request.enrichment;

/**
 * Defines the enrichment dataset keys builder methods.
 */
public interface EnrichmentDatasetKeysBuilder {
    /**
     * Specifies to include the pin.
     *
     * @param pin the pin.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withPin(String pin);

    /**
     * Specifies to include the emailAddress.
     *
     * @param emailAddress The emailAddress.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withEmailAddress(String emailAddress);

    /**
     * Specifies to include the mobile.
     *
     * @param mobile The mobile.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withMobile(String mobile);

    /**
     * Specifies to include the dpid.
     *
     * @param dpid The dpid.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withDpid(String dpid);

    /**
     * Specifies to include the gnafPid.
     *
     * @param gnafPid The gnafPid.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withGnafPid(String gnafPid);

    /**
     * Specifies to include the hin.
     *
     * @param hin The hin.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withHin(String hin);

    /**
     * Specifies to include the postcode.
     *
     * @param postcode The postcode.
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeysBuilder withPostcode(String postcode);

    /**
     * Spedifies to include the global address key.
     *
     * @param globalAddressKey The global address key.
     * @return The enrichment dataset keys builder.
     * */
    EnrichmentDatasetKeysBuilder withGlobalAddressKey(String globalAddressKey);

    /**
     * Builds the enrichment dataset keys with the defined values.
     *
     * @return The enrichment dataset keys builder.
     */
    EnrichmentDatasetKeys build();

    /**
     * Gets the default enrichment dataset keys builder.
     *
     * @return The default enrichment dataset keys builder.
     */
    static EnrichmentDatasetKeysBuilder builder() {
        return new DefaultEnrichmentDatasetKeysBuilder();
    }
}

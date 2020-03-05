package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;

/**
 * Builder to create ExperianApertureStreamingClient.
 */
final class DefaultClientBuilder implements ClientBuilder, ClientBuilder.ClientConfigurationBuilder {
    private RequestManager requestManager;
    private EmailValidationOptions emailValidationOptions = OptionsBuilder.builder().withEmailOptions(true).getDefault();
    private EnrichmentOptions enrichmentOptions =  OptionsBuilder.builder().withEnrichmentOptions(true).getDefault();
    private PhoneValidationOptions phoneValidationOptions = OptionsBuilder.builder().withPhoneOptions(true).getDefault();
    private AddressValidationOptions addressValidationOptions = OptionsBuilder.builder().withAddressOptions(true).getDefault();

    /**
     * Specifies the streaming endpoint url.
     *
     * @param requestManager The request manager.
     * @return The authentication builder.
     */
    public ClientConfigurationBuilder create(final RequestManager requestManager) {
        this.requestManager = requestManager;
        return this;
    }

    /**
     * Specifies the email validation options when streaming.
     *
     * @param options The email validation options.
     * @return The streaming client builder.
     */
    public ClientConfigurationBuilder withEmailOptions(final EmailValidationOptions options) {
        this.emailValidationOptions = options;
        return this;
    }

    /**
     * Specifies the enrichment options when streaming.
     *
     * @param options The email validation options.
     * @return The streaming client builder.
     */
    public ClientConfigurationBuilder withEnrichmentOptions(final EnrichmentOptions options) {
        this.enrichmentOptions = options;
        return this;
    }

    /**
     * Specifies the phone validation options when streaming.
     *
     * @param options The phone validation options.
     * @return The streaming client builder.
     */
    public ClientConfigurationBuilder withPhoneOptions(final PhoneValidationOptions options) {
        this.phoneValidationOptions = options;
        return this;
    }

    /**
     * Specifies the address validation options when streaming.
     *
     * @param options The address validation options.
     * @return The streaming client builder.
     */
    public ClientConfigurationBuilder withAddressOptions(final AddressValidationOptions options) {
        this.addressValidationOptions = options;
        return this;
    }

    /**
     * Build the streaming client based on the configured options.
     *
     * @return The streaming client.
     */
    @Override
    public Client build() {
        final Client client = new DefaultClient(this.requestManager);
        client.setEmailOptions(this.emailValidationOptions);
        client.setEnrichmentOptions(this.enrichmentOptions);
        client.setPhoneOptions(this.phoneValidationOptions);
        client.setAddressOptions(this.addressValidationOptions);
        return client;
    }
}
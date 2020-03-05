package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;

/**
 * Defines the client builder method.
 * */
public interface ClientBuilder {
    /**
     * Specifies the streaming endpoint url.
     *
     * @param requestManager The request manager.
     * @return The authentication builder.
     */
    ClientConfigurationBuilder create(RequestManager requestManager);

    /**
     * Defines the client configuration builder method.
     * */
    interface ClientConfigurationBuilder {
        /**
         * Specifies the email validation options when streaming.
         *
         * @param options The email validation options.
         * @return The streaming client builder.
         */
        ClientConfigurationBuilder withEmailOptions(EmailValidationOptions options);

        /**
         * Specifies the enrichment options when streaming.
         *
         * @param options The enrichment validation options.
         * @return The streaming client builder.
         */
        ClientConfigurationBuilder withEnrichmentOptions(EnrichmentOptions options);

        /**
         * Specifies the phone validation options when streaming.
         *
         * @param options The phone validation options.
         * @return The streaming client builder.
         */
        ClientConfigurationBuilder withPhoneOptions(PhoneValidationOptions options);

        /**
         * Specifies the address validation options when streaming.
         *
         * @param options The address validation options.
         * @return The streaming client builder.
         */
        ClientConfigurationBuilder withAddressOptions(AddressValidationOptions options);

        /**
         * Build the streaming client based on the configured options.
         *
         * @return The streaming client.
         */
        Client build();
    }

    static ClientBuilder builder() {
        return new DefaultClientBuilder();
    }
}

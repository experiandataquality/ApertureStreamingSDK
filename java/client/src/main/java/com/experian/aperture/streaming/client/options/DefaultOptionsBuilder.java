package com.experian.aperture.streaming.client.options;

import com.experian.aperture.streaming.client.options.email.DefaultEmailValidationOptionsBuilder;
import com.experian.aperture.streaming.client.options.enrichment.DefaultEnrichmentOptionsBuilder;
import com.experian.aperture.streaming.client.options.phone.DefaultPhoneValidationOptionsBuilder;

/**
 * Defines the default options builder.
 */
public final class DefaultOptionsBuilder implements OptionsBuilder {
    @Override
    public EmailValidationOptionsBuilder withEmailOptions(final boolean addMetadata) {
        return new DefaultEmailValidationOptionsBuilder(addMetadata);
    }

    @Override
    public PhoneValidationOptionsBuilder withPhoneOptions(final boolean addMetadata) {
        return new DefaultPhoneValidationOptionsBuilder(addMetadata);
    }

    @Override
    public EnrichmentOptionsBuilder withEnrichmentOptions(final boolean addMetadata) {
        return new DefaultEnrichmentOptionsBuilder(addMetadata);
    }
}

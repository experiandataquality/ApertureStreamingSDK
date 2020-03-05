package com.experian.aperture.streaming.client.options;

import java.time.Duration;

/**
 * The AddressValidationOptionsClientBuilderSteps.
 * */
public class AddressValidationOptionsBuilderSteps {
    private OptionsBuilder builder;

    public AddressValidationOptionsBuilderSteps whenISetTimeout(final long seconds) {
        builder.withAddressOptions(true).withTimeout(Duration.ofSeconds(seconds)).build();
        return this;
    }

    public AddressValidationOptionsBuilderSteps givenIHaveOptions() {
        this.builder = OptionsBuilder.builder();
        return this;
    }
}

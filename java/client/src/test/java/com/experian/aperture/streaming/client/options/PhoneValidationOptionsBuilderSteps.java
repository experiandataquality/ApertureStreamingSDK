package com.experian.aperture.streaming.client.options;

import java.time.Duration;

/**
 * The PhoneValidationsOptionsBuilderSteps.
 * */
public class PhoneValidationOptionsBuilderSteps {
    private OptionsBuilder builder;

    /**
     * Method to create DefaultOptionsBuilder.
     * @param seconds The duration of seconds.
     * @return The DefaultOptionsBuilderSteps.
     * */
    public PhoneValidationOptionsBuilderSteps whenISetTimeoutForPhone(final long seconds) {
        builder.withPhoneOptions(true).withTimeout(Duration.ofSeconds(seconds)).build();
        return this;
    }

    /**
     * Method to create DefaultOptionsBuilder.
     * @return The DefaultOptionsBuilderSteps.
     * */
    public PhoneValidationOptionsBuilderSteps givenIHaveOptions() {
        this.builder = OptionsBuilder.builder();
        return this;
    }
}

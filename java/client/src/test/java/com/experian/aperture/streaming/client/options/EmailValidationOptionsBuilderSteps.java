package com.experian.aperture.streaming.client.options;

import java.time.Duration;

/**
 * The DefaultClientBuilderSteps.
 * */
public class EmailValidationOptionsBuilderSteps {
    private OptionsBuilder builder;

    /**
     * Method to create DefaultOptionsBuilder.
     * @param seconds The duration of seconds.
     * @return The DefaultOptionsBuilderSteps.
     * */
    public EmailValidationOptionsBuilderSteps whenISetTimeout(final long seconds) {
        builder.withEmailOptions(true).withTimeout(Duration.ofSeconds(seconds)).build();
        return this;
    }

    /**
     * Method to create DefaultOptionsBuilder.
     * @return The DefaultOptionsBuilderSteps.
     * */
    public EmailValidationOptionsBuilderSteps givenIHaveOptions() {
        this.builder = OptionsBuilder.builder();
        return this;
    }
}
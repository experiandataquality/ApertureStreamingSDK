package com.experian.aperture.streaming.client.options;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * DefaultOptionsBuilderTest.
 * */
public class EmailValidationOptionsBuilderTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private EmailValidationOptionsBuilderSteps steps = new EmailValidationOptionsBuilderSteps();

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForEmail() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The field timeout must be between 3 and 15.");
        steps
             .givenIHaveOptions()
             .whenISetTimeout(1);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForEmailWhenTimeoutIsAboveMaximum() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The field timeout must be between 3 and 15.");
        steps
                .givenIHaveOptions()
                .whenISetTimeout(16);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldNotGetTimeoutErrorResponseForEmail() {
        steps
            .givenIHaveOptions()
            .whenISetTimeout(3);
    }
}

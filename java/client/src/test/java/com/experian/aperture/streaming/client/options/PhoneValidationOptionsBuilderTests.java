package com.experian.aperture.streaming.client.options;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * PhoneOptionsBuilderTest.
 * */
public class PhoneValidationOptionsBuilderTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private PhoneValidationOptionsBuilderSteps steps = new PhoneValidationOptionsBuilderSteps();

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForPhone() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The field timeout must be between 2 and 15.");
        steps
                .givenIHaveOptions()
                .whenISetTimeoutForPhone(1);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForPhoneWhenTimeoutIsAboveMaximum() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The field timeout must be between 2 and 15.");
        steps
                .givenIHaveOptions()
                .whenISetTimeoutForPhone(16);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldNotGetTimeoutErrorResponseForPhone() {
        steps
                .givenIHaveOptions()
                .whenISetTimeoutForPhone(2);
    }
}

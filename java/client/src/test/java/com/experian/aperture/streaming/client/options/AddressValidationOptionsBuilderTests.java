package com.experian.aperture.streaming.client.options;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * AddressOptionsBuilderTest.
 * */
public class AddressValidationOptionsBuilderTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private AddressValidationOptionsBuilderSteps steps = new AddressValidationOptionsBuilderSteps();

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForAddress() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The timeout field must be between 2 and 15.");
        steps
            .givenIHaveOptions()
            .whenISetTimeout(1);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldGetTimeoutErrorResponseForAddressWhenTimeoutIsAboveMaximum() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("The timeout field must be between 2 and 15.");
        steps
            .givenIHaveOptions()
            .whenISetTimeout(16);
    }

    /**
     * Test to return timeout error response..
     * */
    @Test
    public void shouldNotGetTimeoutErrorResponseForAddress() {
        steps
            .givenIHaveOptions()
            .whenISetTimeout(3);
    }
}

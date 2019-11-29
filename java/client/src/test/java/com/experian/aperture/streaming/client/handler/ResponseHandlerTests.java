package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.response.ResponseError;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * ResponseHandler tests.
 */
public final class ResponseHandlerTests {
    private ResponseHandlerSteps steps;
    private final String referenceId = "ref-id";
    private final Long rateRemaining = Long.valueOf(2700);
    private final Long rateReset = Long.MAX_VALUE;

    /**
     * Setup before each test.
     */
    @Before
    public void setUp() {
        this.steps = new ResponseHandlerSteps();
    }

    /**
     * Assert that response is removed and rate limit is registered.
     */
    @Test
    public void invokeEmailResponseHandler_shouldRemoveResponseAndRegisterRateLimit() {
        final EmailValidationResponse response = new EmailValidationResponse(referenceId, "", null, null, null, Long.MIN_VALUE, rateRemaining, rateReset);
        this.steps
                .givenISetupEmailResponseHandler()
                .whenIInvokeResponseHandler(response)
                .thenRemoveIsInvoked(1, referenceId)
                .thenRegisterRateLimitIsInvoked(1, rateRemaining, rateReset);
    }

    /**
     * Assert that response is removed and rate limit is not registered.
     */
    @Test
    public void invokeEmailResponseHandler_shouldRemoveResponseAndNotRegisterRateLimit() {
        final ResponseError error = new ResponseError();
        error.setDetail("Test-Details");
        final EmailValidationResponse response = new EmailValidationResponse(referenceId, "", error, null, null, Long.MIN_VALUE, rateRemaining, rateReset);
        this.steps
                .givenISetupEmailResponseHandler()
                .whenIInvokeResponseHandler(response)
                .thenRemoveIsInvoked(1, referenceId)
                .thenRegisterRateLimitIsInvoked(0, rateRemaining, rateReset);
    }

    /**
     * Assert that response is removed and rate limit is registered.
     */
    @Test
    public void invokePhoneResponseHandler_shouldRemoveResponseAndRegisterRateLimit() {
        final PhoneValidationResponse response = new PhoneValidationResponse(referenceId, "", null, null, null, Long.MIN_VALUE, rateRemaining, rateReset);
        this.steps
                .givenISetupEmailResponseHandler()
                .whenIInvokeResponseHandler(response)
                .thenRemoveIsInvoked(1, referenceId)
                .thenRegisterRateLimitIsInvoked(1, rateRemaining, rateReset);
    }

    /**
     * Assert that response is removed and rate limit is registered.
     */
    @Test
    public void invokeEnrichmentResponseHandler_shouldRemoveResponseAndRegisterRateLimit() {
        final EnrichmentResponse response = new EnrichmentResponse(referenceId, "", null, null, null, Long.MIN_VALUE, rateRemaining, rateReset);
        this.steps
                .givenISetupEmailResponseHandler()
                .whenIInvokeResponseHandler(response)
                .thenRemoveIsInvoked(1, referenceId)
                .thenRegisterRateLimitIsInvoked(1, rateRemaining, rateReset);
    }
}
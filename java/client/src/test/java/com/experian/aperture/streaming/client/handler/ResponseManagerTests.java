package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * ResponseManager tests.
 */
public final class ResponseManagerTests {
    private ResponseManagerSteps steps;

    /**
     * Setup before each test.
     */
    @Before
    public void setUp() {
        this.steps = new ResponseManagerSteps();
    }

    /**
     * Assert that all default response handlers are subscribed.
     */
    @Test
    public void registerDefaultResponseHandlers_shouldRegisterAllDefaultResponseHandlers() {
        this.steps
                .givenISetupResponseManager()
                .whenIRegisterDefaultResponseHandlers()
                .thenAllGetRequestListAreInvokedOnce()
                .thenDefaultResponseHandlerIsSubscribedToTheConnection(1, StreamingMethod.EMAIL_RESPONSE.getValue(), EmailResponseHandler.class, EmailValidationResponse.class)
                .thenDefaultResponseHandlerIsSubscribedToTheConnection(1, StreamingMethod.PHONE_RESPONSE.getValue(), PhoneResponseHandler.class, PhoneValidationResponse.class)
                .thenDefaultResponseHandlerIsSubscribedToTheConnection(1, StreamingMethod.ENRICHMENT_RESPONSE.getValue(), EnrichmentResponseHandler.class, EnrichmentResponse.class);
    }

    /**
     * Assert that the request resend handler is registered.
     */
    @Test
    public void registerRequestResendHandler_shouldRegisterResendHandler() {
        this.steps
                .givenISetupResponseManager()
                .whenIRegisterRequestResendHandler()
                .thenConnectionResendCallbackIsSet();
    }
}


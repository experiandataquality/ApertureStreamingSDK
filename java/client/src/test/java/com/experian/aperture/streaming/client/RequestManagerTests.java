package com.experian.aperture.streaming.client;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Experian aperture streaming request manager test.
 */
public final class RequestManagerTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private RequestManagerTestsSteps steps;

    @Before
    public void setUp() {
        this.steps = new RequestManagerTestsSteps();
    }

    /**
     * Assert that client is started in startStreaming, with default handlers registered and all request lists are empty.
     *
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_beAbleToStartConnection() throws ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenIStartStreaming()
                .thenStartStreaming()
                .thenDefaultHandlersAreRegistered()
                .thenRequestResendHandlerIsRegistered()
                .thenAllRequestListsAreCleared();
    }

    /**
     * Assert that client is stop in stopStreaming.
     *
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_beAbleToStopConnection() throws ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenIStopStreaming()
                .thenStopStreaming();
    }

    /**
     * Assert that client able to send email request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_BeAbleToGetRequestOnEmailRequest() throws RateLimitException, ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenISetupEmail(false, true)
                .whenISendEmailRequest()
                .thenIShouldGetEmailRequest(1, 3, 1);
    }

    /**
     * Assert that client able to send email request with the same reference Id.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenDuplicateReferenceIdIsInsertedOnEmailRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("Duplicate referenceId test.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupEmail(true, true)
                .whenISendEmailRequest()
                .thenIShouldGetEmailRequest(0, 0, 0);
    }

    /**
     * Assert that client able to send email request once hit the rate limit.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenRateLimitIsHitOnEmailRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(RateLimitException.class);
        this.exception.expectMessage("429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupEmail(false, false)
                .whenISendEmailRequest()
                .thenIShouldGetEmailRequest(0, 0, 0);
    }

    /**
     * Assert that client not able to send phone request with the same reference Id.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenDuplicateReferenceIdIsInsertedOnPhoneRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("Duplicate referenceId test.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupPhone(true, true)
                .whenISendPhoneRequest()
                .thenIShouldGetPhoneRequest(0, 0, 0);
    }

    /**
     * Assert that client not able to send phone request once hit the rate limit.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenRateLimitIsHitOnPhoneRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(RateLimitException.class);
        this.exception.expectMessage("429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupPhone(false, false)
                .whenISendPhoneRequest()
                .thenIShouldGetPhoneRequest(0, 0, 0);
    }

    /**
     * Assert that client able to send phone request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_BeAbleToGetRequestOnPhoneRequest() throws RateLimitException, ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenISetupPhone(false, true)
                .whenISendPhoneRequest()
                .thenIShouldGetPhoneRequest(1, 3, 1);
    }

    /**
     * Assert that client not able to send enrichment request with the same reference Id.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenDuplicateReferenceIdIsInsertedOnEnrichmentRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("Duplicate referenceId test.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupEnrichment(true, true)
                .whenISendEnrichmentRequest()
                .thenIShouldGetEnrichmentRequest(0, 0, 0);
    }

    /**
     * Assert that client not able to send enrichment request once hit the rate limit.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenRateLimitIsHitOnEnrichmentRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(RateLimitException.class);
        this.exception.expectMessage("429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupEnrichment(false, false)
                .whenISendEnrichmentRequest()
                .thenIShouldGetEnrichmentRequest(0, 0, 0);
    }
    /**
     * Assert that client able to send enrichment request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_BeAbleToGetRequestOnEnrichmentRequest() throws RateLimitException, ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenISetupEnrichment(false, true)
                .whenISendEnrichmentRequest()
                .thenIShouldGetEnrichmentRequest(1, 3, 1);
    }

    /**
     * Assert that client able to send address request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_BeAbleToGetRequestOnAddressRequest() throws RateLimitException, ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenISetupAddress(false, true)
                .whenISendAddressRequest()
                .thenIShouldGetAddressRequest(1, 3, 1);
    }

    /**
     * Assert that client able to send address request with the same reference Id.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenDuplicateReferenceIdIsInsertedOnAddressRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage("Duplicate referenceId test.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupAddress(true, true)
                .whenISendAddressRequest()
                .thenIShouldGetAddressRequest(0, 0, 0);
    }

    /**
     * Assert that client able to send address request once hit the rate limit.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_ThrowExceptionWhenRateLimitIsHitOnAddressRequest() throws RateLimitException, ConnectionException {
        this.exception.expect(RateLimitException.class);
        this.exception.expectMessage("429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.");
        this.steps
                .givenISetupRequestManager()
                .whenISetupAddress(false, false)
                .whenISendAddressRequest()
                .thenIShouldGetAddressRequest(0, 0, 0);
    }

    /**
     * Assert that client able to subscribe to connection.
     *
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void should_BeAbleToSubscribeConnection() throws ConnectionException {
        this.steps
                .givenISetupRequestManager()
                .whenISetupConnection()
                .thenIShouldGetConnection();
    }
}

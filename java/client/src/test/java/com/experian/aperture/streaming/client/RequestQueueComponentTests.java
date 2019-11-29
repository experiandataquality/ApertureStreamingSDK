package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.list.DefaultRequestContext;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;

/**
 * Experian aperture streaming request queue component test.
 */
public final class RequestQueueComponentTests {

    private RequestQueueComponentTestsSteps steps;

    @Before
    public void setUp() {
        this.steps = new RequestQueueComponentTestsSteps();
    }

    /**
     * Assert that email request is dequeue from email request list once the email response is received.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    @Test
    public void when_ConnectionIsAlwaysUp_Then_EmailRequestDequeueFromEmailRequestQueue() throws RateLimitException, ConnectionException {
        final String referenceId = "EmailStreamingSDKTest";
        final EmailValidationResponse response = new EmailValidationResponse(referenceId, "1", null, null, null, (long) 0, (long) 0, (long) 0);
        final Connection connection = new StubConnection(response);
        final RequestContext requestContext = new DefaultRequestContext();
        final RequestManager manager = new DefaultRequestManager(connection, requestContext, null, null);
        this.steps
                .givenISendEmailRequest(manager, referenceId)
                .thenIAssertEmailRequestListIsInQueue(requestContext, referenceId, 1)
                .whenIReceivedEmailResponse(manager, requestContext)
                .thenIAssertEmailRequestListIsNotInQueue(requestContext);
    }

    /**
     * Assert that phone request is dequeue from phone request list once the phone response is received.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    @Test
    public void when_ConnectionIsAlwaysUp_Then_PhoneRequestDequeueFromPhoneRequestQueue() throws RateLimitException, ConnectionException {
        final String referenceId = "PhoneStreamingSDKTest";
        final PhoneValidationResponse response = new PhoneValidationResponse(referenceId, "1", null, null, null, (long) 0, (long) 0, (long) 0);
        final Connection connection = new StubConnection(response);
        final RequestContext requestContext = new DefaultRequestContext();
        final RequestManager manager = new DefaultRequestManager(connection, requestContext, null, null);
        this.steps
                .givenISendPhoneRequest(manager, referenceId)
                .thenIAssertPhoneRequestListIsInQueue(requestContext, referenceId, 1)
                .whenIReceivedPhoneResponse(manager, requestContext)
                .thenIAssertPhoneRequestListIsNotInQueue(requestContext);
    }

    /**
     * Assert that enrichment request is dequeue from enrichment request list once the enrichment response is received.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    @Test
    public void when_ConnectionIsAlwaysUp_Then_EnrichRequestDequeueFromEnrichRequestQueue() throws RateLimitException, ConnectionException {
        final String referenceId = "EnrichmentStreamingSDKTest";
        final EnrichmentResponse response = new EnrichmentResponse(referenceId, "1", null, null, null, (long) 0, (long) 0, (long) 0);
        final Connection connection = new StubConnection(response);
        final RequestContext requestContext = new DefaultRequestContext();
        final RequestManager manager = new DefaultRequestManager(connection, requestContext, null, null);
        this.steps
                .givenISendEnrichmentRequest(manager, referenceId)
                .thenIAssertEnrichmentRequestListIsInQueue(requestContext, referenceId, 1)
                .whenIReceivedEnrichmentResponse(manager, requestContext)
                .thenIAssertEnrichmentRequestListIsNotInQueue(requestContext);
    }

    /**
     * Assert that request is not dequeue from request list once the connection stop.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    @Test
    public void when_ConnectionIsDownAfterRequestSent_Then_RequestRemainInRequestQueue() throws RateLimitException, ConnectionException {
        final String referenceId = "EmailStreamingSDKTest";
        final EmailValidationResponse response = new EmailValidationResponse(referenceId, "1", null, null, null, (long) 0, (long) 0, (long) 0);
        final Connection connection = new StubConnection(response);
        final RequestContext requestContext = new DefaultRequestContext();
        final RequestManager manager = new DefaultRequestManager(connection, requestContext, null, null);
        this.steps
                .givenISendEmailRequest(manager, referenceId)
                .thenIAssertEmailRequestListIsInQueue(requestContext, referenceId, 1);
        connection.stop();
        this.steps
                .thenIAssertEmailRequestListIsInQueue(requestContext, referenceId, 1);
    }

    /**
     * Assert that rate limit error is shown if the rate limit is hit.
     */
  @Test
    public void when_RateLimitIsReach_Then_TooManyRequestErrorShow() {
        final String referenceId = "EmailStreamingSDKTest";
        final String expectedError = "429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.";
        final EmailValidationResponse response = new EmailValidationResponse(referenceId, "1", null, null, null, (long) 0, (long) 0, (long) 0);
        final Connection connection = new StubConnection(response);
        final RequestContext requestContext = new DefaultRequestContext();
        requestContext.getEmailRequestList().setRateRemaining(0);
        requestContext.getEmailRequestList().setRateReset(Instant.MAX);
        final RequestManager manager = new DefaultRequestManager(connection, requestContext, null, null);
        try {
            this.steps
                    .givenISendEmailRequest(manager, referenceId);
        } catch (RateLimitException | ConnectionException e) {
            this.steps
                    .thenIAssertRateLimitError(e.getMessage(), expectedError);
        }
    }
}
package com.experian.aperture.streaming.client;
import com.experian.aperture.streaming.client.handler.EmailResponseHandler;
import com.experian.aperture.streaming.client.handler.EnrichmentResponseHandler;
import com.experian.aperture.streaming.client.handler.PhoneResponseHandler;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;

import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class representing the steps of request queue component test steps.
 */
public class RequestQueueComponentTestsSteps {

    private String randomString = RandomGenerator.generateRandomString();
    /**
     * Send email request step.
     * @param manager the request manager.
     * @param referenceId reference id.
     * @return RequestQueueComponentTestsSteps
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    public RequestQueueComponentTestsSteps givenISendEmailRequest(final RequestManager manager, final String referenceId) throws RateLimitException, ConnectionException {
        final EmailValidationRequest request = RequestBuilder.builder().withEmailRequest(referenceId).withEmail("abc@example.com").build();
        final EmailValidationOptions options = OptionsBuilder.builder().withEmailOptions(true).withTimeout(Duration.ofSeconds(15)).build();
        final EmailValidationRequestProxy proxy = new EmailValidationRequestProxy(request, options);
        manager.onEmailRequest(proxy);
        return this;
    }
    /**
     * Send phone request step.
     * @param manager the request manager.
     * @param referenceId reference id.
     * @return RequestQueueComponentTestsSteps.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    public RequestQueueComponentTestsSteps givenISendPhoneRequest(final RequestManager manager, final String referenceId) throws RateLimitException, ConnectionException {
        final PhoneValidationRequest request = RequestBuilder.builder().withPhoneRequest(referenceId).withNumber("123456789").build();
        final PhoneValidationOptions options = OptionsBuilder.builder().withPhoneOptions(true).withTimeout(Duration.ofSeconds(15)).build();
        final PhoneValidationRequestProxy proxy = new PhoneValidationRequestProxy(request, options);
        manager.onPhoneRequest(proxy);
        return this;
    }
    /**
     * Send enrichment request step.
     * @param manager the request manager.
     * @param referenceId reference id.
     * @return RequestQueueComponentTestsSteps.
     * @throws RateLimitException Throws RateLimitException.
     * @throws ConnectionException Throws ConnectionException.
     */
    public RequestQueueComponentTestsSteps givenISendEnrichmentRequest(final RequestManager manager, final String referenceId) throws RateLimitException, ConnectionException {
        final EnrichmentRequest request = RequestBuilder.builder().withEnrichmentRequest(referenceId)
                .withCountry("country")
                .withKeys(EnrichmentDatasetKeysBuilder.builder().withPin(randomString).build())
                .withAttributes(EnrichmentDatasetAttributesBuilder.builder().withAusCvPersonList(AusCVPerson.PIN, AusCVPerson.GENDER).build())
                .build();
        final EnrichmentOptions options = OptionsBuilder.builder().withEnrichmentOptions(true).withTimeout(Duration.ofSeconds(15)).build();
        final EnrichmentRequestProxy proxy = new EnrichmentRequestProxy(request, options);
        manager.onEnrichmentRequest(proxy);
        return  this;
    }
    /**
     * Receive email response step.
     * @param manager the request manager.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps whenIReceivedEmailResponse(final RequestManager manager, final RequestContext requestContext) {
        final EmailResponseHandler handler = new EmailResponseHandler(requestContext.getEmailRequestList());
        manager.onEmailResponse(handler);
        return this;
    }
    /**
     * Receive phone response step.
     * @param manager the request manager.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps whenIReceivedPhoneResponse(final RequestManager manager, final RequestContext requestContext) {
        final PhoneResponseHandler handler = new PhoneResponseHandler(requestContext.getPhoneRequestList());
        manager.onPhoneResponse(handler);
        return this;
    }
    /**
     * Receive enrichment response step.
     * @param manager the request manager.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps whenIReceivedEnrichmentResponse(final RequestManager manager, final RequestContext requestContext) {
        final EnrichmentResponseHandler handler = new EnrichmentResponseHandler(requestContext.getEnrichmentRequestList());
        manager.onEnrichmentResponse(handler);
        return this;
    }
    /**
     * Assert email request is in email request list step.
     * @param requestContext request context that contain request list info.
     * @param referenceId reference id.
     * @param expectedSize expected list size.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertEmailRequestListIsInQueue(final RequestContext requestContext, final String referenceId, final int expectedSize) {
        assertThat(requestContext.getEmailRequestList().getAll().size(), is(expectedSize));
        assertThat(requestContext.getEmailRequestList().containsKey(referenceId), is(true));
        return this;
    }
    /**
     * Assert phone request is in phone request list step.
     * @param requestContext request context that contain request list info.
     * @param referenceId reference id.
     * @param expectedSize expected list size.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertPhoneRequestListIsInQueue(final RequestContext requestContext, final String referenceId, final int expectedSize) {
        assertThat(requestContext.getPhoneRequestList().getAll().size(), is(expectedSize));
        assertThat(requestContext.getPhoneRequestList().containsKey(referenceId), is(true));
        return this;
    }
    /**
     * Assert enrichment request is in enrichment request list step.
     * @param requestContext request context that contain request list info.
     * @param referenceId reference id.
     * @param expectedSize expected list size.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertEnrichmentRequestListIsInQueue(final RequestContext requestContext, final String referenceId, final int expectedSize) {
        assertThat(requestContext.getEnrichmentRequestList().getAll().size(), is(expectedSize));
        assertThat(requestContext.getEnrichmentRequestList().containsKey(referenceId), is(true));
        return this;
    }
    /**
     * Assert email request is not in the email request list.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertEmailRequestListIsNotInQueue(final RequestContext requestContext) {
        assertThat(requestContext.getEmailRequestList().getAll().size(), is(0));
        return  this;
    }
    /**
     * Assert phone request is not in the phone request list.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertPhoneRequestListIsNotInQueue(final RequestContext requestContext) {
        assertThat(requestContext.getPhoneRequestList().getAll().size(), is(0));
        return  this;
    }
    /**
     * Assert enrichment request is not in the enrichment request list.
     * @param requestContext request context that contain request list info.
     * @return RequestQueueComponentTestsSteps
     */
    public RequestQueueComponentTestsSteps thenIAssertEnrichmentRequestListIsNotInQueue(final RequestContext requestContext) {
        assertThat(requestContext.getEnrichmentRequestList().getAll().size(), is(0));
        return  this;
    }
    public RequestQueueComponentTestsSteps thenIAssertRateLimitError(final String errorMessage, final String exceptedError) {
        assertThat(errorMessage, is(exceptedError));
        return  this;
    }
}
package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.EmailResponseHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import org.mockito.Mockito;

import java.time.Duration;

import static org.mockito.Mockito.*;

final class RequestManagerTestsSteps {
    private RequestContext requestContext = mock(RequestContext.class);
    private Connection connection = mock(Connection.class);
    private ResponseManager responseManager = mock(ResponseManager.class);
    private RequestList<EmailValidationRequestProxy> emailRequestList = (RequestList<EmailValidationRequestProxy>) mock(RequestList.class);
    private RequestList<PhoneValidationRequestProxy> phoneRequestList = (RequestList<PhoneValidationRequestProxy>) mock(RequestList.class);
    private RequestList<EnrichmentRequestProxy> enrichmentRequestList = (RequestList<EnrichmentRequestProxy>) mock(RequestList.class);
    private RequestManager requestManager;
    private EmailValidationRequestProxy proxy;
    private PhoneValidationRequestProxy phoneValidationRequestProxy;
    private EnrichmentRequestProxy enrichmentRequestProxy;
    private Single<Void> mockSubscribe = (Single<Void>) mock(Single.class);
    private PublishSubject<ConnectionEvent> mockSubject = PublishSubject.create();
    private String randomString = RandomGenerator.generateRandomString();
    private String randomNumber = RandomGenerator.generateRandomNumber();

    /**
     * Set up the request manager.
     *
     * @return RequestManagerTestsSteps steps.
     * @throws ConnectionException Throws the ConnectionException.
     */
    RequestManagerTestsSteps givenISetupRequestManager() throws ConnectionException {
        when(connection.send(any(String.class), any(Object.class))).thenReturn(mockSubscribe);
        when(connection.getConnectionEventSubject()).thenReturn(mockSubject);
        this.requestManager = new DefaultRequestManager(connection, requestContext, responseManager, mock(ConnectionFailureHandler.class));
        return this;
    }

    /**
     * Start streaming.
     *
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenIStartStreaming() throws ConnectionException {
        this.requestManager.startStreaming();
        return this;
    }

    /**
     * Stop streaming.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenIStopStreaming() {
        this.requestManager.stopStreaming();
        return this;
    }

    /**
     * Assert start streaming.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenStartStreaming() throws ConnectionException {
        verify(this.connection, times(1)).start();
        return this;
    }

    /**
     * Assert that all the default handlers are registered.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenDefaultHandlersAreRegistered() {
        verify(this.responseManager, times(1)).registerDefaultResponseHandlers();
        return this;
    }

    /**
     * Assert that the request resend handler is registered.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenRequestResendHandlerIsRegistered() {
        verify(this.responseManager, times(1)).registerRequestResendHandler();
        return this;
    }

    /**
     * Assert that the lists are first cleared.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenAllRequestListsAreCleared() {
        verify(this.requestContext, times(1)).clearAll();
        return this;
    }

    /**
     * Assert the stop streaming.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenStopStreaming() {
        verify(this.connection, times(1)).stop();
        return this;
    }

    /**
     * Setup the email request.
     * @param containsKeyValue The keys value.
     * @param canAddValue The values.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISetupEmail(final Boolean containsKeyValue, final Boolean canAddValue) {
        when(this.emailRequestList.containsKey(any(String.class))).thenReturn(containsKeyValue);
        when(this.emailRequestList.canAdd()).thenReturn(canAddValue);
        doNothing().when(this.emailRequestList).add(isA(EmailValidationRequestProxy.class), isA(String.class));
        when(this.requestContext.getEmailRequestList()).thenReturn(this.emailRequestList);
        return this;
    }

    /**
     * Send the email request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISendEmailRequest() throws RateLimitException, ConnectionException {
        this.proxy = new EmailValidationRequestProxy(this.createEmailRequest(), OptionsBuilder.builder().withEmailOptions(true).withTimeout(Duration.ofSeconds(3)).build());
        this.requestManager.onEmailRequest(this.proxy);
        return this;
    }

    /**
     * Assert the email request.
     *
     * @param expectedSend The number of expected send to be invoked.
     * @param expectedList The number of expected get request list to be invoked.
     * @param expectedEmailRequestList The number of add method to be invoked.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenIShouldGetEmailRequest(final int expectedSend, final int expectedList, final int expectedEmailRequestList) throws ConnectionException {
        verify(this.connection, times(expectedSend)).send(eq(StreamingMethod.EMAIL_REQUEST.getValue()), eq(proxy));
        verify(this.requestContext, times(expectedList)).getEmailRequestList();
        verify(this.emailRequestList, times(expectedEmailRequestList)).add(proxy, proxy.getReferenceId());
        return this;
    }

    /**
     * Setup the phone request.
     * @param containsKeyValue The keys value.
     * @param canAddValue The values.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISetupPhone(final Boolean containsKeyValue, final Boolean canAddValue) {
        when(this.phoneRequestList.containsKey(any(String.class))).thenReturn(containsKeyValue);
        when(this.phoneRequestList.canAdd()).thenReturn(canAddValue);
        doNothing().when(this.phoneRequestList).add(isA(PhoneValidationRequestProxy.class), isA(String.class));
        when(this.requestContext.getPhoneRequestList()).thenReturn(this.phoneRequestList);
        return this;
    }

    /**
     * Send the phone request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISendPhoneRequest() throws RateLimitException, ConnectionException {
        this.phoneValidationRequestProxy = new PhoneValidationRequestProxy(this.createPhoneRequest(), OptionsBuilder.builder().withPhoneOptions(true).withTimeout(Duration.ofSeconds(3)).build());
        this.requestManager.onPhoneRequest(this.phoneValidationRequestProxy);
        return this;
    }

    /**
     * Assert the phone request.
     *
     * @param expectedSend The number of expected send to be invoked.
     * @param expectedList The number of expected get request list to be invoked.
     * @param expectedEmailRequestList The number of add method to be invoked.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenIShouldGetPhoneRequest(final int expectedSend, final int expectedList, final int expectedEmailRequestList) throws ConnectionException {
        verify(this.connection, times(expectedSend)).send(eq(StreamingMethod.PHONE_REQUEST.getValue()), eq(phoneValidationRequestProxy));
        verify(this.requestContext, times(expectedList)).getPhoneRequestList();
        verify(this.phoneRequestList, times(expectedEmailRequestList)).add(phoneValidationRequestProxy, phoneValidationRequestProxy.getReferenceId());
        return this;
    }

    /**
     * Setup the enrichment request.
     * @param containsKeyValue The keys value.
     * @param canAddValue The values.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISetupEnrichment(final Boolean containsKeyValue, final Boolean canAddValue) {
        when(this.enrichmentRequestList.containsKey(any(String.class))).thenReturn(containsKeyValue);
        when(this.enrichmentRequestList.canAdd()).thenReturn(canAddValue);
        doNothing().when(this.enrichmentRequestList).add(isA(EnrichmentRequestProxy.class), isA(String.class));
        when(this.requestContext.getEnrichmentRequestList()).thenReturn(this.enrichmentRequestList);
        return this;
    }

    /**
     * Send the enrichment request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISendEnrichmentRequest() throws RateLimitException, ConnectionException {
        this.enrichmentRequestProxy = new EnrichmentRequestProxy(this.createEnrichmentRequest(), OptionsBuilder.builder().withEnrichmentOptions(true).build());
        this.requestManager.onEnrichmentRequest(this.enrichmentRequestProxy);
        return this;
    }

    /**
     * Assert the enrichment request.
     *
     * @param expectedSend The number of expected send to be invoked.
     * @param expectedList The number of expected get request list to be invoked.
     * @param expectedEnrichmentRequestList The number of add method to be invoked.
     * @throws ConnectionException Throws the ConnectionException.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenIShouldGetEnrichmentRequest(final int expectedSend, final int expectedList, final int expectedEnrichmentRequestList) throws ConnectionException {
        verify(this.connection, times(expectedSend)).send(eq(StreamingMethod.ENRICHMENT_REQUEST.getValue()), eq(enrichmentRequestProxy));
        verify(this.requestContext, times(expectedList)).getEnrichmentRequestList();
        verify(this.enrichmentRequestList, times(expectedEnrichmentRequestList)).add(enrichmentRequestProxy, enrichmentRequestProxy.getReferenceId());
        return this;
    }

    /**
     * Setup the connection.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps whenISetupConnection() {
        this.requestManager.onEmailResponse(new EmailResponseHandler(mock(RequestList.class)));
        return this;
    }

    /**
     * Assert the connection.
     * @return RequestManagerTestsSteps steps.
     */
    RequestManagerTestsSteps thenIShouldGetConnection() {
        verify(this.connection, atLeastOnce()).subscribe(anyString(), Mockito.any(EmailResponseHandler.class), eq(EmailValidationResponse.class));
        return this;
    }

    /**
     * Create the email request.
     *
     * @return email request
     */
    private EmailValidationRequest createEmailRequest() {
        return RequestBuilder.builder().withEmailRequest("test").withEmail("Test@yahoo.com").build();
    }

    /**
     * Create the phone request.
     *
     * @return phone request.
     */
    private PhoneValidationRequest createPhoneRequest() {
        return RequestBuilder.builder().withPhoneRequest("test").withNumber(randomNumber).build();
    }

    /**
     * Create the enrichment request.
     *
     * @return enrichment request.
     */
    private EnrichmentRequest createEnrichmentRequest() {
        final EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withDpid(randomString)
                .withPostcode(randomString)
                .withPin(randomString)
                .withGlobalAddressKey(randomString)
                .build();

        final EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withAusCvPostcodeList(AusCVPostcode.ADULTS_AT_ADDRESS_CODE, AusCVPostcode.ADULTS_AT_ADDRESS_DESCRIPTION)
                .build();

        return RequestBuilder.builder()
                .withEnrichmentRequest("test")
                .withCountry("country")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
    }
}

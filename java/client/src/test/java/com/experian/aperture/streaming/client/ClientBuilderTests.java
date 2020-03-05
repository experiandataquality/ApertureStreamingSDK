package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Experian aperture streaming client test.
 */
public class ClientBuilderTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ClientBuilderTestsSteps steps;

    private String randomString = RandomGenerator.generateRandomString();

    @Before
    public void setUp() {
        this.steps = new ClientBuilderTestsSteps();
    }

    /**
     * Assert that client is register successfully.
     */
    @Test
    public void shouldRegisterClientSuccessfully() {
        steps
            .givenISetupClient()
            .thenShouldCreateClient();
    }

    /**
     * Assert that client is started in startStreaming.
     *
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void onStartStreaming_SuccessfullyStartStreaming() throws ConnectionException {
        steps
            .givenISetupClient()
            .whenIStartStreaming()
            .thenIShouldStartStreaming();
    }

    /**
     * Assert that client connection is stopped in stopStreaming.
     *
     */
    @Test
    public void onStopStreaming_SuccessfullyStopStreaming() {
        steps
            .givenISetupClient()
            .whenIStopStreaming()
            .thenIShouldStopStreaming();
    }

    /**
     * Assert that the server side validate email is invoked on request manager.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void onEmailRequest_sendRequestToRequestManager() throws RateLimitException, ConnectionException {
        steps
            .givenISetupClient()
            .whenISendEmailRequest(this.createEmailRequest())
            .thenIShouldGetEmailRequest();
    }

    /**
     * Assert that the server side validate phone is invoked on request manager.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void onPhoneRequest_sendRequestToRequestManager() throws RateLimitException, ConnectionException {
        steps
            .givenISetupClient()
            .whenISendPhoneRequest(this.createPhoneRequest())
            .thenIShouldGetPhoneRequest();
    }

    /**
     * Assert that the server side validate enrichment is invoked on request manager.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void onEnrichmentRequest_sendRequestToRequestManager() throws RateLimitException, ConnectionException {
        steps
            .givenISetupClient()
            .whenISendEnrichmentRequest(this.createEnrichmentRequest())
            .thenIShouldGetEnrichmentRequest();
    }

    /**
     * Assert that the server side validate address is invoked on request manager.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     */
    @Test
    public void onAddressRequest_SendRequestToRequestManager() throws RateLimitException, ConnectionException {
        steps
            .givenISetupClient()
            .whenISendAddressRequest(this.createAddressRequest())
            .thenIShouldGetAddressRequest();
    }

    /**
     * Assert that the server side validate on email response is invoked on request manager.
     *
     */
    @Test
    public void onEmailResponse_getResponse() {
        steps
            .givenISetupClient()
            .whenISendEmailResponse()
            .thenIShouldGetEmailResponse();
    }

    /**
     * Assert that the server side validate on phone response is invoked on request manager.
     *
     */
    @Test
    public void onPhoneResponse_getResponse() {
        steps
            .givenISetupClient()
            .whenISendPhoneResponse()
            .thenIShouldGetPhoneResponse();
    }

    /**
     * Assert that the server side validate on enrichment response is invoked on request manager.
     *
     */
    @Test
    public void onEnrichmentResponse_getResponse() {
        steps
            .givenISetupClient()
            .whenISendEnrichmentResponse()
            .thenIShouldGetEnrichmentResponse();
    }

    /**
     * Assert that the server side validate on address response is invoked on request manager.
     *
     */
    @Test
    public void onAddressResponse_GetResponse() {
        steps
            .givenISetupClient()
            .whenISendAddressResponse()
            .thenIShouldGetAddressResponse();
    }

    /**
     * Assert that exception is thrown when null EmailValidationRequest is provided.
     * @throws RateLimitException The RateLimitException.
     * @throws ConnectionException The ConnectionException.
     */
    @Test
    public void onEmailRequest_nullEmailValidationRequest_ThrowException() throws RateLimitException, ConnectionException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The emailValidationRequest field is required.");
        steps.givenISetupClient().whenISendEmailRequest(null);
    }

    /**
     * Assert that exception is thrown when null PhoneValidationRequest is provided.
     * @throws RateLimitException The RateLimitException.
     * @throws ConnectionException The ConnectionException.
     */
    @Test
    public void onPhoneRequest_nullPhoneValidationRequest_ThrowException() throws RateLimitException, ConnectionException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The phoneValidationRequest field is required.");
        steps.givenISetupClient().whenISendPhoneRequest(null);
    }

    /**
     * Assert that exception is thrown when null EnrichmentRequest is provided.
     * @throws RateLimitException The RateLimitException.
     * @throws ConnectionException The ConnectionException.
     */
    @Test
    public void onEnrichmentRequest_nullEnrichmentRequest_ThrowException() throws RateLimitException, ConnectionException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The enrichmentRequest field is required.");
        steps.givenISetupClient().whenISendEnrichmentRequest(null);
    }

    /**
     * Assert that exception is thrown when null AddressRequest is provided.
     * @throws RateLimitException The RateLimitException.
     * @throws ConnectionException The ConnectionException.
     */
    @Test
    public void onAddressRequest_nullAddressRequest_ThrowException() throws RateLimitException, ConnectionException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The addressRequest field is required.");
        steps.givenISetupClient().whenISendAddressRequest(null);
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
        return RequestBuilder.builder().withPhoneRequest("test").withNumber("01234").build();
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
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .withCountry("country")
                .build();
    }

    /**
     * Create the address request.
     *
     * @return address request.
     */
    private AddressValidationRequest createAddressRequest() {
        return RequestBuilder.builder()
                .withAddressValidationRequest("test")
                .withCountryIso("USA")
                .withStreet("Summer St")
                .build();
    }
}

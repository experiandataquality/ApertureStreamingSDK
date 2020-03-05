package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.proxy.AddressValidationRequestProxy;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Experian aperture streaming client test steps.
 */
final class ClientBuilderTestsSteps {
    private final RequestManager requestManager = mock(RequestManager.class);
    private Client client;

    /**
     * Setup the client.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenShouldCreateClient() {
        assertNotNull(client);
        return this;
    }

    /**
     * Start streaming.
     *
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps whenIStartStreaming() throws ConnectionException {
        client.startStreaming();
        return this;
    }

    /**
     * Stop streaming.
     *
     * @return client
     */
    ClientBuilderTestsSteps whenIStopStreaming() {
        client.stopStreaming();
        return this;
    }

    /**
     * Create the on email request.
     * @param emailValidationRequest The email validation request.
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps whenISendEmailRequest(final EmailValidationRequest emailValidationRequest) throws RateLimitException, ConnectionException {
        client.onEmailRequest(emailValidationRequest);
        return this;
    }

    /**
     * Create the on phone request.
     * @param phoneValidationRequest The phone validation request.
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps whenISendPhoneRequest(final PhoneValidationRequest phoneValidationRequest) throws RateLimitException, ConnectionException {
        client.onPhoneRequest(phoneValidationRequest);
        return this;
    }

    /**
     * Create the on enrichment request.
     * @param enrichmentRequest The enrichment request.
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps whenISendEnrichmentRequest(final EnrichmentRequest enrichmentRequest) throws RateLimitException, ConnectionException {
        client.onEnrichmentRequest(enrichmentRequest);
        return this;
    }

    /**
     * Create the on address request.
     * @param addressRequest The enrichment request.
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps whenISendAddressRequest(final AddressValidationRequest addressRequest) throws RateLimitException, ConnectionException {
        client.onAddressRequest(addressRequest);
        return this;
    }

    /**
     * Create the on email response.
     *
     * @return client
     */
    ClientBuilderTestsSteps whenISendEmailResponse() {
        client.onEmailResponse(Mockito.any());
        return this;
    }

    /**
     * Create the on phone response.
     *
     * @return client
     */
    ClientBuilderTestsSteps whenISendPhoneResponse() {
        client.onPhoneResponse(Mockito.any());
        return this;
    }

    /**
     * Create the on enrichment response.
     *
     * @return client
     */
    ClientBuilderTestsSteps whenISendEnrichmentResponse() {
        client.onEnrichmentResponse(Mockito.any());
        return this;
    }

    /**
     * Create the on address response.
     *
     * @return client
     */
    ClientBuilderTestsSteps whenISendAddressResponse() {
        client.onAddressResponse(Mockito.any());
        return this;
    }

    /**
     * Assert the phone response.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetPhoneResponse() {
        verify(requestManager, times(1)).onPhoneResponse(Mockito.any());
        return this;
    }

    /**
     * Assert the enrichment response.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetEnrichmentResponse() {
        verify(requestManager, times(1)).onEnrichmentResponse(Mockito.any());
        return this;
    }

    /**
     * Assert the email response.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetEmailResponse() {
        verify(requestManager, times(1)).onEmailResponse(Mockito.any());
        return this;
    }

    /**
     * Assert the address response.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetAddressResponse() {
        verify(requestManager, times(1)).onAddressResponse(Mockito.any());
        return this;
    }

    /**
     * Assert the enrichment request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetEnrichmentRequest() throws RateLimitException, ConnectionException {
        verify(requestManager, times(1)).onEnrichmentRequest(Mockito.any(EnrichmentRequestProxy.class));
        return this;
    }

    /**
     * Assert the phone request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetPhoneRequest() throws RateLimitException, ConnectionException {
        verify(requestManager, times(1)).onPhoneRequest(Mockito.any(PhoneValidationRequestProxy.class));
        return this;
    }

    /**
     * Assert the email request.
     *
     * @throws RateLimitException Throws the RateLimitException.
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldGetEmailRequest() throws RateLimitException, ConnectionException {
        verify(requestManager, times(1)).onEmailRequest(Mockito.any(EmailValidationRequestProxy.class));
        return this;
    }

    ClientBuilderTestsSteps thenIShouldGetAddressRequest() throws RateLimitException, ConnectionException {
        verify(requestManager, times(1)).onAddressRequest(Mockito.any(AddressValidationRequestProxy.class));
        return this;
    }

    /**
     * Assert that client is started in startStreaming.
     *
     * @throws ConnectionException Throws the ConnectionException.
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldStartStreaming() throws ConnectionException {
        verify(requestManager, times(1)).startStreaming();
        return this;
    }

    /**
     * Assert that client is started in stopStreaming.
     *
     * @return client
     */
    ClientBuilderTestsSteps thenIShouldStopStreaming() {
        verify(requestManager, times(1)).stopStreaming();
        return this;
    }

    /**
     * Create the client connection.
     *
     * @return client
     */
    ClientBuilderTestsSteps givenISetupClient() {
        client = ClientBuilder.builder()
                .create(requestManager)
                .build();

        return this;
    }
}

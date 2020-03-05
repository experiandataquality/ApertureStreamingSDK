package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.EnrichmentRequest;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.address.AddressValidationResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import io.reactivex.subjects.PublishSubject;

/**
 *  Defines the client contract.
 */
public interface Client {
    /**
     * Starts the streaming connection (e.g web socket connection).
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void startStreaming() throws ConnectionException;

    /**
     * Stops the streaming connection (e.g web socket connection).
     * The method would block until the connection stop successfully.
     */
    void stopStreaming();

    /**
     * Specifies the email validation options when streaming.
     *
     * @param options The email validation options.
     */
    void setEmailOptions(EmailValidationOptions options);

    /**
     * Specifies the phone validation options when streaming.
     *
     * @param options The phone validation options.
     */
    void setPhoneOptions(PhoneValidationOptions options);

    /**
     * Specifies the enrichment options when streaming.
     *
     * @param options The enrichment options.
     */
    void setEnrichmentOptions(EnrichmentOptions options);

    /**
     * Specifies the address options when streaming.
     *
     * @param options The address options.
     */
    void setAddressOptions(AddressValidationOptions options);

    /**
     * Registers the handler when an email validation response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onEmailResponse(ConnectionResponse<EmailValidationResponse> responseHandler);

    /**
     * Registers the handler when an enrichment response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onEnrichmentResponse(ConnectionResponse<EnrichmentResponse> responseHandler);

    /**
     * Registers the handler when an phone validation response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onPhoneResponse(ConnectionResponse<PhoneValidationResponse> responseHandler);

    /**
     * Registers the handler when an address validation response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onAddressResponse(ConnectionResponse<AddressValidationResponse> responseHandler);

    /**
     * Sends an email validation request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param emailValidationRequest The email validation request object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onEmailRequest(EmailValidationRequest emailValidationRequest) throws RateLimitException, ConnectionException;

    /**
     * Sends a phone validation request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param phoneValidationRequest The phone validation request object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onPhoneRequest(PhoneValidationRequest phoneValidationRequest) throws RateLimitException, ConnectionException;

    /**
     * Sends an enrichment request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param enrichmentRequest The enrichment request object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onEnrichmentRequest(EnrichmentRequest enrichmentRequest) throws RateLimitException, ConnectionException;

    /**
     * Sends an address request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param addressValidationRequest The address request object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onAddressRequest(AddressValidationRequest addressValidationRequest) throws RateLimitException, ConnectionException;

    /**
     * Subscribes to any request failure event.
     * @return The request failure subject.
     */
    PublishSubject<FailRequestResponse> onRequestFailure();

    /**
     * Subscribes to a connection failure event.
     * @return The reconnect failure subject.
     */
    PublishSubject<ConnectionFailResponse> onConnectionFailure();
}

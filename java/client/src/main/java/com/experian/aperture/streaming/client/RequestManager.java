package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the request queue manager methods.
 */
public interface RequestManager {

    /**
     * Starts the streaming connection (e.g web socket connection).
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void startStreaming() throws ConnectionException;

    /**
     * Stops the streaming connection (e.g websocket connection).
     * The method would block until the connection stop successfully.
     */
    void stopStreaming();

    /**
     * Sends an email validation request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param proxy The email validation request proxy object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onEmailRequest(EmailValidationRequestProxy proxy) throws RateLimitException, ConnectionException;

    /**
     * Sends a phone validation request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param proxy The phone validation request proxy object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onPhoneRequest(PhoneValidationRequestProxy proxy) throws RateLimitException, ConnectionException;

    /**
     * Sends an enrichment request.
     * This method also ensure the connection exist and start or reconnect before sending the request.
     *
     * @param proxy The enrichment validation request proxy object.
     * @throws RateLimitException The rate limit exception that should be handled by user.
     * @throws ConnectionException Thrown when sending request while the connection is not active.
     */
    void onEnrichmentRequest(EnrichmentRequestProxy proxy) throws RateLimitException, ConnectionException;

    /**
     * Registers the handler when an email validation response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onEmailResponse(ConnectionResponse<EmailValidationResponse> responseHandler);

    /**
     * Registers the handler when an phone validation response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onPhoneResponse(ConnectionResponse<PhoneValidationResponse> responseHandler);

    /**
     * Registers the handler when an enrichment response has been received.
     *
     * @param responseHandler The response callback.
     */
    void onEnrichmentResponse(ConnectionResponse<EnrichmentResponse> responseHandler);

    /**
     * Subscribes to any request failure event.
     * @return The request failure subject.
     */
    PublishSubject<FailRequestResponse> onRequestFailure();

    /**
     * Subscribes to a failure reconnect event.
     * @return The reconnect failure subject.
     */
    PublishSubject<ConnectionFailResponse> onConnectionFailure();
}
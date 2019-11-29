package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.EnrichmentRequest;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the client implementations methods.
 */
public class DefaultClient implements Client {
    private EmailValidationOptions emailValidationOptions = OptionsBuilder.builder().withEmailOptions(true).getDefault();
    private EnrichmentOptions enrichmentOptions =  OptionsBuilder.builder().withEnrichmentOptions(true).getDefault();
    private PhoneValidationOptions phoneValidationOptions = OptionsBuilder.builder().withPhoneOptions(true).getDefault();

    private RequestManager queueManager;

    DefaultClient(final RequestManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void startStreaming() throws ConnectionException {
        queueManager.startStreaming();
    }

    @Override
    public void stopStreaming() {
        queueManager.stopStreaming();
    }

    @Override
    public void setEmailOptions(final EmailValidationOptions options) {
        this.emailValidationOptions = options;
    }

    @Override
    public void setPhoneOptions(final PhoneValidationOptions options) {
        this.phoneValidationOptions = options;
    }

    @Override
    public void setEnrichmentOptions(final EnrichmentOptions options) {
        this.enrichmentOptions = options;
    }

    @Override
    public void onEmailResponse(final ConnectionResponse<EmailValidationResponse> responseHandler) {
        queueManager.onEmailResponse(responseHandler);
    }

    @Override
    public void onEnrichmentResponse(final ConnectionResponse<EnrichmentResponse> responseHandler) {
        this.queueManager.onEnrichmentResponse(responseHandler);
    }

    @Override
    public void onPhoneResponse(final ConnectionResponse<PhoneValidationResponse> responseHandler) {
        this.queueManager.onPhoneResponse(responseHandler);
    }

    @Override
    public void onEmailRequest(final EmailValidationRequest emailValidationRequest) throws RateLimitException, ConnectionException {
        Contract.requiresNotNull(emailValidationRequest, "The emailValidationRequest field is required.");
        final EmailValidationRequestProxy proxy = new EmailValidationRequestProxy(emailValidationRequest, this.emailValidationOptions);
        this.queueManager.onEmailRequest(proxy);
    }

    @Override
    public void onPhoneRequest(final PhoneValidationRequest phoneValidationRequest) throws RateLimitException, ConnectionException {
        Contract.requiresNotNull(phoneValidationRequest, "The phoneValidationRequest field is required.");
        final PhoneValidationRequestProxy proxy = new PhoneValidationRequestProxy(phoneValidationRequest, this.phoneValidationOptions);
        this.queueManager.onPhoneRequest(proxy);
    }

    @Override
    public void onEnrichmentRequest(final EnrichmentRequest enrichmentRequest) throws RateLimitException, ConnectionException {
        Contract.requiresNotNull(enrichmentRequest, "The enrichmentRequest field is required.");
        final EnrichmentRequestProxy proxy = new EnrichmentRequestProxy(enrichmentRequest, this.enrichmentOptions);
        this.queueManager.onEnrichmentRequest(proxy);
    }

    @Override
    public PublishSubject<FailRequestResponse> onRequestFailure() {
        return this.queueManager.onRequestFailure();
    }

    @Override
    public PublishSubject<ConnectionFailResponse> onConnectionFailure() {
        return this.queueManager.onConnectionFailure();
    }
}

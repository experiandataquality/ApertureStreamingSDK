package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.RequestProxyBase;
import com.experian.aperture.streaming.client.response.ConnectionFailResponse;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.response.enrichment.EnrichmentResponse;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the request queue manager methods.
 */
public class DefaultRequestManager implements RequestManager {
    private final Connection connection;
    private final RequestContext requestContext;
    private final ResponseManager responseManager;
    private final ConnectionFailureHandler connectionFailureHandler;

    DefaultRequestManager(final Connection connection,
                          final RequestContext requestContext,
                          final ResponseManager responseManager,
                          final ConnectionFailureHandler connectionFailureHandler) {
        this.connection = connection;
        this.requestContext = requestContext;
        this.responseManager = responseManager;
        this.connectionFailureHandler = connectionFailureHandler;
    }

    @Override
    /* CHECKSTYLE_OFF: IllegalCatch */
    public void startStreaming() throws ConnectionException {
        this.connection.getConnectionEventSubject().subscribe(this::connectionEventSubscriber);
        this.connection.start();
        this.requestContext.clearAll();
        this.responseManager.registerDefaultResponseHandlers();
        this.responseManager.registerRequestResendHandler();
    }

    @Override
    public void stopStreaming() {
        this.connection.stop();
    }

    @Override
    public void onEmailRequest(final EmailValidationRequestProxy proxy) throws RateLimitException, ConnectionException {
        checkReferenceId(proxy.getReferenceId(), this.requestContext.getEmailRequestList());
        checkRateLimit(this.requestContext.getEmailRequestList(), proxy);
        this.requestContext.getEmailRequestList().add(proxy, proxy.getReferenceId());
        this.connection
                .send(StreamingMethod.EMAIL_REQUEST.getValue(), proxy)
                .subscribe(((aVoid, throwable) -> this.responseManager.handleError(StreamingMethod.EMAIL_REQUEST, proxy.getReferenceId(), throwable.getMessage())));
    }

    @Override
    public void onPhoneRequest(final PhoneValidationRequestProxy proxy) throws RateLimitException, ConnectionException {
        checkReferenceId(proxy.getReferenceId(), this.requestContext.getPhoneRequestList());
        checkRateLimit(this.requestContext.getPhoneRequestList(), proxy);
        this.requestContext.getPhoneRequestList().add(proxy, proxy.getReferenceId());
        this.connection
                .send(StreamingMethod.PHONE_REQUEST.getValue(), proxy)
                .subscribe(((aVoid, throwable) -> this.responseManager.handleError(StreamingMethod.EMAIL_REQUEST, proxy.getReferenceId(), throwable.getMessage())));
    }

    @Override
    public void onEnrichmentRequest(final EnrichmentRequestProxy proxy) throws RateLimitException, ConnectionException {
        checkReferenceId(proxy.getReferenceId(), this.requestContext.getEnrichmentRequestList());
        checkRateLimit(this.requestContext.getEnrichmentRequestList(), proxy);
        this.requestContext.getEnrichmentRequestList().add(proxy, proxy.getReferenceId());
        this.connection
                .send(StreamingMethod.ENRICHMENT_REQUEST.getValue(), proxy)
                .subscribe(((aVoid, throwable) -> this.responseManager.handleError(StreamingMethod.EMAIL_REQUEST, proxy.getReferenceId(), throwable.getMessage())));
    }

    @Override
    public void onEmailResponse(final ConnectionResponse<EmailValidationResponse> responseHandler) {
        this.connection.subscribe(StreamingMethod.EMAIL_RESPONSE.getValue(), responseHandler, EmailValidationResponse.class);
    }

    @Override
    public void onPhoneResponse(final ConnectionResponse<PhoneValidationResponse> responseHandler) {
        this.connection.subscribe(StreamingMethod.PHONE_RESPONSE.getValue(), responseHandler, PhoneValidationResponse.class);
    }

    @Override
    public void onEnrichmentResponse(final ConnectionResponse<EnrichmentResponse> responseHandler) {
        this.connection.subscribe(StreamingMethod.ENRICHMENT_RESPONSE.getValue(), responseHandler, EnrichmentResponse.class);
    }

    @Override
    public PublishSubject<FailRequestResponse> onRequestFailure() {
        return this.responseManager.getFailRequestSubject();
    }

    @Override
    public PublishSubject<ConnectionFailResponse> onConnectionFailure() {
        return this.connectionFailureHandler.getConnectionFailureSubject();
    }

    private <T extends RequestProxyBase> void checkReferenceId(final String referenceId, RequestList<T> requestList) {
        if (requestList.containsKey(referenceId)) {
            throw new IllegalArgumentException(String.format("Duplicate reference Id %s.", referenceId));
        }
    }

    private <T extends RequestProxyBase> void checkRateLimit(final RequestList<T> requestList, RequestProxyBase proxy) throws RateLimitException {
        if (!requestList.canAdd()) {
            throw new RateLimitException(proxy);
        }
    }

    private void connectionEventSubscriber(ConnectionEvent connectionEvent) {
        this.connectionFailureHandler.handle(connectionEvent,
                this.requestContext.getEmailRequestList().getAllReferenceIds(),
                this.requestContext.getPhoneRequestList().getAllReferenceIds(),
                this.requestContext.getEnrichmentRequestList().getAllReferenceIds());
    }
}
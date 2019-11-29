package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.response.ResponseBase;

import static org.mockito.Mockito.*;

/**
 * Response handler steps.
 */
final class ResponseHandlerSteps {
    private BaseResponseHandler responseHandler;
    private RequestList mockRequestList;

    /**
     * Set up the email response handler.
     * @return The steps.
     */
    ResponseHandlerSteps givenISetupEmailResponseHandler() {
        this.mockRequestList = (RequestList<EmailValidationRequestProxy>) mock(RequestList.class);
        this.responseHandler = new EmailResponseHandler(this.mockRequestList);
        return this;
    }

    /**
     * Set up the phone response handler.
     * @return The steps.
     */
    ResponseHandlerSteps givenISetupPhoneResponseHandler() {
        this.mockRequestList = (RequestList<PhoneValidationRequestProxy>) mock(RequestList.class);
        this.responseHandler = new PhoneResponseHandler(this.mockRequestList);
        return this;
    }

    /**
     * Set up the enrichment response handler.
     * @return The steps.
     */
    ResponseHandlerSteps givenISetupEnrichmentResponseHandler() {
        this.mockRequestList = (RequestList<EnrichmentRequestProxy>) mock(RequestList.class);
        this.responseHandler = new EnrichmentResponseHandler(this.mockRequestList);
        return this;
    }

    /**
     * Invoke invoke.
     * @param response The response.
     * @param <T> The response.
     * @return The steps.
     */
    <T extends ResponseBase> ResponseHandlerSteps whenIInvokeResponseHandler(final T response) {
        this.responseHandler.invoke(response);
        return this;
    }

    /**
     * Assert remove is invoked based on the specified reference Id.
     * @param times The wanted number of invocations.
     * @param referenceId The reference id.
     * @return The steps.
     */
    ResponseHandlerSteps thenRemoveIsInvoked(final int times, final String referenceId) {
        verify(this.mockRequestList, times(times)).remove(eq(referenceId));
        return this;
    }

    /**
     * Assert registerRateLimit is invoked with the specified values.
     * @param times The wanted number of invocations.
     * @param rateRemaining The rate remaining.
     * @param rateReset The rate reset.
     * @return The steps.
     */
    ResponseHandlerSteps thenRegisterRateLimitIsInvoked(final int times, final Long rateRemaining, final Long rateReset) {
        verify(this.mockRequestList, times(times)).registerRateLimit(eq(rateRemaining), eq(rateReset));
        return this;
    }
}

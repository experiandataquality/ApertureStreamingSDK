package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.response.ResponseBase;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Response manager steps.
 */
final class ResponseManagerSteps {
    private ResponseManager responseManager;
    private Connection mockConnection = mock(Connection.class);
    private RequestContext mockRequestContext = mock(RequestContext.class);
    private ErrorResponseHandler mockErrorResponseHandler = mock(ErrorResponseHandler.class);

    /**
     * Set up the response manager using the default builder.
     * @return The steps.
     */
    ResponseManagerSteps givenISetupResponseManager() {
        this.responseManager = ResponseManagerBuilder.builder()
                .create(mockConnection, mockRequestContext, mockErrorResponseHandler)
                .build();
        return this;
    }

    /**
     * Invoke registerDefaultResponseHandlers.
     * @return The steps.
     */
    ResponseManagerSteps whenIRegisterDefaultResponseHandlers() {
        this.responseManager.registerDefaultResponseHandlers();
        return this;
    }

    /**
     * Invoke registerRequestResendHandler.
     * @return The steps.
     */
    ResponseManagerSteps whenIRegisterRequestResendHandler() {
        this.responseManager.registerRequestResendHandler();
        return this;
    }

    /**
     * Assert that the default handler is subscribed with the defined values.
     * @param times The wanted number of invocations.
     * @param responseMethod The response method.
     * @param responseHandler The response handler.
     * @param responseModel The response model.
     * @param <T1> The response handler.
     * @param <T2> The response.
     * @return The steps.
     */
    <T1 extends BaseResponseHandler, T2 extends ResponseBase> ResponseManagerSteps thenDefaultResponseHandlerIsSubscribedToTheConnection(final int times,
                                                                                                                                         final String responseMethod,
                                                                                                                                         final Class<T1> responseHandler, final Class<T2> responseModel) {
        verify(mockConnection, times(times)).subscribe(eq(responseMethod),
                Mockito.any(responseHandler),
                eq(responseModel));
        return this;
    }

    /**
     * Assert that all request lists are invoked once.
     * @return The steps.
     */
    ResponseManagerSteps thenAllGetRequestListAreInvokedOnce() {
        verify(mockRequestContext, times(1)).getEmailRequestList();
        verify(mockRequestContext, times(1)).getPhoneRequestList();
        verify(mockRequestContext, times(1)).getEnrichmentRequestList();
        return this;
    }

    /**
     * Assert that connection resend callback is set.
     * @return The steps.
     */
    ResponseManagerSteps thenConnectionResendCallbackIsSet() {
        verify(mockConnection, times(1)).setAutoResendCallback(Mockito.any(RequestResendHandler.class));
        return this;
    }
}

package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.ConnectionException;
import com.experian.aperture.streaming.client.list.*;
import io.reactivex.Single;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * The request resend handler test steps.
 * */
public class RequestResendHandlerSteps {
    private RequestContext requestContext = mock(RequestContext.class);
    private Connection connection = mock(Connection.class);
    private ErrorResponseHandler errorResponseHandler = mock(ErrorResponseHandler.class);
    private Single<Void> mockSubscribe = (Single<Void>) mock(Single.class);
    private RequestResendHandler handler;

    /**
     * To set up request context to return EmailRequestList.
     * @param emailRequestList The email request list.
     * @return The request resend handler steps.
     * */
    public RequestResendHandlerSteps givenISetupRequestContextWithEmailRequestList(final EmailRequestList emailRequestList) {
        Mockito.when(requestContext.getEmailRequestList()).thenReturn(emailRequestList);
        return this;
    }

    /**
     * To set up request context to return PhoneRequestList.
     * @param phoneRequestList The phone request list.
     * @return The request resend handler steps.
     * */
    public RequestResendHandlerSteps givenISetupRequestContextWithPhoneRequestList(final PhoneRequestList phoneRequestList) {
        Mockito.when(requestContext.getPhoneRequestList()).thenReturn(phoneRequestList);
        return this;
    }

    /**
     * To set up request context to return EnrichmentRequestList.
     * @param enrichmentRequestList The enrichment request list.
     * @return The request resend handler steps.
     * */
    public RequestResendHandlerSteps givenISetupRequestContextWithEnrichmentRequestList(final EnrichmentRequestList enrichmentRequestList) {
        Mockito.when(requestContext.getEnrichmentRequestList()).thenReturn(enrichmentRequestList);
        return this;
    }

    /**
     * To set up request context to return AddressRequestList.
     * @param addressRequestList The address request list.
     * @return The request resend handler steps.
     * */
    public RequestResendHandlerSteps givenISetupRequestContextWithAddressRequestList(final AddressRequestList addressRequestList) {
        Mockito.when(requestContext.getAddressRequestList()).thenReturn(addressRequestList);
        return this;
    }

    /**
     * To create RequestResendHandler.
     * @return The request resend handler steps.
     * @throws ConnectionException Throws the ConnectionException.
     * */
    public RequestResendHandlerSteps givenIHaveRequestResendHandler() throws ConnectionException {
        when(this.connection.send(any(String.class), any(Object.class))).thenReturn(mockSubscribe);
        this.handler = new RequestResendHandler(this.requestContext, this.connection, this.errorResponseHandler);
        return this;
    }

    /**
     * To resend all available request in the list.
     * @return The request resend handler steps.
     * */
    public RequestResendHandlerSteps whenIResendRequest() {
        this.handler.run();
        return this;
    }

    /**
     * To validate the times of email requests are sent.
     * @param times The number of times that the requests are sent.
     * @return The request resend handler steps.
     * @throws ConnectionException The ConnectionException.
     * */
    public RequestResendHandlerSteps thenEmailRequestIsSend(final int times) throws ConnectionException {
        Mockito.verify(this.connection, times(times)).send(eq("ValidateEmail"), Mockito.any(Object.class));
        return this;
    }

    /**
     * To validate the times of phone requests are sent.
     * @param times The number of times that the requests are sent.
     * @return The request resend handler steps.
     * @throws ConnectionException The ConnectionException.
     * */
    public RequestResendHandlerSteps thenPhoneRequestIsSend(final int times) throws ConnectionException {
        Mockito.verify(this.connection, times(times)).send(eq("ValidatePhone"), Mockito.any(Object.class));
        return this;
    }

    /**
     * To validate the times of enrichment requests are sent.
     * @param times The number of times that the requests are sent.
     * @return The request resend handler steps.
     * @throws ConnectionException The ConnectionException.
     * */
    public RequestResendHandlerSteps thenEnrichRequestIsSend(final int times) throws ConnectionException {
        Mockito.verify(this.connection, times(times)).send(eq("Enrich"), Mockito.any(Object.class));
        return this;
    }

    /**
     * To validate the times of enrichment requests are sent.
     * @param times The number of times that the requests are sent.
     * @return The request resend handler steps.
     * @throws ConnectionException The ConnectionException.
     * */
    public RequestResendHandlerSteps thenAddressRequestIsSend(final int times) throws ConnectionException {
        Mockito.verify(this.connection, times(times)).send(eq("ValidateAddress"), Mockito.any(Object.class));
        return this;
    }
}

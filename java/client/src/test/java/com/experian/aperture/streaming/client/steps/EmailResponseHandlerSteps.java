package com.experian.aperture.streaming.client.steps;

import com.experian.aperture.streaming.client.handler.EmailResponseHandler;
import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;

import static org.junit.Assert.*;

/**
 * EmailResponseHandler steps.
 */
public final class EmailResponseHandlerSteps {
    private EmailResponseHandler emailResponseHandler;
    private RequestList requestList;

    /**
     * Setup the EmailResponseHandler.
     * @param requestList The request list.
     * @return The EmailResponseHandlerSteps.
     */
    public EmailResponseHandlerSteps givenIHaveAnEmailResponseHandler(final RequestList requestList) {
        this.requestList = requestList;
        this.emailResponseHandler = new EmailResponseHandler(this.requestList);
        return this;
    }

    /**
     * Call the invoke method.
     * @param emailValidationResponse The email validation response.
     * @return The EmailResponseHandlerSteps.
     */
    public EmailResponseHandlerSteps whenICallInvoke(final EmailValidationResponse emailValidationResponse) {
        this.emailResponseHandler.invoke(emailValidationResponse);
        return this;
    }

    /**
     * Assert the request with the reference id is still in the request list.
     * @param referenceId The request reference id.
     * @return The EmailResponseHandlerSteps.
     */
    public EmailResponseHandlerSteps thenShouldContainRequest(final String referenceId) {
        assertTrue(this.requestList.containsKey(referenceId));
        return this;
    }

    /**
     * Assert the request with the reference id is no longer in the request list.
     * @param referenceId The request reference id.
     * @return The EmailResponseHandlerSteps.
     */
    public EmailResponseHandlerSteps thenShouldNotContainRequest(final String referenceId) {
        assertFalse(this.requestList.containsKey(referenceId));
        return this;
    }
}
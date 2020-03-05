package com.experian.aperture.streaming.client.steps;

import com.experian.aperture.streaming.client.handler.AddressResponseHandler;
import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.address.AddressValidationResponse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test steps for address response handler.
 * */
public final class AddressResponseHandlerSteps {
    private AddressResponseHandler handler;
    private RequestList requestList;

    /**
     * To create AddressResponseHandler.
     * @param requestList The address request list.
     * @return The address response handler steps.
     */
    public AddressResponseHandlerSteps givenIHaveAddressResponseHandler(final RequestList requestList) {
        this.requestList = requestList;
        handler = new AddressResponseHandler(requestList);
        return this;
    }

    /**
     * To call invoke method.
     * @param response The Address Validation response.
     * @return The address response handler steps.
     */
    public AddressResponseHandlerSteps whenICallInvoke(final AddressValidationResponse response) {
        handler.invoke(response);
        return this;
    }

    /**
     * Assert the request with the reference id is still in the request list.
     * @param referenceId The request reference id.
     * @return The address response handler steps.
     */
    public AddressResponseHandlerSteps thenShouldContainRequest(final String referenceId) {
        assertTrue(this.requestList.containsKey(referenceId));
        return this;
    }

    /**
     * Assert the request with the reference id is no longer in the request list.
     * @param referenceId The request reference id.
     * @return The address response handler steps.
     */
    public AddressResponseHandlerSteps thenShouldNotContainRequest(final String referenceId) {
        assertFalse(this.requestList.containsKey(referenceId));
        return this;
    }
}

package com.experian.aperture.streaming.client.response;

import com.experian.aperture.streaming.client.ErrorCode;
import com.experian.aperture.streaming.client.StreamingMethod;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * ErrorFailureMessageFactory tests steps.
 */
final class FailRequestResponseFactoryTestsSteps {
    private String message;
    private ArrayList<FailRequestResponse> failResponses;

    /**
     * Create a fail request response.
     * @param errorMessage The error message thrown from the server.
     * @param method The validation request method.
     * @param referenceId The reference id of the requests.
     * @return HubExceptionFactoryTestsSteps.
     */
    FailRequestResponseFactoryTestsSteps whenICreateFailRequestResponse(final StreamingMethod method, final String referenceId, final String errorMessage) {
        message = FailRequestResponseFactory.createFailRequestResponse(method, referenceId, errorMessage).getError().getValue();
        return this;
    }

    /**
     * Assert the error message.
     * @param errorMessage The error message thrown from the server.
     * @return HubExceptionFactoryTestsSteps.
     */
    FailRequestResponseFactoryTestsSteps thenIShouldGetTheErrorMessage(final String errorMessage) {
        assertThat(message, is(errorMessage));
        return this;
    }

    /**
     * Create a list of fail request responses.
     * @param method The method name.
     * @param error The error code.
     * @param referenceIds The list of reference Ids.
     * @return HubExceptionFactoryTestsSteps
     */
    FailRequestResponseFactoryTestsSteps whenICreateFailRequestResponses(final StreamingMethod method, final ErrorCode error, final List<String> referenceIds) {
        this.failResponses = FailRequestResponseFactory.createFailRequestResponses(method, error, referenceIds);
        return this;
    }

    /**
     * Assert the list size.
     * @param expectedCount The expected size.
     * @return HubExceptionFactoryTestsSteps
     */
    FailRequestResponseFactoryTestsSteps thenIShouldGetTheFailResponseListOfExpectedCount(final int expectedCount) {
        assertThat(this.failResponses.size(), is(expectedCount));
        return this;
    }

    /**
     * Assert the fail request method.
     * @param expectedMethod The expected method.
     * @return HubExceptionFactoryTestsSteps
     */
    FailRequestResponseFactoryTestsSteps thenIShouldGetTheFailResponseListOfExpectedMethod(final StreamingMethod expectedMethod) {
        assertTrue(this.failResponses.stream().allMatch(x -> x.getMethod().equals(expectedMethod)));
        return this;
    }

    /**
     * Assert the fail request error code.
     * @param expectedErrorCode The expected error code.
     * @return HubExceptionFactoryTestsSteps
     */
    FailRequestResponseFactoryTestsSteps thenIShouldGetTheFailResponseListOfExpectedErrorCode(final ErrorCode expectedErrorCode) {
        assertTrue(this.failResponses.stream().allMatch(x -> x.getError().equals(expectedErrorCode)));
        return this;
    }
}

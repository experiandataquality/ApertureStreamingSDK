package com.experian.aperture.streaming.client.response;

import com.experian.aperture.streaming.client.ErrorCode;
import com.experian.aperture.streaming.client.StreamingMethod;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FailRequestResponseFactory Tests.
 */
public final class FailRequestResponseFactoryTests {
    private static final String rateLimitedMessage = "429 (Too Many Request) Your account has been blocked for one minute as the rate at which you are submitting requests is too high. Wait one minute and reduce the rate you are submitting requests.";
    private static final String entitlementErrorMessage = "401 (Unauthorized) The request is not authorized. Check you have entered a valid Token from a deployment that contains an active product license.";
    private static final String hubMemoryBusyMessage = "503 (Service Unavailable) The hub is currently busy or down for maintenance. Check status.edq.com or wait 5 minutes and try again.";

    private FailRequestResponseFactoryTestsSteps steps = new FailRequestResponseFactoryTestsSteps();

    /**
     * Test the rate limited message.
     */
    @Test
    public void shouldGetRateLimitedMessage() {
        steps
            .whenICreateFailRequestResponse(StreamingMethod.EMAIL_REQUEST, "testing", "429 (Too Many Request)")
            .thenIShouldGetTheErrorMessage(rateLimitedMessage);
    }

    /**
     * Test the request unauthorized message.
     */
    @Test
    public void shouldGetUnauthorizedMessage() {
        steps
            .whenICreateFailRequestResponse(StreamingMethod.EMAIL_REQUEST, "testing", "401 (Unauthorized)")
            .thenIShouldGetTheErrorMessage(entitlementErrorMessage);
    }

    /**
     * Test the hub memory message.
     */
    @Test
    public void shouldGetHubMemoryBusyException() {
        steps
            .whenICreateFailRequestResponse(StreamingMethod.EMAIL_REQUEST, "testing", "503 (Service Unavailable)")
            .thenIShouldGetTheErrorMessage(hubMemoryBusyMessage);
    }

    /**
     * Test creating a valid list of fail request responses.
     */
    @Test
    public void shouldCreateFailRequestResponseList() {
        final List<String> referenceIds = Arrays.asList("Test1", "Test2");
        steps
                .whenICreateFailRequestResponses(StreamingMethod.EMAIL_REQUEST, ErrorCode.RECONNECT_FAILURE, referenceIds)
                .thenIShouldGetTheFailResponseListOfExpectedCount(2)
                .thenIShouldGetTheFailResponseListOfExpectedMethod(StreamingMethod.EMAIL_REQUEST)
                .thenIShouldGetTheFailResponseListOfExpectedErrorCode(ErrorCode.RECONNECT_FAILURE);
    }

    /**
     * Test creating a list of fail request responses when an empty list of reference Ids is passed in.
     */
    @Test
    public void shouldCreateFailRequestResponseListWhenEmptyListIsPassedIn() {
        final List<String> referenceIds = new ArrayList<>();
        steps
                .whenICreateFailRequestResponses(StreamingMethod.EMAIL_REQUEST, ErrorCode.RECONNECT_FAILURE, referenceIds)
                .thenIShouldGetTheFailResponseListOfExpectedCount(0);
    }
}

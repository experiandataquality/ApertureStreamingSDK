package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.EmailRequestList;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;
import com.experian.aperture.streaming.client.steps.EmailResponseHandlerSteps;
import org.junit.Test;

import java.time.Instant;
import java.util.UUID;

/**
 * EmailResponseHandler tests.
 *
 */
public final class EmailResponseHandlerTests {
    private final String sampleEmail = "sample@example.com";
    private final EmailResponseHandlerSteps steps = new EmailResponseHandlerSteps();

    /**
     * Assert that invoke would remove the correct instance of {@code EmailResponseHandler}.
     *
     * @throws IllegalArgumentException Throws the IllegalArgumentException.
     */
    @Test
    public void should_removeItemInRequestQueue_when_invoke() throws IllegalArgumentException {
        final EmailRequestList requestList = new EmailRequestList();
        final String referenceId1 = UUID.randomUUID().toString();
        final String referenceId2 = UUID.randomUUID().toString();

        requestList.setRateReset(Instant.now());
        requestList.add(
                new EmailValidationRequestProxy(
                        RequestBuilder.builder()
                                .withEmailRequest(referenceId1)
                                .withEmail(sampleEmail)
                                .build(),
                        OptionsBuilder
                                .builder()
                                .withEmailOptions(false)
                                .build()),
                referenceId1);
        requestList.add(
                new EmailValidationRequestProxy(
                        RequestBuilder.builder()
                                .withEmailRequest(referenceId2)
                                .withEmail(sampleEmail)
                                .build(),
                        OptionsBuilder
                                .builder()
                                .withEmailOptions(false)
                                .build()),
                referenceId2);

        steps.givenIHaveAnEmailResponseHandler(requestList)
                .thenShouldContainRequest(referenceId1)
                .thenShouldContainRequest(referenceId2)
                .whenICallInvoke(new EmailValidationResponse(referenceId1, "transactionId", null, null, null, 1L, 1L, 1L))
                .thenShouldNotContainRequest(referenceId1)
                .thenShouldContainRequest(referenceId2);
    }
}
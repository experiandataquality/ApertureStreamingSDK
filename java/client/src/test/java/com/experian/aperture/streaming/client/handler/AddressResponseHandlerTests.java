package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.AddressRequestList;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.proxy.AddressValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.response.address.AddressValidationResponse;
import com.experian.aperture.streaming.client.steps.AddressResponseHandlerSteps;
import org.junit.Test;

import java.time.Instant;
import java.util.UUID;

/**
 * AddressResponseHandler tests. *
 */
public final class AddressResponseHandlerTests {
    private AddressResponseHandlerSteps steps = new AddressResponseHandlerSteps();

    /**
     * Assert that invoke would remove the correct instance of {@code AddressValidationResponseHandler}.
     */
    @Test
    public void should_removeItemInRequestQueue_when_invoke() {
        final AddressRequestList requestList = new AddressRequestList();
        requestList.setRateReset(Instant.now());
        final String referenceId1 = UUID.randomUUID().toString();
        requestList.add(getAddressValidationRequestProxy(referenceId1), referenceId1);
        final String referenceId2 = UUID.randomUUID().toString();
        requestList.add(getAddressValidationRequestProxy(referenceId2), referenceId2);
        final AddressValidationResponse expectedResponseToRemove = this.getExpectedResponse(referenceId1);
        this.steps
                .givenIHaveAddressResponseHandler(requestList)
                .whenICallInvoke(expectedResponseToRemove)
                .thenShouldContainRequest(referenceId2)
                .thenShouldNotContainRequest(referenceId1);
    }

    private AddressValidationRequestProxy getAddressValidationRequestProxy(final String referenceId) {
        final AddressValidationRequest request =  RequestBuilder
                .builder()
                .withAddressValidationRequest(referenceId)
                .withCountryIso("USA")
                .withBuilding("DummyBuilding")
                .withDataset("DummyDataSet")
                .withDeliveryService("DummyDeliveryService")
                .withLocality("DummyLocality")
                .withOrganization("DummyOrganization")
                .build();
        final AddressValidationOptions options = OptionsBuilder.builder()
                .withAddressOptions(false)
                .build();
        return new AddressValidationRequestProxy(request, options);
    }

    private AddressValidationResponse getExpectedResponse(final String referenceId) {
        return new AddressValidationResponse(referenceId, "transactionId", null, null, null, 1L, 1L, 1L);
    }
}

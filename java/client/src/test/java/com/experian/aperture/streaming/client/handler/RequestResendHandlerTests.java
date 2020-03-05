package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.ConnectionException;
import com.experian.aperture.streaming.client.list.AddressRequestList;
import com.experian.aperture.streaming.client.RandomGenerator;
import com.experian.aperture.streaming.client.list.EmailRequestList;
import com.experian.aperture.streaming.client.list.EnrichmentRequestList;
import com.experian.aperture.streaming.client.list.PhoneRequestList;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.experian.aperture.streaming.client.options.enrichment.EnrichmentOptions;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;
import com.experian.aperture.streaming.client.proxy.AddressValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import org.junit.Test;

/**
 * The request resend handler tests.
 * */
public class RequestResendHandlerTests {
    private String referenceId = "referenceId";
    private RequestResendHandlerSteps steps = new RequestResendHandlerSteps();
    private String randomString = RandomGenerator.generateRandomString();
    private String randomNumber = RandomGenerator.generateRandomNumber();
    /**
     * Test that email requests are send when there are requests in the list.
     * @throws ConnectionException The ConnectionException.
     * */
    @Test
    public void should_sendEmailRequest_whenEmailRequestListNotEmpty() throws ConnectionException {
        final EmailRequestList emailRequestList = getEmailRequestList(2);
        final PhoneRequestList phoneRequestList = getPhoneRequestList(0);
        final EnrichmentRequestList enrichmentRequestList = getEnrichmentRequestList(0);
        final AddressRequestList addressRequestList = getAddressRequestList(0);
        this.steps
                .givenISetupRequestContextWithEmailRequestList(emailRequestList)
                .givenISetupRequestContextWithPhoneRequestList(phoneRequestList)
                .givenISetupRequestContextWithEnrichmentRequestList(enrichmentRequestList)
                .givenISetupRequestContextWithAddressRequestList(addressRequestList)
                .givenIHaveRequestResendHandler()
                .whenIResendRequest()
                .thenEmailRequestIsSend(2)
                .thenEnrichRequestIsSend(0)
                .thenPhoneRequestIsSend(0)
                .thenAddressRequestIsSend(0);
    }

    /**
     * Test that phone requests are send when there are requests in the list.
     * @throws ConnectionException The ConnectionException.
     * */
    @Test
    public void should_sendPhoneRequest_whenPhoneRequestListNotEmpty() throws ConnectionException {
        final PhoneRequestList phoneRequestList = getPhoneRequestList(2);
        final EmailRequestList emailRequestList = getEmailRequestList(0);
        final EnrichmentRequestList enrichmentRequestList = getEnrichmentRequestList(0);
        final AddressRequestList addressRequestList = getAddressRequestList(0);
        this.steps
                .givenISetupRequestContextWithEmailRequestList(emailRequestList)
                .givenISetupRequestContextWithPhoneRequestList(phoneRequestList)
                .givenISetupRequestContextWithEnrichmentRequestList(enrichmentRequestList)
                .givenISetupRequestContextWithAddressRequestList(addressRequestList)
                .givenIHaveRequestResendHandler()
                .whenIResendRequest()
                .thenEmailRequestIsSend(0)
                .thenEnrichRequestIsSend(0)
                .thenPhoneRequestIsSend(2)
                .thenAddressRequestIsSend(0);
    }

    /**
     * Test that enrichment requests are send when there are requests in the list.
     * @throws ConnectionException The ConnectionException.
     * */
    @Test
    public void should_sendEnrichmentRequest_whenEnrichmentRequestListNotEmpty() throws ConnectionException {
        final PhoneRequestList phoneRequestList = getPhoneRequestList(0);
        final EmailRequestList emailRequestList = getEmailRequestList(0);
        final EnrichmentRequestList enrichmentRequestList = getEnrichmentRequestList(2);
        final AddressRequestList addressRequestList = getAddressRequestList(0);
        this.steps
                .givenISetupRequestContextWithEmailRequestList(emailRequestList)
                .givenISetupRequestContextWithPhoneRequestList(phoneRequestList)
                .givenISetupRequestContextWithEnrichmentRequestList(enrichmentRequestList)
                .givenISetupRequestContextWithAddressRequestList(addressRequestList)
                .givenIHaveRequestResendHandler()
                .whenIResendRequest()
                .thenEmailRequestIsSend(0)
                .thenEnrichRequestIsSend(2)
                .thenPhoneRequestIsSend(0)
                .thenAddressRequestIsSend(0);
    }

    /**
     * Test that enrichment requests are send when there are requests in the list.
     * @throws ConnectionException The ConnectionException.
     * */
    @Test
    public void should_senAddressRequest_whenAddressRequestListNotEmpty() throws ConnectionException {
        final PhoneRequestList phoneRequestList = getPhoneRequestList(0);
        final EmailRequestList emailRequestList = getEmailRequestList(0);
        final EnrichmentRequestList enrichmentRequestList = getEnrichmentRequestList(0);
        final AddressRequestList addressRequestList = getAddressRequestList(2);
        this.steps
                .givenISetupRequestContextWithEmailRequestList(emailRequestList)
                .givenISetupRequestContextWithPhoneRequestList(phoneRequestList)
                .givenISetupRequestContextWithEnrichmentRequestList(enrichmentRequestList)
                .givenISetupRequestContextWithAddressRequestList(addressRequestList)
                .givenIHaveRequestResendHandler()
                .whenIResendRequest()
                .thenEmailRequestIsSend(0)
                .thenEnrichRequestIsSend(0)
                .thenPhoneRequestIsSend(0)
                .thenAddressRequestIsSend(2);
    }

    private EmailRequestList getEmailRequestList(final int requestCount) {
        final EmailValidationRequest request = createEmailRequest();
        final EmailValidationOptions options = OptionsBuilder.builder().withEmailOptions(false).getDefault();
        final EmailValidationRequestProxy proxy = new EmailValidationRequestProxy(request, options);
        final EmailRequestList requestList = new EmailRequestList();
        for (int i = 0; i < requestCount; i++) {
            requestList.add(proxy, this.referenceId + i);
        }
        return  requestList;
    }

    private PhoneRequestList getPhoneRequestList(final int requestCount) {
        final PhoneValidationRequest request = createPhoneRequest();
        final PhoneValidationOptions options = OptionsBuilder.builder().withPhoneOptions(false).getDefault();
        final PhoneValidationRequestProxy proxy = new PhoneValidationRequestProxy(request, options);
        final PhoneRequestList requestList = new PhoneRequestList();
        for (int i = 0; i < requestCount; i++) {
            requestList.add(proxy, this.referenceId + i);
        }
        return requestList;
    }

    private EnrichmentRequestList getEnrichmentRequestList(final int requestCount) {
        final EnrichmentRequest request = createEnrichmentRequest();
        final EnrichmentOptions options = OptionsBuilder.builder().withEnrichmentOptions(false).getDefault();
        final EnrichmentRequestProxy proxy = new EnrichmentRequestProxy(request, options);
        final EnrichmentRequestList requestList = new EnrichmentRequestList();
        for (int i = 0; i < requestCount; i++) {
            requestList.add(proxy, this.referenceId + i);
        }
        return requestList;
    }

    private AddressRequestList getAddressRequestList(final int requestCount) {
        final AddressValidationRequestProxy proxy = getAddressValidationRequestProxy();
        final AddressRequestList requestList = new AddressRequestList();
        for (int i = 0; i < requestCount; i++) {
            requestList.add(proxy, this.referenceId + i);
        }
        return requestList;
    }

    private EmailValidationRequest createEmailRequest() {
        return RequestBuilder.builder()
                .withEmailRequest(this.referenceId)
                .withEmail("dummyEmail")
                .build();
    }

    private PhoneValidationRequest createPhoneRequest() {
        return RequestBuilder.builder()
                .withPhoneRequest(this.referenceId)
                .withNumber(randomNumber)
                .build();
    }

    private EnrichmentRequest createEnrichmentRequest() {
        final EnrichmentDatasetKeys datasetKeys = EnrichmentDatasetKeysBuilder.builder()
                .withDpid(randomString)
                .withPostcode(randomString)
                .withPin(randomString)
                .withGlobalAddressKey(randomString)
                .build();

        final EnrichmentDatasetAttributes attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withAusCvPostcodeList(AusCVPostcode.ADULTS_AT_ADDRESS_CODE, AusCVPostcode.ADULTS_AT_ADDRESS_DESCRIPTION)
                .build();

        return RequestBuilder.builder()
                .withEnrichmentRequest(this.referenceId)
                .withCountry("country")
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
    }

    private AddressValidationRequestProxy getAddressValidationRequestProxy() {
        final AddressValidationRequest request =  RequestBuilder
                .builder()
                .withAddressValidationRequest(this.referenceId)
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
}

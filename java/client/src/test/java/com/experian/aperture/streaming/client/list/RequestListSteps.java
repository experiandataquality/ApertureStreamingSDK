package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.RandomGenerator;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.EnrichmentRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

final class RequestListSteps {
    private RequestList requestList;
    private String randomString = RandomGenerator.generateRandomString();

    RequestListSteps givenISetupEmailRequestList() {
        this.requestList = new EmailRequestList();
        return this;
    }

    RequestListSteps givenISetupPhoneRequestList() {
        this.requestList = new PhoneRequestList();
        return this;
    }

    RequestListSteps givenISetupEnrichmentRequestList() {
        this.requestList = new EnrichmentRequestList();
        return this;
    }

    RequestListSteps whenIAddNewEmailRequest(final String input, final String referenceId) {
        this.requestList.add(createEmailProxy(input, referenceId), referenceId);
        return this;
    }

    RequestListSteps whenIAddNewPhoneRequest(final String input, final String referenceId) {
        this.requestList.add(createPhoneProxy(input, referenceId), referenceId);
        return this;
    }

    RequestListSteps whenIAddNewEnrichmentRequest(final String input, final String referenceId) {
        this.requestList.add(createEnrichmentProxy(input, referenceId), referenceId);
        return this;
    }

    RequestListSteps whenIRemoveARequest(final String referenceId) {
        this.requestList.remove(referenceId);
        return this;
    }

    RequestListSteps whenIRegisterRateLimit(final Long rateRemaining, final Long rateReset) {
        this.requestList.registerRateLimit(rateRemaining, rateReset);
        return this;
    }

    RequestListSteps whenISetRateRemaining(final Long rateRemaining) {
        this.requestList.setRateRemaining(rateRemaining);
        return this;
    }

    RequestListSteps whenISetRateReset(final Instant rateReset) {
        this.requestList.setRateReset(rateReset);
        return this;
    }

    RequestListSteps whenIClearList() {
        this.requestList.clear();
        return this;
    }

    RequestListSteps thenTheRequestListSizeShouldBe(final int expectedSize) {
        assertThat(this.requestList.getAll().size(), is(expectedSize));
        return this;
    }

    RequestListSteps thenContainsKeyShouldBe(final String referenceId, final Boolean expectedValue) {
        assertThat(this.requestList.containsKey(referenceId), is(expectedValue));
        return this;
    }

    RequestListSteps thenTheAddedRequestEmailAtTheSpecifiedIndexShouldBe(final int index, final String input) {
        assertThat(((EmailRequestList) this.requestList).getAll().get(index).getEmail(), is(input));
        return this;
    }

    RequestListSteps thenTheAddedRequestNumberAtTheSpecifiedIndexShouldBe(final int index, final String input) {
        assertThat(((PhoneRequestList) this.requestList).getAll().get(index).getNumber(), is(input));
        return this;
    }

    RequestListSteps thenTheAddedRequestCountryAtTheSpecifiedIndexShouldBe(final int index, final String input) {
        assertThat(((EnrichmentRequestList) this.requestList).getAll().get(index).getCountryIso(), is(input));
        return this;
    }

    RequestListSteps thenTheRateRemainingShouldBe(final Long expectedRateRemaining) {
        assertThat(this.requestList.getRateRemaining(), is(expectedRateRemaining));
        return this;
    }

    RequestListSteps thenTheConvertedRateResetShouldBe(final Instant expectedConvertedRateReset) {
        assertThat(this.requestList.getRateReset(), is(expectedConvertedRateReset));
        return this;
    }

    RequestListSteps thenCanAddShouldReturn(final Boolean expectedValue) {
        assertThat(this.requestList.canAdd(), is(expectedValue));
        return this;
    }

    RequestListSteps thenRateRemainingShouldReturn(final Long expectedValue) {
        assertThat(this.requestList.getRateRemaining(), is(expectedValue));
        return this;
    }

    RequestListSteps thenDefaultRateResetShouldBeAfter(final Instant currentExecutionTime) {
        assertTrue(this.requestList.getRateReset().compareTo(currentExecutionTime) > 0);
        return this;
    }

    RequestListSteps thenListOfReferenceIdsCountShouldBe(final int expectedCount) {
        assertThat(this.requestList.getAllReferenceIds().size(), is(expectedCount));
        return this;
    }

    RequestListSteps thenTheReferenceIdAtTheSpecifiedIndexShouldBe(final int expectedIndex, final String expectedReferenceId) {
        assertThat(this.requestList.getAllReferenceIds().get(expectedIndex), is(expectedReferenceId));
        return this;
    }

    private EmailValidationRequestProxy createEmailProxy(final String input, final String referenceId) {
        return new EmailValidationRequestProxy(createEmailRequest(input, referenceId), OptionsBuilder.builder().withEmailOptions(false).getDefault());
    }

    private EmailValidationRequest createEmailRequest(final String input, final String referenceId) {
        return RequestBuilder.builder()
                .withEmailRequest(referenceId)
                .withEmail(input)
                .build();
    }

    private PhoneValidationRequestProxy createPhoneProxy(final String input, final String referenceId) {
        return new PhoneValidationRequestProxy(createPhoneRequest(input, referenceId), OptionsBuilder.builder().withPhoneOptions(false).getDefault());
    }

    private PhoneValidationRequest createPhoneRequest(final String input, final String referenceId) {
        return RequestBuilder.builder()
                .withPhoneRequest(referenceId)
                .withNumber(input)
                .build();
    }

    private EnrichmentRequestProxy createEnrichmentProxy(final String input, final String referenceId) {
        return new EnrichmentRequestProxy(createEnrichmentRequest(input, referenceId), OptionsBuilder.builder().withEnrichmentOptions(false).getDefault());
    }

    private EnrichmentRequest createEnrichmentRequest(final String input, final String referenceId) {
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
                .withEnrichmentRequest(referenceId)
                .withCountry(input)
                .withKeys(datasetKeys)
                .withAttributes(attributes)
                .build();
    }
}
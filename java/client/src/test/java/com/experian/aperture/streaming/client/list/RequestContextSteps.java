package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.options.OptionsBuilder;
import com.experian.aperture.streaming.client.proxy.EmailValidationRequestProxy;
import com.experian.aperture.streaming.client.proxy.PhoneValidationRequestProxy;
import com.experian.aperture.streaming.client.request.RequestBuilder;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

final class RequestContextSteps {
    private RequestContext requestContext;

    RequestContextSteps givenISetupRequestContext() {
        this.requestContext = new DefaultRequestContext();
        return this;
    }

    RequestContextSteps whenIAddNewEmailRequest(final String input, final String referenceId) {
        this.requestContext.getEmailRequestList().add(createEmailProxy(input, referenceId), referenceId);
        return this;
    }

    RequestContextSteps whenIAddNewPhoneRequest(final String input, final String referenceId) {
        this.requestContext.getPhoneRequestList().add(createPhoneProxy(input, referenceId), referenceId);
        return this;
    }

    RequestContextSteps whenIClearAll() {
        this.requestContext.clearAll();
        return this;
    }

    RequestContextSteps thenEmailRequestListSizeShouldBe(final int expectedSize) {
        assertThat(this.requestContext.getEmailRequestList().getAll().size(), is(expectedSize));
        return this;
    }

    RequestContextSteps thenPhoneRequestListSizeShouldBe(final int expectedSize) {
        assertThat(this.requestContext.getPhoneRequestList().getAll().size(), is(expectedSize));
        return this;
    }

    RequestContextSteps thenEnrichmentRequestListSizeShouldBe(final int expectedSize) {
        assertThat(this.requestContext.getEnrichmentRequestList().getAll().size(), is(expectedSize));
        return this;
    }

    RequestContextSteps thenAddressRequestListSizeShouldBe(final int expectedSize) {
        assertThat(this.requestContext.getAddressRequestList().getAll().size(), is(expectedSize));
        return this;
    }

    private EmailValidationRequestProxy createEmailProxy(final String input, final String referenceId) {
        final EmailValidationRequestProxy proxy = new EmailValidationRequestProxy(createEmailRequest(input, referenceId), OptionsBuilder.builder().withEmailOptions(false).getDefault());
        return proxy;
    }

    private EmailValidationRequest createEmailRequest(final String input, final String referenceId) {
        final EmailValidationRequest request = RequestBuilder.builder()
                .withEmailRequest(referenceId)
                .withEmail(input)
                .build();
        return request;
    }

    private PhoneValidationRequestProxy createPhoneProxy(final String input, final String referenceId) {
        final PhoneValidationRequestProxy proxy = new PhoneValidationRequestProxy(createPhoneRequest(input, referenceId), OptionsBuilder.builder().withPhoneOptions(false).getDefault());
        return proxy;
    }

    private PhoneValidationRequest createPhoneRequest(final String input, final String referenceId) {
        final PhoneValidationRequest request = RequestBuilder.builder()
                .withPhoneRequest(referenceId)
                .withNumber(input)
                .build();
        return request;
    }
}
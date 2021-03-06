package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.RandomGenerator;
import org.junit.Before;
import org.junit.Test;

/**
 * RequestContextTests tests.
 */
public final class RequestContextTests {
    private RequestContextSteps steps;
    private String randomNumber = RandomGenerator.generateRandomNumber();

    /**
     * Setup before each test.
     */
    @Before
    public void setUp() {
        this.steps = new RequestContextSteps();
    }

    /**
     * Assert that a new instance of Request Context would have created 3 empty lists
     * for each email, phone and enrichment.
     */
    @Test
    public void should_CreateEmptyLists_When_NewlyInstantiated() {
        this.steps
                .givenISetupRequestContext()
                .thenEmailRequestListSizeShouldBe(0)
                .thenPhoneRequestListSizeShouldBe(0)
                .thenEnrichmentRequestListSizeShouldBe(0)
                .thenAddressRequestListSizeShouldBe(0);
    }

    /**
     * Assert that requests would be added to the respective list.
     */
    @Test
    public void should_AddANewRequestToRespectiveList_When_Add() {
        this.steps
                .givenISetupRequestContext()
                .whenIAddNewEmailRequest("abc@gmail.com", "emailProxy1")
                .whenIAddNewEmailRequest("bcd@gmail.com", "emailProxy2")
                .whenIAddNewPhoneRequest(randomNumber, "phoneProxy1")
                .thenEmailRequestListSizeShouldBe(2)
                .thenPhoneRequestListSizeShouldBe(1)
                .thenEnrichmentRequestListSizeShouldBe(0);
    }

    /**
     * Assert that all requests would be removed.
     */
    @Test
    public void should_RemoveAllRequests_When_ClearAll() {
        this.steps
                .givenISetupRequestContext()
                .whenIAddNewEmailRequest("abc@gmail.com", "emailProxy1")
                .whenIAddNewEmailRequest("bcd@gmail.com", "emailProxy2")
                .whenIAddNewPhoneRequest(randomNumber, "phoneProxy1")
                .thenEmailRequestListSizeShouldBe(2)
                .thenPhoneRequestListSizeShouldBe(1)
                .thenEnrichmentRequestListSizeShouldBe(0)
                .thenAddressRequestListSizeShouldBe(0)
                .whenIClearAll()
                .thenEmailRequestListSizeShouldBe(0)
                .thenPhoneRequestListSizeShouldBe(0)
                .thenEnrichmentRequestListSizeShouldBe(0)
                .thenAddressRequestListSizeShouldBe(0);
    }
}
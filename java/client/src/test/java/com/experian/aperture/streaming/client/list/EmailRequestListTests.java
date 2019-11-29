package com.experian.aperture.streaming.client.list;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.Instant;

/**
 * EmailRequestListTests tests.
 */
public final class EmailRequestListTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private RequestListSteps steps;
    private final String input1 = "abc@abc.com";
    private final String input2 = "bcd@abc.com";
    private final String referenceId1 = "test-reference-id1";
    private final String referenceId2 = "test-reference-id2";

    /**
     * Setup before each test.
     */
    @Before
    public void setUp() {
        this.steps = new RequestListSteps();
    }

    /**
     * Assert that a new request would be added to the list.
     */
    @Test
    public void add_shouldAddNewRequestWithNewReferenceId() {
        this.steps
                .givenISetupEmailRequestList()
                .thenListOfReferenceIdsCountShouldBe(0)
                .whenIAddNewEmailRequest(this.input1, this.referenceId1)
                .thenTheRequestListSizeShouldBe(1)
                .thenContainsKeyShouldBe(this.referenceId1, true);
    }

    /**
     * Assert that the same reference Id should only be added to the list once.
     *
     * @throws IllegalArgumentException when adding the same reference Id.
     */
    @Test
    public void add_shouldThrowExceptionWhenAddingNewRequestWithSameReferenceId() throws IllegalArgumentException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(String.format("Duplicate reference Id %s.", this.referenceId1));
        this.steps
                .givenISetupEmailRequestList()
                .whenIAddNewEmailRequest(this.input1, this.referenceId1)
                .whenIAddNewEmailRequest(this.input2, this.referenceId1);
    }

    /**
     * Assert that multiple requests should only be added provided the reference Id is unique.
     */
    @Test
    public void add_shouldAddNewRequestsWithUniqueReferenceId() {
        this.steps
                .givenISetupEmailRequestList()
                .whenIAddNewEmailRequest(this.input1, this.referenceId1)
                .whenIAddNewEmailRequest(this.input2, this.referenceId2)
                .thenTheRequestListSizeShouldBe(2)
                .thenTheAddedRequestEmailAtTheSpecifiedIndexShouldBe(0, this.input1)
                .thenTheAddedRequestEmailAtTheSpecifiedIndexShouldBe(1, this.input2)
                .thenListOfReferenceIdsCountShouldBe(2)
                .thenTheReferenceIdAtTheSpecifiedIndexShouldBe(0, this.referenceId1)
                .thenTheReferenceIdAtTheSpecifiedIndexShouldBe(1, this.referenceId2);
    }

    /**
     * Assert that a request can be removed from the list by reference Id.
     */
    @Test
    public void remove_shouldRemoveRequestSuccessfullyWithReferenceId() {
        this.steps
                .givenISetupEmailRequestList()
                .whenIAddNewEmailRequest(this.input1, this.referenceId1)
                .thenTheRequestListSizeShouldBe(1)
                .whenIRemoveARequest(this.referenceId1)
                .thenTheRequestListSizeShouldBe(0);
    }

    /**
     * Assert that registerRateLimit would store rateRemaining and convert rateReset to
     * an Instant instance.
     */
    @Test
    public void registerRateLimit_shouldRegisterRateRemainingAndRateReset() {
        final Long rateRemaining = Long.valueOf(2653);
        final Long rateReset = Long.valueOf(1572944760);

        this.steps
                .givenISetupEmailRequestList()
                .whenIRegisterRateLimit(rateRemaining, rateReset)
                .thenTheRateRemainingShouldBe(rateRemaining)
                .thenTheConvertedRateResetShouldBe(Instant.ofEpochSecond(rateReset));
    }

    /**
     * Assert that canAdd would return true on the first call and rate remaining and rate reset are set to the default value.
     *
     * Rate remaining should have a default value of 100.
     * Rate reset should have a default value of 60 seconds from the current time.
     */
    @Test
    public void canAdd_shouldReturnTrueOnFirstRequest() {
        final Instant currentExecutionTime = Instant.now();
        final Long defaultRateRemaining = Long.valueOf(100);
        this.steps
                .givenISetupEmailRequestList()
                .thenDefaultRateResetShouldBeAfter(currentExecutionTime)
                .thenRateRemainingShouldReturn(defaultRateRemaining)
                .thenCanAddShouldReturn(true);
    }

    /**
     * Assert that canAdd would return true if the rate remaining is larger than zero.
     */
    @Test
    public void canAdd_shouldReturnTrueWhenRemainingRateIsNotZero() {
        final Instant future = Instant.MAX;
        final Long rateRemaining = Long.valueOf(2000);

        this.steps
                .givenISetupEmailRequestList()
                .whenISetRateRemaining(rateRemaining)
                .whenISetRateReset(future)
                .thenCanAddShouldReturn(true);
    }

    /**
     * Assert that canAdd would return false if the rate remaining is smaller or equal to zero.
     */
    @Test
    public void canAdd_shouldReturnFalseWhenRemainingRateIsLessThanOne() {
        final Instant future = Instant.MAX;
        final Long rateRemaining = Long.valueOf(0);

        this.steps
                .givenISetupEmailRequestList()
                .whenISetRateRemaining(rateRemaining)
                .whenISetRateReset(future)
                .thenCanAddShouldReturn(false);
    }

    /**
     * Assert that canAdd would return true if the rateReset is already in the past.
     */
    @Test
    public void canAdd_shouldReturnTrueWhenRateResetHasPassed() {
        final Instant past = Instant.MIN;
        final Long rateRemaining = Long.valueOf(2000);

        this.steps
                .givenISetupEmailRequestList()
                .whenISetRateRemaining(rateRemaining)
                .whenISetRateReset(past)
                .thenCanAddShouldReturn(true);
    }

    /**
     * Assert that multiple requests are removed when clear is invoked.
     */
    @Test
    public void clear_shouldRemoveAllRequests() {
        this.steps
                .givenISetupEmailRequestList()
                .whenIAddNewEmailRequest(this.input1, this.referenceId1)
                .whenIAddNewEmailRequest(this.input2, this.referenceId2)
                .thenTheRequestListSizeShouldBe(2)
                .whenIClearList()
                .thenTheRequestListSizeShouldBe(0);
    }
}
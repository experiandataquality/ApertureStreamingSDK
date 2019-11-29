package com.experian.aperture.streaming.client.options;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The RetryOptions tests.
 * */
public class RetryOptionsTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private RetryOptionsSteps steps;
    private boolean defaultEnableAutoReconnect = true;
    private long defaultRestartIntervalInMilliseconds = 60000;
    private int defaultReconnectCount = 30;

    public RetryOptionsTests() {
        this.steps = new RetryOptionsSteps();
    }

    /**
     * Test to return valid RetryOptions.
     * */
    @Test
    public void should_returnRetryOptionsValue() {
        final RetryOptions expected = new RetryOptions(50, 1, false);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetRestartIntervalInMilliseconds(expected.getRestartIntervalInMilliseconds())
                .whenISetReconnectCount(expected.getReconnectCount())
                .whenISetEnableAutoReconnect(expected.getEnableAutoReconnect())
                .whenIBuild()
                .thenIShouldHaveRetryOptionsCreated(expected);
    }

    /**
     * Test to return default RetryOptions.
     * */
    @Test
    public void should_returnDefaultRetryOptions() {
        final RetryOptions expected = new RetryOptions(defaultRestartIntervalInMilliseconds, defaultReconnectCount, defaultEnableAutoReconnect);
        this.steps.whenIGetDefaultValuesOfRetryOptions()
                .thenIShouldHaveRetryOptionsCreated(expected);
    }

    /**
     * Test to return correct RetryOptions values when only reconnect count is provided.
     * */
    @Test
    public void should_returnDefaultReconnectCount_ifNotProvided() {
        final RetryOptions expected = new RetryOptions(defaultRestartIntervalInMilliseconds, 10, defaultEnableAutoReconnect);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetReconnectCount(expected.getReconnectCount())
                .whenIBuild()
                .thenIShouldHaveRetryOptionsCreated(expected);
    }

    /**
     * Test to return correct RetryOptions values when only restart interval in milliseconds is provided.
     * */
    @Test
    public void should_returnDefaultRestartIntervalInMilliseconds_ifNotProvided() {
        final RetryOptions expected = new RetryOptions(1000, defaultReconnectCount, defaultEnableAutoReconnect);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetRestartIntervalInMilliseconds(expected.getRestartIntervalInMilliseconds())
                .whenIBuild()
                .thenIShouldHaveRetryOptionsCreated(expected);
    }

    /**
     * Test to throw exception when restartIntervalInMilliseconds is set to 0.
     * */
    @Test
    public void should_throwException_whenRestartIntervalInMillisecondsIsZero() {
        this.exception.expect(IllegalArgumentException.class);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetRestartIntervalInMilliseconds(0);
    }

    /**
     * Test to throw exception when restartIntervalInMilliseconds is set to negative value.
     * */
    @Test
    public void should_throwException_whenRestartIntervalInMillisecondsIsNegative() {
        this.exception.expect(IllegalArgumentException.class);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetRestartIntervalInMilliseconds(-1);
    }

    /**
     * Test to throw exception when reconnectCount is set to 0.
     * */
    @Test
    public void should_throwException_whenReconnectCountIsZero() {
        this.exception.expect(IllegalArgumentException.class);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetReconnectCount(0);
    }

    /**
     * Test to throw exception when reconnectCount is set to negative value.
     * */
    @Test
    public void should_throwException_whenReconnectCountIsNegative() {
        this.exception.expect(IllegalArgumentException.class);
        this.steps.givenIHaveDefaultRetryOptions()
                .whenISetReconnectCount(-1);
    }
}

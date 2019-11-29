package com.experian.aperture.streaming.client.options;

import static org.junit.Assert.*;

/**
 * The retry options steps.
 * */
public class RetryOptionsSteps {
    private RetryOptionsBuilder builder;
    private RetryOptions actual;

    /**
     * Method to create RetryOptionsBuilder.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps givenIHaveDefaultRetryOptions() {
        this.builder = RetryOptionsBuilder.builder();
        return this;
    }

    /**
     * Method to set restart interval in milliseconds.
     * @param restartInterval The restart interval in milliseconds.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps whenISetRestartIntervalInMilliseconds(final long restartInterval) {
        this.builder.withRestartIntervalInMilliseconds(restartInterval);
        return this;
    }

    /**
     * Method to set restart interval in milliseconds.
     * @param reconnectCount The reconnect count.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps whenISetReconnectCount(final int reconnectCount) {
        this.builder.withReconnectionCount(reconnectCount);
        return this;
    }

    /**
     * Method to set the enable auto reconnect.
     * @param enableAutoReconnect The enable auto reconnect configuration.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps whenISetEnableAutoReconnect(final boolean enableAutoReconnect) {
        this.builder.withEnableAutoReconnect(enableAutoReconnect);
        return this;
    }

    /**
     * Method to build RetryOptionsBuilder.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps whenIBuild() {
        this.actual = builder.build();
        return this;
    }

    /**
     * Method to get the default values of RetryOptions.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps whenIGetDefaultValuesOfRetryOptions() {
        this.actual = RetryOptionsBuilder.builder().getDefault();
        return this;
    }

    /**
     * Method to assert the values of RetryOptions.
     * @param expected The expected values of RetryOptions to assert.
     * @return The RetryOptionsSteps.
     * */
    public RetryOptionsSteps thenIShouldHaveRetryOptionsCreated(final RetryOptions expected) {
        assertNotNull(this.actual);
        assertEquals(expected.getRestartIntervalInMilliseconds(), this.actual.getRestartIntervalInMilliseconds());
        assertEquals(expected.getReconnectCount(), this.actual.getReconnectCount());
        return this;
    }
}

package com.experian.aperture.streaming.client.options;

/**
 * Defines the retry options when disconnection to server happens.
 * */
public interface RetryOptionsBuilder {
    /**
     * Specifies the interval before restart the connection to server.
     *
     * @param restartIntervalInMilliseconds The restart interval in milliseconds.
     * @throws IllegalArgumentException When argument restartIntervalInMilliseconds is less than 1;
     * @return The retry options builder.
     * */
    RetryOptionsBuilder withRestartIntervalInMilliseconds(long restartIntervalInMilliseconds);

    /**
     * Specifies the count of retry connection to server.
     *
     * @param reconnectCount The count of retry connection to server.
     * @throws IllegalArgumentException When argument reconnectCount is less than 1;
     * @return The retry options builder.
     * */
    RetryOptionsBuilder withReconnectionCount(int reconnectCount);

    /**
     * Specifies the value to indicate whether to enable auto reconnect.
     *
     * @param enableAutoReconnect The value to indicate whether to enable auto reconnect.
     * @return The retry options builder.
     * */
    RetryOptionsBuilder withEnableAutoReconnect(boolean enableAutoReconnect);

    /**
     * Build the retry options.
     *
     * @return The RetryOptions.
     * */
    RetryOptions build();

    /**
     * Gets the default retry options values.
     *
     * @return The default retry options.
     */
    RetryOptions getDefault();

    /**
     * Gets the default retry options builder.
     *
     * @return The default retry options builder.
     */
    static RetryOptionsBuilder builder() {
        return new DefaultRetryOptionsBuilder();
    }
}

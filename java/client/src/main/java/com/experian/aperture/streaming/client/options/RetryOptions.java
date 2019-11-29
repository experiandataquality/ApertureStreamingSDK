package com.experian.aperture.streaming.client.options;

/**
 * The retry options when disconnection to server happens.
 * */
public class RetryOptions {
    /**
     * The count of retry connection to server.
     * */
    private int reconnectCount;

    /**
     * The interval to restart connection to server.
     * */
    private long restartIntervalInMilliseconds;

    /**
     * The configuration to enable or disable auto reconnect.
     * */
    private boolean enableAutoReconnect;

    /**
     * Initialize the RetryOptions.
     *
     * @param restartIntervalInMilliseconds The restart interval in milliseconds.
     * @param reconnectCount The count to retry connection to server.
     * @param enableAutoReconnect The configuration to enable or disable auto reconnect.
     * */
    public RetryOptions(final long restartIntervalInMilliseconds, final int reconnectCount, final boolean enableAutoReconnect) {
        this.restartIntervalInMilliseconds = restartIntervalInMilliseconds;
        this.reconnectCount = reconnectCount;
        this.enableAutoReconnect = enableAutoReconnect;
    }

    /**
     * Gets the restart interval in milliseconds.
     * @return The interval to restart connection to server.
     * */
    public long getRestartIntervalInMilliseconds() {
        return this.restartIntervalInMilliseconds;
    }

    /**
     * Gets the retry connection count.
     * @return The count to retry connection to server.
     * */
    public int getReconnectCount() {
        return this.reconnectCount;
    }

    /**
     * Gets the value indicating whether auto reconnect is enable.
     * @return The configuration whether the auto reconnect is enabled.
     * */
    public boolean getEnableAutoReconnect() {
        return this.enableAutoReconnect;
    }
}

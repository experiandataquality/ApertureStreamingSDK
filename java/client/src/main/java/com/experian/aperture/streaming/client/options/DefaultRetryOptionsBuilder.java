package com.experian.aperture.streaming.client.options;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;

/**
 * The default builder for retry options.
 * */
final class DefaultRetryOptionsBuilder implements RetryOptionsBuilder {
    private final int minimumAllowValue = 1;
    private final String restartIntervalInMillisecondsMessage = ResourceReader.getErrorMessageWithKeyFormat("RetryOptionsMinimumValueRequired", "restartIntervalInMilliseconds", minimumAllowValue);
    private final String reconnectionCount = ResourceReader.getErrorMessageWithKeyFormat("RetryOptionsMinimumValueRequired", "reconnectCount", minimumAllowValue);
    private final long defaultRestartWaitTimeInMilliseconds = 60000;
    private final int defaultReconnectCount = 30;
    private final boolean defaultEnableAutoReconnect = true;
    private long restartWaitTimeInMilliseconds = defaultRestartWaitTimeInMilliseconds;
    private int reconnectCount = defaultReconnectCount;
    private boolean enableAutoReconnect = defaultEnableAutoReconnect;

    @Override
    public RetryOptionsBuilder withRestartIntervalInMilliseconds(final long restartIntervalInMilliseconds) {
        Contract.requiresGreaterOrEqualThan(minimumAllowValue, restartIntervalInMilliseconds, restartIntervalInMillisecondsMessage);
        this.restartWaitTimeInMilliseconds = restartIntervalInMilliseconds;
        return this;
    }

    @Override
    public RetryOptionsBuilder withReconnectionCount(final int reconnectCount) {
        Contract.requiresGreaterOrEqualThan(minimumAllowValue, reconnectCount, reconnectionCount);
        this.reconnectCount = reconnectCount;
        return this;
    }

    @Override
    public RetryOptionsBuilder withEnableAutoReconnect(final boolean enableAutoReconnect) {
        this.enableAutoReconnect = enableAutoReconnect;
        return this;
    }

    @Override
    public RetryOptions build() {
        return new RetryOptions(this.restartWaitTimeInMilliseconds, this.reconnectCount, this.enableAutoReconnect);
    }

    @Override
    public RetryOptions getDefault() {
        return new RetryOptions(this.defaultRestartWaitTimeInMilliseconds, this.defaultReconnectCount, this.defaultEnableAutoReconnect);
    }
}
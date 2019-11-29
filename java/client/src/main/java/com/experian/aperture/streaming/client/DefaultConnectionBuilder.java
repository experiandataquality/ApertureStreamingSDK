package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.RetryOptions;

import java.net.URL;

/**
 * Defines the default connection builder methods.
 */
final class DefaultConnectionBuilder implements ConnectionBuilder, ConnectionBuilder.ConnectionConfigurationBuilder {
    private URL url;
    private String authToken;
    private RetryOptions retryOptions;

    @Override public ConnectionConfigurationBuilder create(final URL url) {
        this.url = url;
        return this;
    }

    @Override
    public ConnectionConfigurationBuilder withAuthToken(final String authToken) {
        this.authToken = authToken;
        return this;
    }

    @Override
    public ConnectionConfigurationBuilder withRetryOptionsConfiguration(final RetryOptions retryOptions) {
        this.retryOptions = retryOptions;
        return this;
    }

    @Override public Connection build() {
        return new SignalRConnection(this.url.toString(), this.authToken, retryOptions);
    }
}
package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.RetryOptions;

import java.net.URL;

/**
 * Defines the connection builder methods.
 */
public interface ConnectionBuilder {
    /**
     * To create connection configuration.
     *
     * @param url The connection url.
     * @return The connection configuration builder.
     */
    ConnectionConfigurationBuilder create(URL url);

    /**
     * Defines the connection configuration builder methods.
     */
    interface ConnectionConfigurationBuilder {
        /**
         * Specifies the security token.
         *
         * @param authToken the security token.
         * @return The connection configuration builder.
         */
        ConnectionConfigurationBuilder withAuthToken(String authToken);

        /**
         * Specifies the retry options when request gets disconnected from server.
         *
         * @param retryOptions The retry options.
         * @return The connection configuration builder.
         */
        ConnectionConfigurationBuilder withRetryOptionsConfiguration(RetryOptions retryOptions);

        /**
         * Builds the connection with the defined values.
         *
         * @return The connection.
         */
        Connection build();
    }

    /**
     * Gets the default connection builder.
     *
     * @return The default connection builder.
     */
    static ConnectionBuilder builder() {
        return new DefaultConnectionBuilder();
    }
}
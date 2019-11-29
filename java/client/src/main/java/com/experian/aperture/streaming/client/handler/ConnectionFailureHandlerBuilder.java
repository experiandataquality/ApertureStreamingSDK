package com.experian.aperture.streaming.client.handler;

/**
 * Defines the connection failure handler builder methods.
 */
public interface ConnectionFailureHandlerBuilder {
    /**
     * To create the connection handler handler with the defined values.
     *
     * @return The connection failure handler
     */
    ConnectionFailureHandler build();

    /**
     * Gets the default connection failure handler builder.
     *
     * @return The default connection failure handler builder.
     */
    static ConnectionFailureHandlerBuilder builder() {
        return new DefaultConnectionFailureHandlerBuilder();
    }
}
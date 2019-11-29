package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;

/**
 * Defines the request manager builder methods.
 */
public interface RequestManagerBuilder {
    /**
     * Creates the request manager configuration builder.
     *
     * @param connection The connection.
     * @param requestContext The request context.
     * @param responseManager The response manager.
     * @param connectionFailureHandler The connection failure handler.
     * @return The request manager configuration builder.
     */
    RequestManagerConfigurationBuilder create(Connection connection, RequestContext requestContext, ResponseManager responseManager, ConnectionFailureHandler connectionFailureHandler);

    /**
     * Defines the request manager configuration builder methods.
     */
    interface RequestManagerConfigurationBuilder {
        /**
         * Builds the request manager with the defined values.
         * @return The request manager.
         */
        RequestManager build();
    }

    /**
     * Gets the default request manager builder.
     *
     * @return The default request manager builder.
     */
    static RequestManagerBuilder builder() {
        return new DefaultRequestManagerBuilder();
    }
}
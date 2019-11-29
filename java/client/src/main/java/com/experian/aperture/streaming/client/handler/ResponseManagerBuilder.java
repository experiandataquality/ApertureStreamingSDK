package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.list.RequestContext;

/**
 * Defines the response manager builder methods.
 */
public interface ResponseManagerBuilder {
    /**
     * To create the response manager configuration builder.
     *
     * @param connection The connection.
     * @param requestContext The request context.
     * @param errorResponseHandler The error response handler.
     * @return The response manager configuration builder.
     */
    ResponseManagerConfigurationBuilder create(Connection connection, RequestContext requestContext, ErrorResponseHandler errorResponseHandler);

    /**
     * Defines the response manager configuration builder methods.
     */
    interface ResponseManagerConfigurationBuilder {
        /**
         * Builds the response manager with the defined values.
         *
         * @return The response manager.
         */
        ResponseManager build();
    }

    /**
     * Gets the default response manager builder.
     *
     * @return The default response manager builder.
     */
    static ResponseManagerBuilder builder() {
        return new DefaultResponseManagerBuilder();
    }
}
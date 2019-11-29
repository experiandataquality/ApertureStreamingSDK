package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestContext;

/**
 * Defines the error response handler builder methods.
 */
public interface ErrorResponseHandlerBuilder {
    /**
     * To create the error response handler configuration builder.
     *
     * @param requestContext The request context.
     * @return The error response handler configuration builder.
     */
    ErrorResponseHandlerConfigurationBuilder create(RequestContext requestContext);

    /**
     * Defines the error response handler configuration configuration builder methods.
     */
    interface ErrorResponseHandlerConfigurationBuilder {
        /**
         * To create the error response handler with the defined values.
         *
         * @return The error response handler
         */
        ErrorResponseHandler build();
    }

    /**
     * Gets the default error response handler builder.
     *
     * @return The default error response handler builder.
     */
    static ErrorResponseHandlerBuilder builder() {
        return new DefaultErrorResponseHandlerBuilder();
    }
}
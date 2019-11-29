package com.experian.aperture.streaming.client.list;

/**
 * Defines the request context builder methods.
 */
public interface RequestContextBuilder {
    /**
     * Builds the request context.
     *
     * @return The request context.
     */
    RequestContext build();

    /**
     * Gets the default request context builder.
     *
     * @return The default request context builder.
     */
    static RequestContextBuilder builder() {
        return new DefaultRequestContextBuilder();
    }
}
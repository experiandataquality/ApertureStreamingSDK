package com.experian.aperture.streaming.client.list;

/**
 * Defines the default request context builder methods.
 */
final class DefaultRequestContextBuilder implements RequestContextBuilder {

    @Override
    public RequestContext build() {
        return new DefaultRequestContext();
    }
}
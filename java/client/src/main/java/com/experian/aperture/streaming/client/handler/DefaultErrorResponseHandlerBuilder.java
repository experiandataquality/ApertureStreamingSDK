package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestContext;

final class DefaultErrorResponseHandlerBuilder implements ErrorResponseHandlerBuilder, ErrorResponseHandlerBuilder.ErrorResponseHandlerConfigurationBuilder {
    private RequestContext requestContext;

    @Override
    public ErrorResponseHandlerConfigurationBuilder create(final RequestContext requestContext) {
        this.requestContext = requestContext;
        return this;
    }

    @Override
    public ErrorResponseHandler build() {
        return new DefaultErrorResponseHandler(this.requestContext);
    }
}
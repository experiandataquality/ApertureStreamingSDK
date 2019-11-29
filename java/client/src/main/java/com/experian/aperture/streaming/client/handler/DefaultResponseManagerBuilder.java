package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.list.RequestContext;

final class DefaultResponseManagerBuilder implements ResponseManagerBuilder, ResponseManagerBuilder.ResponseManagerConfigurationBuilder {
    private Connection connection;
    private RequestContext requestContext;
    private ErrorResponseHandler errorResponseHandler;

    @Override
    public ResponseManagerConfigurationBuilder create(final Connection connection, final RequestContext requestContext, final ErrorResponseHandler errorResponseHandler) {
        this.connection = connection;
        this.requestContext = requestContext;
        this.errorResponseHandler = errorResponseHandler;
        return this;
    }

    @Override
    public ResponseManager build() {
        return new DefaultResponseManager(this.connection, this.requestContext, this.errorResponseHandler);
    }
}
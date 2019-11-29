package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;

/**
 * Defines the request manager builder methods.
 */
final class DefaultRequestManagerBuilder implements RequestManagerBuilder, RequestManagerBuilder.RequestManagerConfigurationBuilder {
    private Connection connection;
    private RequestContext requestContext;
    private ResponseManager responseManager;
    private ConnectionFailureHandler connectionFailureHandler;

    @Override
    public RequestManagerConfigurationBuilder create(final Connection connection,
                                                     final RequestContext requestContext,
                                                     final ResponseManager responseManager,
                                                     final ConnectionFailureHandler connectionFailureHandler) {
        this.connection = connection;
        this.requestContext = requestContext;
        this.responseManager = responseManager;
        this.connectionFailureHandler = connectionFailureHandler;
        return this;
    }

    @Override
    public RequestManager build() {
        return new DefaultRequestManager(this.connection, this.requestContext, this.responseManager, this.connectionFailureHandler);
    }
}

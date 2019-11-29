package com.experian.aperture.streaming.client.handler;

final class DefaultConnectionFailureHandlerBuilder implements  ConnectionFailureHandlerBuilder {
    @Override
    public ConnectionFailureHandler build() {
        return new DefaultConnectionFailureHandler();
    }
}
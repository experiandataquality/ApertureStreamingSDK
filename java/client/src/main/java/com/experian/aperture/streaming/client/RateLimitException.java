package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.proxy.RequestProxyBase;

/**
 * Defines the rate limit exception thrown from Hub while sending the request.
 */
public class RateLimitException extends Exception {
    private final RequestProxyBase proxyBase;

    RateLimitException(final RequestProxyBase proxyBase) {
        super(ErrorCode.RATE_LIMIT_ERROR.getValue());
        this.proxyBase = proxyBase;
    }

    public RequestProxyBase getProxyBase() {
        return this.proxyBase;
    }
}

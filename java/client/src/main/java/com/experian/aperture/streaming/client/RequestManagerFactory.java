package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.*;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.list.RequestContextBuilder;
import com.experian.aperture.streaming.client.options.RetryOptions;
import com.experian.aperture.streaming.client.options.RetryOptionsBuilder;

import java.net.URL;

/**
 * Defines the request manager factory methods.
 */
public final class RequestManagerFactory {
    private static RetryOptions defaultRetryOptions = RetryOptionsBuilder.builder().getDefault();

    private RequestManagerFactory() { }

    /**
     * Creates a new request manager instance with default settings of RetryOptions.
     * @param url The endpoint URL.
     * @param authToken The authentication token.
     * @return The request manager.
     */
    public static RequestManager newInstance(final URL url, final String authToken) {
        return newInstance(url, authToken, null);
    }

    /**
     * Creates a new request manager instance with default settings of RetryOptions.
     * @param url The endpoint URL.
     * @param authToken The authentication token.
     * @param retryOptions The retry options.
     * @return The request manager.
     */
    public static RequestManager newInstance(final URL url, final String authToken, final RetryOptions retryOptions) {
        final ConnectionBuilder.ConnectionConfigurationBuilder connectionConfigurationBuilder = ConnectionBuilder.builder()
                .create(url)
                .withAuthToken(authToken);
        if (retryOptions == null) {
            connectionConfigurationBuilder.withRetryOptionsConfiguration(defaultRetryOptions);
        } else {
            connectionConfigurationBuilder.withRetryOptionsConfiguration(retryOptions);
        }

        final Connection connection = connectionConfigurationBuilder.build();

        final RequestContext requestContext = RequestContextBuilder.builder()
                .build();

        final ErrorResponseHandler errorResponseHandler = ErrorResponseHandlerBuilder.builder()
                .create(requestContext)
                .build();

        final ConnectionFailureHandler connectionFailureHandler = ConnectionFailureHandlerBuilder.builder()
                .build();

        final ResponseManager responseManager = ResponseManagerBuilder.builder()
                .create(connection, requestContext, errorResponseHandler)
                .build();

        final RequestManager requestManager = RequestManagerBuilder.builder()
                .create(connection, requestContext, responseManager, connectionFailureHandler)
                .build();

        return requestManager;
    }
}
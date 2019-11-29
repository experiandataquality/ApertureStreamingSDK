package com.experian.aperture.streaming.client.steps;

import com.experian.aperture.streaming.client.Connection;
import com.experian.aperture.streaming.client.RequestManagerBuilder;
import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;

import static org.junit.Assert.*;

/**
 * DefaultRequestManagerBuilder steps.
 */
public final class DefaultRequestManagerBuilderSteps {
    private RequestManagerBuilder defaultRequestManagerBuilder;
    private RequestManagerBuilder.RequestManagerConfigurationBuilder requestManagerConfigurationBuilder;

    /**
     * Create a valid RequestManagerBuilder.
     * @return The DefaultRequestManagerBuilderSteps.
     */
    public DefaultRequestManagerBuilderSteps givenIHaveAValidDefaultRequestManagerBuilder() {
        this.requestManagerConfigurationBuilder = null;
        this.defaultRequestManagerBuilder = RequestManagerBuilder.builder();
        return this;
    }

    /**
     * When Create is called.
     * @param connection The connection.
     * @param requestContext The request context.
     * @param responseManager The response manager.
     * @param connectionFailureHandler The connection failure handler.
     * @return The DefaultRequestManagerBuilderSteps.
     */
    public DefaultRequestManagerBuilderSteps whenICallCreate(final Connection connection, final RequestContext requestContext, final ResponseManager responseManager, final ConnectionFailureHandler connectionFailureHandler) {
        requestManagerConfigurationBuilder = this.defaultRequestManagerBuilder.create(connection, requestContext, responseManager, connectionFailureHandler);
        return this;
    }

    /**
     * Assert that the requestManagerConfigurationBuilder is valid.
     * @return The DefaultRequestManagerBuilderSteps.
     */
    public DefaultRequestManagerBuilderSteps thenIWillGetValidRequestManagerConfigurationBuilder() {
        assertNotNull(this.requestManagerConfigurationBuilder);
        return this;
    }
}
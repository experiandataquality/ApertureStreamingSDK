package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.handler.ConnectionFailureHandler;
import com.experian.aperture.streaming.client.handler.ResponseManager;
import com.experian.aperture.streaming.client.list.RequestContext;
import com.experian.aperture.streaming.client.steps.DefaultRequestManagerBuilderSteps;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * DefaultRequestManagerBuilder tests.
 */
public final class DefaultRequestManagerBuilderTests {
    private final DefaultRequestManagerBuilderSteps steps = new DefaultRequestManagerBuilderSteps();
    /**
     * Assert that invoke would remove the correct instance of {@code EmailResponseHandler}.
     */
    @Test
    public void should_returnValidRequestManagerConfigurationBuilder_when_create() {
        this.steps
                .givenIHaveAValidDefaultRequestManagerBuilder()
                .whenICallCreate(mock(Connection.class), mock(RequestContext.class), mock(ResponseManager.class), mock(ConnectionFailureHandler.class))
                .thenIWillGetValidRequestManagerConfigurationBuilder();
    }
}
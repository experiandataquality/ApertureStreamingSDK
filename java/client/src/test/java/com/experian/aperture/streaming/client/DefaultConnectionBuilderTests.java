package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.RetryOptions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.MalformedURLException;

/**
 * SignalRConnectionBuilderImpl tests.
 *
 */
public final class DefaultConnectionBuilderTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String dummyUrl = "http://localhost";
    private DefaultConnectionBuilderSteps steps;

    public DefaultConnectionBuilderTests() {
        steps = new DefaultConnectionBuilderSteps();
    }

    /**
     * Test to return SignalRConnection with Auth Token.
     * @throws MalformedURLException The MalformedURLException.
     * */
    @Test
    public void should_returnSignalRConnection_providedWithAuthToken() throws MalformedURLException {
        steps.givenIHaveConnectionConfigurationBuilder(dummyUrl)
                .whenISetAuthToken("token")
                .whenIBuildTheConnectionConfigurationBuilder()
                .thenIShouldHaveSignalRConnection();
    }

    /**
     * Test to return SignalRConnection with RetryOptions.
     * @throws MalformedURLException The MalformedURLException.
     * */
    @Test
    public void should_returnSignalRConnection_providedWithRetryOptions() throws MalformedURLException {
        steps.givenIHaveConnectionConfigurationBuilder(dummyUrl)
                .whenISetAuthToken("token")
                .whenISetRetryOptions(new RetryOptions(1000, 5, true))
                .whenIBuildTheConnectionConfigurationBuilder()
                .thenIShouldHaveSignalRConnection();
    }

    /**
     * Should throw NullPointException when no auth token is provided.
     * @throws MalformedURLException The MalformedURLException.
     * */
    @Test
    public void should_throwNullPointException_whenAuthTokenIsNotSet() throws MalformedURLException {
        thrown.expect(NullPointerException.class);
        steps.givenIHaveConnectionConfigurationBuilder(dummyUrl)
                .whenIBuildTheConnectionConfigurationBuilder();
    }
}

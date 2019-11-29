package com.experian.aperture.streaming.client;

import com.experian.aperture.streaming.client.options.RetryOptions;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * The DefaultConnectionBuilder test steps.
 * */
public class DefaultConnectionBuilderSteps {
    private ConnectionBuilder.ConnectionConfigurationBuilder configurationBuilder;
    private Connection connection;

    /**
     * Method to create ConnectionConfigurationBuilder.
     * @param url The URL for building connection.
     * @return The DefaultConnectionBuilderSteps.
     * @throws MalformedURLException The MalformedURLException.
     * */
    public DefaultConnectionBuilderSteps givenIHaveConnectionConfigurationBuilder(final String url) throws MalformedURLException {
        this.configurationBuilder = ConnectionBuilder.builder().create(new URL(url));
        return this;
    }

    /**
     * Method to set auth token.
     * @param autoToken The authentication token.
     * @return The DefaultConnectionBuilderSteps.
     * */
    public DefaultConnectionBuilderSteps whenISetAuthToken(final String autoToken) {
        this.configurationBuilder.withAuthToken(autoToken);
        return this;
    }

    /**
     * Method to set retry options.
     * @param retryOptions The retry options.
     * @return The DefaultConnectionBuilderSteps.
     * */
    public DefaultConnectionBuilderSteps whenISetRetryOptions(final RetryOptions retryOptions) {
        this.configurationBuilder.withRetryOptionsConfiguration(retryOptions);
        return this;
    }

    /**
     * Method to build the ConnectionConfigurationBuilder.
     * @return The DefaultConnectionBuilderSteps.
     * */
    public DefaultConnectionBuilderSteps whenIBuildTheConnectionConfigurationBuilder() {
        this.connection = this.configurationBuilder.build();
        return this;
    }

    /**
     * Method to assert the created SignalRConnection creation.
     * @return The DefaultConnectionBuilderSteps.
     * */
    public DefaultConnectionBuilderSteps thenIShouldHaveSignalRConnection() {
        assertNotNull(this.connection);
        assertTrue(this.connection instanceof SignalRConnection);
        return this;
    }
}

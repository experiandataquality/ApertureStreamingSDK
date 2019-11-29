package com.experian.aperture.streaming.client;

/**
 * Defines the exception thrown when no connection to server.
 */
public class ConnectionException extends Exception {
    public ConnectionException(final String message) {
        super(message);
    }
}

package com.experian.aperture.streaming.client;

/**
 * Defines connection failure events.
 */
public enum ConnectionEvent {
    RECONNECT_FAILURE,
    FORBIDDEN,
    UNAUTHORIZED
}
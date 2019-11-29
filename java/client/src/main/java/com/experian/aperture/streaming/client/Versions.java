package com.experian.aperture.streaming.client;

/**
 * Defines the version for endpoint models.
 */
public enum Versions {
    EMAIL_VALIDATION_REQUEST("1.0"),
    ENRICHMENT_REQUEST("1.0"),
    PHONE_VALIDATION_REQUEST("1.0");

    private String value;

    Versions(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
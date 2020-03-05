package com.experian.aperture.streaming.client;

/**
 * Defines the name of streaming method for both client and server.
 */
public enum StreamingMethod {
    EMAIL_REQUEST("ValidateEmail"),
    ENRICHMENT_REQUEST("Enrich"),
    PHONE_REQUEST("ValidatePhone"),
    ADDRESS_REQUEST("ValidateAddress"),

    EMAIL_RESPONSE("OnEmailResponse"),
    ENRICHMENT_RESPONSE("OnEnrichResponse"),
    PHONE_RESPONSE("OnPhoneResponse"),
    ADDRESS_RESPONSE("OnAddressResponse");

    private String value;

    StreamingMethod(final String value) {
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
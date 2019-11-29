package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named Australia ConsumerView Person Data and its associated attributes.
 */
@JsonAdapter(AusCVPerson.Adapter.class)
public enum AusCVPerson {
    PIN("pin"),

    GENDER("gender"),

    HIN("hin"),

    LINKAGE_POSTCODE("linkage_postcode");

    private String value;

    AusCVPerson(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static AusCVPerson fromValue(final String text) {
        for (AusCVPerson b : AusCVPerson.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<AusCVPerson> {
        @Override
        public void write(final JsonWriter jsonWriter, final AusCVPerson enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AusCVPerson read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return AusCVPerson.fromValue(String.valueOf(value));
        }
    }
}

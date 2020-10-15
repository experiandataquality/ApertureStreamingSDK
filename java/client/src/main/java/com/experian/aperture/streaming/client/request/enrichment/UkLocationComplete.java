package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named Uk Location Complete Data and its associated attributes.
 */
@JsonAdapter(UkLocationComplete.Adapter.class)
public enum UkLocationComplete {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level"),

    X_COORDINATE("x_coordinate"),

    Y_COORDINATE("y_coordinate"),

    UDPRN("udprn"),

    UPRN("uprn");

    private String value;

    UkLocationComplete(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static UkLocationComplete fromValue(final String text) {
        for (UkLocationComplete b : UkLocationComplete.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<UkLocationComplete> {
        @Override
        public void write(final JsonWriter jsonWriter, final UkLocationComplete enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public UkLocationComplete read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return UkLocationComplete.fromValue(String.valueOf(value));
        }
    }
}

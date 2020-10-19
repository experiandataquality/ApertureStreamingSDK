package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named UK Location Essential Data and its associated attributes.
 */
@JsonAdapter(UkLocationEssential.Adapter.class)
public enum UkLocationEssential {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level"),

    UDPRN("udprn"),

    UPRN("uprn"),

    X_COORDINATE("x_coordinate"),

    Y_COORDINATE("y_coordinate");

    private String value;

    UkLocationEssential(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static UkLocationEssential fromValue(final String text) {
        for (UkLocationEssential b : UkLocationEssential.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<UkLocationEssential> {
        @Override
        public void write(final JsonWriter jsonWriter, final UkLocationEssential enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public UkLocationEssential read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return UkLocationEssential.fromValue(String.valueOf(value));
        }
    }
}

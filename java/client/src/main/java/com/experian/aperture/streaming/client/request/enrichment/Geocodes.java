package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named Geocodes Data and its associated attributes.
 */
@JsonAdapter(Geocodes.Adapter.class)
public enum Geocodes {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level");

    private String value;

    Geocodes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static Geocodes fromValue(final String text) {
        for (Geocodes b : Geocodes.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<Geocodes> {
        @Override
        public void write(final JsonWriter jsonWriter, final Geocodes enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Geocodes read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return Geocodes.fromValue(String.valueOf(value));
        }
    }
}

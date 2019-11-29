package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named Geocodes Data and its associated attributes.
 */
@JsonAdapter(Geocode.Adapter.class)
public enum Geocode {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level");

    private String value;

    Geocode(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static Geocode fromValue(final String text) {
        for (Geocode b : Geocode.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<Geocode> {
        @Override
        public void write(final JsonWriter jsonWriter, final Geocode enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Geocode read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return Geocode.fromValue(String.valueOf(value));
        }
    }
}

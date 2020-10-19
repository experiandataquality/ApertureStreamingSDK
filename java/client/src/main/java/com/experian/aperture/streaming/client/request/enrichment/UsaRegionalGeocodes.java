package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named USA Regional Geocodes Data and its associated attributes.
 */
@JsonAdapter(UsaRegionalGeocodes.Adapter.class)
public enum UsaRegionalGeocodes {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level");

    private String value;

    UsaRegionalGeocodes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static UsaRegionalGeocodes fromValue(final String text) {
        for (UsaRegionalGeocodes b : UsaRegionalGeocodes.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<UsaRegionalGeocodes> {
        @Override
        public void write(final JsonWriter jsonWriter, final UsaRegionalGeocodes enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public UsaRegionalGeocodes read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return UsaRegionalGeocodes.fromValue(String.valueOf(value));
        }
    }
}
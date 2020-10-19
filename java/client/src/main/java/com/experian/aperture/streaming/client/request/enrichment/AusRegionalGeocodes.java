package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named AUS Regional Geocodes Data and its associated attributes.
 */
@JsonAdapter(AusRegionalGeocodes.Adapter.class)
public enum AusRegionalGeocodes {
    LATITUDE("latitude"),

    LONGITUDE("longitude"),

    MATCH_LEVEL("match_level"),

    SA1("sa1"),

    MESHBLOCK("meshblock"),

    LGA_CODE("lga_code"),

    LGA_NAME("lga_name");

    private String value;

    AusRegionalGeocodes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static AusRegionalGeocodes fromValue(final String text) {
        for (AusRegionalGeocodes b : AusRegionalGeocodes.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<AusRegionalGeocodes> {
        @Override
        public void write(final JsonWriter jsonWriter, final AusRegionalGeocodes enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AusRegionalGeocodes read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return AusRegionalGeocodes.fromValue(String.valueOf(value));
        }
    }
}

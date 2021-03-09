package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named  New Zealand ConsumerView Household Data and its associated attributes.
 */
@JsonAdapter(NzlCVHousehold.Adapter.class)
public enum NzlCVHousehold {
    Head_Of_Household_Age("head_of_household_age"),

    Children_At_Address("children_at_address"),

    Household_Composition("household_composition"),

    Head_Of_Household_Lifestage("head_of_household_lifestage"),

    Adults_At_Address("adults_at_address"),

    Mosaic_Group("mosaic_group"),

    Mosaic_Type_Group("mosaic_type_group"),

    Mosaic_Segment("mosaic_segment");

    private String value;

    NzlCVHousehold(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static NzlCVHousehold fromValue(final String text) {
        for (NzlCVHousehold b : NzlCVHousehold.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<NzlCVHousehold> {
        @Override
        public void write(final JsonWriter jsonWriter, final NzlCVHousehold enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public NzlCVHousehold read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return NzlCVHousehold.fromValue(String.valueOf(value));
        }
    }
}
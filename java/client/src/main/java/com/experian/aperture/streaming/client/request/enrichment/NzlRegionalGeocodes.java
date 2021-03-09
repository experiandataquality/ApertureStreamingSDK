package com.experian.aperture.streaming.client.request.enrichment;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named NZL Regional Geocodes Data and its associated attributes.
 */
@JsonAdapter(NzlRegionalGeocodes.Adapter.class)
public enum  NzlRegionalGeocodes {
    FRONT_OF_PROPERTY_NZTM_X_COORDINATE("front_of_property_nztm_x_coordinate"),

    FRONT_OF_PROPERTY_NZTM_Y_COORDINATE("front_of_property_nztm_y_coordinate"),

    CENTROID_OF_PROPERTY_NZTM_X_COORDINATE("centroid_of_property_nztm_x_coordinate"),

    CENTROID_OF_PROPERTY_NZTM_Y_COORDINATE("centroid_of_property_nztm_y_coordinate"),

    LINZ_PARCEL_ID("linz_parcel_id"),

    PROPERTY_PURPOSE_TYPE("property_purpose_type"),

    ADDRESSABLE("addressable"),

    MESH_BLOCK_CODE("mesh_block_code"),

    TERRITORIAL_AUTHORITY_CODE("territorial_authority_code"),

    TERRITORIAL_AUTHORITY_NAME("territorial_authority_name"),

    REGIONAL_COUNCIL_CODE("regional_council_code"),

    REGIONAL_COUNCIL_NAME("regional_council_name"),

    GENERAL_ELECTORATE_CODE("general_electorate_code"),

    GENERAL_ELECTORATE_NAME("general_electorate_name"),

    MAORI_ELECTORATE_CODE("maori_electorate_code"),

    MAORI_ELECTORATE_NAME("maori_electorate_name"),

    FRONT_OF_PROPERTY_LATITUDE("front_of_property_latitude"),

    FRONT_OF_PROPERTY_LONGITUDE("front_of_property_longitude"),

    CENTROID_OF_PROPERTY_LATITUDE("centroid_of_property_latitude"),

    CENTROID_OF_PROPERTY_LONGITUDE("centroid_of_property_longitude"),

    MATCH_LEVEL("match_level");

    private String value;

    NzlRegionalGeocodes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return  value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static NzlRegionalGeocodes fromValue(final String text) {
        for (NzlRegionalGeocodes b : NzlRegionalGeocodes.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<NzlRegionalGeocodes> {
        @Override
        public void write(final JsonWriter jsonWriter, final NzlRegionalGeocodes enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public NzlRegionalGeocodes read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return NzlRegionalGeocodes.fromValue(String.valueOf(value));
        }
    }
}
package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Enrichment attributes that can be returned, based on the Australian ConsumerView Household Data dataset.
 */
@JsonAdapter(AusCVHousehold.Adapter.class)
public enum AusCVHousehold {
    HIN("hin"),

    ADDRESS("address"),

    SUBURB("suburb"),

    POSTCODE("postcode"),

    STATE("state"),

    RESIDENTIAL_FLAG("residential_flag"),

    GNAF_PID("gnaf_pid"),

    GNAF_LATITUDE("gnaf_latitude"),

    GNAF_LONGITUDE("gnaf_longitude"),

    MESHBLOCK("meshblock"),

    SA1("sa1"),

    LOCAL_GOVERNMENT_AREA_CODE("local_government_area_code"),

    LOCAL_GOVERNMENT_AREA_NAME("local_government_area_name"),

    MOSAIC_GROUP_2018("mosaic_group_2018"),

    MOSAIC_TYPE_2018("mosaic_type_2018"),

    MOSAIC_SEGMENT_2018("mosaic_segment_2018"),

    AFFLUENCE_CODE("affluence_code"),

    AFFLUENCE_DESCRIPTION("affluence_description"),

    ADULTS_AT_ADDRESS_CODE("adults_at_address_code"),

    ADULTS_AT_ADDRESS_DESCRIPTION("adults_at_address_description"),

    CHILDREN_AT_ADDRESS_CODE_0_10_YEARS("children_at_address_code_0_10_years"),

    CHILDREN_AT_ADDRESS_DESCRIPTION_0_10_YEARS("children_at_address_description_0_10_years"),

    CHILDREN_AT_ADDRESS_CODE_11_18_YEARS("children_at_address_code_11_18_years"),

    CHILDREN_AT_ADDRESS_DESCRIPTION_11_18_YEARS("children_at_address_description_11_18_years"),

    CREDIT_DEMAND_CODE("credit_demand_code"),

    CREDIT_DEMAND_DESCRIPTION("credit_demand_description"),

    HOUSEHOLD_INCOME_CODE("household_income_code"),

    HOUSEHOLD_INCOME_DESCRIPTION("household_income_description"),

    HOUSEHOLD_COMPOSITION_CODE("household_composition_code"),

    HOUSEHOLD_COMPOSITION_DESCRIPTION("household_composition_description"),

    HEAD_OF_HOUSEHOLD_AGE_CODE("head_of_household_age_code"),

    HEAD_OF_HOUSEHOLD_AGE_DESCRIPTION("head_of_household_age_description"),

    LIFESTAGE_CODE("lifestage_code"),

    LIFESTAGE_DESCRIPTION("lifestage_description"),

    LENGTH_OF_RESIDENCE_CODE("length_of_residence_code"),

    LENGTH_OF_RESIDENCE_DESCRIPTION("length_of_residence_description"),

    MOSAIC_FACTOR1_SCORE_2018("mosaic_factor1_score_2018"),

    MOSAIC_FACTOR2_SCORE_2018("mosaic_factor2_score_2018"),

    MOSAIC_FACTOR3_SCORE_2018("mosaic_factor3_score_2018"),

    MOSAIC_FACTOR4_SCORE_2018("mosaic_factor4_score_2018"),

    MOSAIC_FACTOR5_SCORE_2018("mosaic_factor5_score_2018"),

    MOSAIC_FACTOR1_PERCENTILE_2018("mosaic_factor1_percentile_2018"),

    MOSAIC_FACTOR2_PERCENTILE_2018("mosaic_factor2_percentile_2018"),

    MOSAIC_FACTOR3_PERCENTILE_2018("mosaic_factor3_percentile_2018"),

    MOSAIC_FACTOR4_PERCENTILE_2018("mosaic_factor4_percentile_2018"),

    MOSAIC_FACTOR5_PERCENTILE_2018("mosaic_factor5_percentile_2018"),

    RISK_INSIGHT_CODE("risk_insight_code"),

    RISK_INSIGHT_DESCRIPTION("risk_insight_description"),

    CHANNEL_PREFERENCE("channel_preference"),

    CHANNEL_PREFERENCE_DESCRIPTION("channel_preference_description"),

    MOSAIC_GROUP("mosaic_group"),

    MOSAIC_TYPE("mosaic_type"),

    MOSAIC_SEGMENT("mosaic_segment"),

    MOSAIC_GROUP_2015("mosaic_group_2015"),

    MOSAIC_TYPE_2015("mosaic_type_2015"),

    MOSAIC_SEGMENT_2015("mosaic_segment_2015");

    private String value;

    AusCVHousehold(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static AusCVHousehold fromValue(final String text) {
        for (AusCVHousehold b : AusCVHousehold.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<AusCVHousehold> {
        @Override
        public void write(final JsonWriter jsonWriter, final AusCVHousehold enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AusCVHousehold read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return AusCVHousehold.fromValue(String.valueOf(value));
        }
    }
}

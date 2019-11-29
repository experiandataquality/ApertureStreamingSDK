package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The dataset named Australia ConsumerView Postcode Data and its associated attributes.
 */
@JsonAdapter(AusCVPostcode.Adapter.class)
public enum AusCVPostcode {
    POSTCODE("postcode"),

    ADULTS_AT_ADDRESS_CODE("adults_at_address_code"),

    ADULTS_AT_ADDRESS_DESCRIPTION("adults_at_address_description"),

    AFFLUENCE_CODE("affluence_code"),

    AFFLUENCE_CODE_DESCRIPTION("affluence_code_description"),

    CHILDREN_AT_ADDRESS_CODE_0_10_YEARS("children_at_address_code_0_10_years"),

    CHILDREN_AT_ADDRESS_DESCRIPTION_0_10_YEARS("children_at_address_description_0_10_years"),

    CHILDREN_AT_ADDRESS_CODE_11_18_YEARS("children_at_address_code_11_18_years"),

    CHILDREN_AT_ADDRESS_DESCRIPTION_11_18_YEARS("children_at_address_description_11_18_years"),

    CREDIT_DEMAND_CODE("credit_demand_code"),

    CREDIT_DEMAND_DESCRIPTION("credit_demand_description"),

    HEAD_OF_HOUSEHOLD_AGE_CODE("head_of_household_age_code"),

    HEAD_OF_HOUSEHOLD_AGE_DESCRIPTION("head_of_household_age_description"),

    HOUSEHOLD_INCOME_CODE("household_income_code"),

    HOUSEHOLD_INCOME_DESCRIPTION("household_income_description"),

    LENGTH_OF_RESIDENCE_CODE("length_of_residence_code"),

    LENGTH_OF_RESIDENCE_DESCRIPTION("length_of_residence_description"),

    LIFESTAGE_CODE("lifestage_code"),

    LIFESTAGE_CODE_DESCRIPTION("lifestage_code_description"),

    MOSAIC_GROUP_2018("mosaic_group_2018"),

    MOSAIC_TYPE_2018("mosaic_type_2018"),

    HOUSEHOLD_COMPOSITION_CODE("household_composition_code"),

    HOUSEHOLD_COMPOSITION_DESCRIPTION("household_composition_description"),

    RISK_INSIGHT_CODE("risk_insight_code"),

    RISK_INSIGHT_DESCRIPTION("risk_insight_description"),

    MOSAIC_GROUP("mosaic_group"),

    MOSAIC_TYPE("mosaic_type"),

    MOSAIC_GROUP_2015("mosaic_group_2015"),

    MOSAIC_TYPE_2015("mosaic_type_2015");

    private String value;

    AusCVPostcode(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private static AusCVPostcode fromValue(final String text) {
        for (AusCVPostcode b : AusCVPostcode.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Adapter to convert json string to enum and vice versa.
     */
    public static class Adapter extends TypeAdapter<AusCVPostcode> {
        @Override
        public void write(final JsonWriter jsonWriter, final AusCVPostcode enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AusCVPostcode read(final JsonReader jsonReader) throws IOException {
            final String value = jsonReader.nextString();
            return AusCVPostcode.fromValue(String.valueOf(value));
        }
    }
}
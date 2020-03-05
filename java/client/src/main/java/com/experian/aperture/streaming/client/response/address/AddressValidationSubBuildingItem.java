package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * An item of sub-building information, such as a floor or entrance number or name.
 */
public class AddressValidationSubBuildingItem {
    /**
     * The full name of this subcomponent.
     **/
    @SerializedName("full_name")
    private String fullName;

    /**
     * The type of this subcomponent.
     **/
    @SerializedName("type")
    private String type;

    /**
     * The value of this subcomponent.
     **/
    @SerializedName("value")
    private String value;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

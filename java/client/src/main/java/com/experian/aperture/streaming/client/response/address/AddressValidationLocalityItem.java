package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * A single place name, code and a description of its type.
 */
public final class AddressValidationLocalityItem {
    /**
     * The name for this subcomponent.
     **/
    @SerializedName("name")
    private String name;

    /**
     * The code of this subcomponent.
     **/
    @SerializedName("code")
    private String code;

    /**
     * The description of this subcomponent.
     **/
    @SerializedName("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}

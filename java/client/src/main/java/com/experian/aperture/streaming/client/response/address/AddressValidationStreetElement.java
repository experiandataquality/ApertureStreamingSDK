package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The street component.
 */
public final class AddressValidationStreetElement {
    /**
     * The combination of the other populated secondary street components: prefix, name, type, suffix.
     **/
    @SerializedName("full_name")
    private String fullName;

    /**
     * The secondary street prefix only.
     **/
    @SerializedName("prefix")
    private String prefix;

    /**
     * The secondary street name only.
     **/
    @SerializedName("name")
    private String name;

    /**
     * The secondary street type only.
     **/
    @SerializedName("type")
    private String type;

    /**
     * The secondary street suffix only.
     **/
    @SerializedName("suffix")
    private String suffix;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

}

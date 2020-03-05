package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The building component.
 */
public final class AddressValidationBuildingElement {
    /**
     * The building name.
     **/
    @SerializedName("building_name")
    private String buildingName;

    /**
     * The building number.
     **/
    @SerializedName("building_number")
    private String buildingNumber;

    /**
     * The secondary name of the building (if available).
     **/
    @SerializedName("secondary_number")
    private String secondaryNumber;

    /**
     * The allotment name where a person or property resides.
     **/
    @SerializedName("allotment_number")
    private String allotmentNumber;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(final String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(final String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setSecondaryNumber(final String secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    public String getAllotmentNumber() {
        return allotmentNumber;
    }

    public void setAllotmentNumber(final String allotmentNumber) {
        this.allotmentNumber = allotmentNumber;
    }

}

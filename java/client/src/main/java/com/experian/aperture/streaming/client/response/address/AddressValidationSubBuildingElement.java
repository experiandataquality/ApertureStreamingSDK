package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The sub building component.
 */
public final class AddressValidationSubBuildingElement {
    /**
     * The name of a building or property.
     **/
    @SerializedName("name")
    private String name;

    /**
     * The full name of a building or property entrance.
     **/
    @SerializedName("entrance")
    private AddressValidationSubBuildingItem entrance;

    /**
     * The floor of sub building.
     **/
    @SerializedName("floor")
    private AddressValidationSubBuildingItem floor;

    /**
     * The door of sub building.
     **/
    @SerializedName("door")
    private AddressValidationSubBuildingItem door;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public AddressValidationSubBuildingItem getEntrance() {
        return entrance;
    }

    public void setEntrance(final AddressValidationSubBuildingItem entrance) {
        this.entrance = entrance;
    }

    public AddressValidationSubBuildingItem getFloor() {
        return floor;
    }

    public void setFloor(final AddressValidationSubBuildingItem floor) {
        this.floor = floor;
    }

    public AddressValidationSubBuildingItem getDoor() {
        return door;
    }

    public void setDoor(final AddressValidationSubBuildingItem door) {
        this.door = door;
    }

}

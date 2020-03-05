package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The locality component.
 */
public final class AddressValidationLocalityElement {
    /**
     * The name of the city, state code or province.
     **/
    @SerializedName("region")
    private AddressValidationLocalityItem region;

    /**
     * The sub region name.
     **/
    @SerializedName("sub_region")
    private AddressValidationLocalityItem subRegion;

    /**
     * The name of the town, locality or suburb within the region.
     **/
    @SerializedName("town")
    private AddressValidationLocalityItem town;

    /**
     * The name of the district or settlement of the town.
     **/
    @SerializedName("district")
    private AddressValidationLocalityItem district;

    /**
     * The sub district name.
     **/
    @SerializedName("sub_district")
    private AddressValidationLocalityItem subDistrict;

    public AddressValidationLocalityItem getRegion() {
        return region;
    }

    public void setRegion(final AddressValidationLocalityItem region) {
        this.region = region;
    }

    public AddressValidationLocalityItem getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(final AddressValidationLocalityItem subRegion) {
        this.subRegion = subRegion;
    }

    public AddressValidationLocalityItem getTown() {
        return town;
    }

    public void setTown(final AddressValidationLocalityItem town) {
        this.town = town;
    }

    public AddressValidationLocalityItem getDistrict() {
        return district;
    }

    public void setDistrict(final AddressValidationLocalityItem district) {
        this.district = district;
    }

    public AddressValidationLocalityItem getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(final AddressValidationLocalityItem subDistrict) {
        this.subDistrict = subDistrict;
    }

}

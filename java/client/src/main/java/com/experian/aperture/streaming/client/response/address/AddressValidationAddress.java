package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * Seven address lines representing a formatted address for the chosen country.
 */
public final class AddressValidationAddress {
    /**
     * The first line of address containing a number of specific components relating to the premises and street.
     **/
    @SerializedName("address_line_1")
    private String addressLine1;

    /**
     * The second line of address containing a number of specific components relating to the premises and street.
     **/
    @SerializedName("address_line_2")
    private String addressLine2;

    /**
     * The third line of address containing a number of specific components relating to the premises and street.
     **/
    @SerializedName("address_line_3")
    private String addressLine3;

    /**
     * The town, locality or suburb.
     **/
    @SerializedName("locality")
    private String locality;

    /**
     * The city, state code or province.
     **/
    @SerializedName("region")
    private String region;

    /**
     * The post/zip code.
     **/
    @SerializedName("postal_code")
    private String postalCode;

    /**
     * The localised country name.
     **/
    @SerializedName("country")
    private String country;

    /**
     * Gets the addressLine1.
     * @return The addressLine1.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the addressLine1.
     * @param addressLine1 The addressLine1.
     */
    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the addressLine2.
     * @return The addressLine2.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the addressLine2.
     * @param addressLine2 The addressLine2.
     */
    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Gets the addressLine3.
     * @return The addressLine3.
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the addressLine3.
     * @param addressLine3 The addressLine3.
     */
    public void setAddressLine3(final String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     * Gets the locality.
     * @return The locality.
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Sets the locality.
     * @param locality The locality.
     */
    public void setLocality(final String locality) {
        this.locality = locality;
    }

    /**
     * Gets the region.
     * @return The region.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region.
     * @param region The region.
     */
    public void setRegion(final String region) {
        this.region = region;
    }

    /**
     * Gets the postalCode.
     * @return The postalCode.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postalCode.
     * @param postalCode The postalCode.
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the country.
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     * @param country The country.
     */
    public void setCountry(final String country) {
        this.country = country;
    }

}

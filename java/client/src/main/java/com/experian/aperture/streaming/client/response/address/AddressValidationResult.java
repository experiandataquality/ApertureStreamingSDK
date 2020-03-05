package com.experian.aperture.streaming.client.response.address;

import com.experian.aperture.streaming.client.response.Result;
import com.google.gson.annotations.SerializedName;

/**
 * Details about the result. Includes the validated address and its confidence level.
 */
public final class AddressValidationResult implements Result {
    /**
     * The ID of the address recieved as part of a validation.
     **/
    @SerializedName("address_id")
    private String addressId;

    /**
     * The confidence of address validation result.
     **/
    @SerializedName("confidence")
    private String confidence;

    /**
     * The address of validation result.
     **/
    @SerializedName("address")
    private AddressValidationAddress address;

    /**
     * The ID of the address recieved as part of a validation.
     **/
    @SerializedName("components")
    private AddressValidationComponent components;

    /**
     * Gets the addressId.
     * @return The addressId.
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * Sets the addressId.
     * @param addressId The addressId.
     */
    public void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the confidence.
     * @return The confidence.
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * Sets the confidence.
     * @param confidence The confidence.
     */
    public void setConfidence(final String confidence) {
        this.confidence = confidence;
    }

    /**
     * Gets the address.
     * @return The address.
     */
    public AddressValidationAddress getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * @param address The address.
     */
    public void setAddress(final AddressValidationAddress address) {
        this.address = address;
    }

    /**
     * Gets the components.
     * @return The components.
     */
    public AddressValidationComponent getComponents() {
        return components;
    }

    /**
     * Sets the components.
     * @param components The components.
     */
    public void setComponents(final AddressValidationComponent components) {
        this.components = components;
    }
}

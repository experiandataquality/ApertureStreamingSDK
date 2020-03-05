package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The delivery service component.
 */
public class AddressValidationDeliveryServiceElement {
    /**
     * The secondary delivery service full name.
     **/
    @SerializedName("full_name")
    private String fullName;

    /**
     * The secondary delivery service type.
     **/
    @SerializedName("service_type")
    private String serviceType;

    /**
     * The secondary delivery service number.
     **/
    @SerializedName("service_number")
    private String serviceNumber;

    /**
     * The secondary delivery service post center name.
     **/
    @SerializedName("post_centre_name")
    private String postCentreName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(final String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(final String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getPostCentreName() {
        return postCentreName;
    }

    public void setPostCentreName(final String postCentreName) {
        this.postCentreName = postCentreName;
    }
}

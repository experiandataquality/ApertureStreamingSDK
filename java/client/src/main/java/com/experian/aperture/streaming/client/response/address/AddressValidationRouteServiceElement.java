package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The route service.
 */
public final class AddressValidationRouteServiceElement {
    /**
     * The full name of the route service.
     **/
    @SerializedName("full_name")
    private String fullName;

    /**
     * The route service type.
     **/
    @SerializedName("service_type")
    private String serviceType;

    /**
     * The route service number.
     **/
    @SerializedName("service_number")
    private String serviceNumber;

    /**
     * The route service delivery name.
     **/
    @SerializedName("delivery_name")
    private String deliveryName;

    /**
     * The route service qualifier.
     **/
    @SerializedName("qualifier")
    private String qualifier;

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

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(final String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(final String qualifier) {
        this.qualifier = qualifier;
    }
}

package com.experian.aperture.streaming.client.proxy;

import com.experian.aperture.streaming.client.Versions;
import com.experian.aperture.streaming.client.options.address.AddressValidationOptions;
import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Proxy class for address validation request.
 */
public final class AddressValidationRequestProxy extends RequestProxyBase {

    @SerializedName("country_iso")
    private final String countryIso;

    @SerializedName("dataset")
    private final String dataset;

    @SerializedName("delivery_service")
    private final List<String> deliveryService;

    @SerializedName("organization")
    private final List<String> organization;

    @SerializedName("sub_building")
    private final List<String> subBuilding;

    @SerializedName("building")
    private final List<String> building;

    @SerializedName("street")
    private final List<String> street;

    @SerializedName("locality")
    private final List<String> locality;

    @SerializedName("postalCode")
    private final String postalCode;

    @SerializedName("include_components")
    private final Boolean includeComponents;

    @SerializedName("timeout")
    private long timeout;

    public AddressValidationRequestProxy(final AddressValidationRequest request, final AddressValidationOptions options) {
        super(Versions.ADDRESS_VALIDATION_REQUEST, request.getReferenceId(), options.getAddMetadata());
        this.countryIso = request.getCountryIso();
        this.dataset = request.getDataset();
        this.deliveryService = request.getDeliveryService();
        this.organization = request.getOrganization();
        this.subBuilding = request.getSubBuilding();
        this.building = request.getBuilding();
        this.street = request.getStreet();
        this.locality = request.getLocality();
        this.postalCode = request.getPostalCode();
        this.includeComponents = options.getIncludeComponents();
        this.timeout = options.getTimeout().getSeconds();
    }

    public String getCountryIso() {
        return this.countryIso;
    }

    public String getDataset() {
        return this.dataset;
    }

    public List<String> getDeliveryService() {
        return this.deliveryService;
    }

    public List<String> getOrganization() {
        return this.organization;
    }

    public List<String> getSubBuilding() {
        return this.subBuilding;
    }

    public List<String> getBuilding() {
        return this.building;
    }

    public List<String> getStreet() {
        return this.street;
    }

    public List<String> getLocality() {
        return this.locality;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public Boolean getIncludeComponents() {
        return this.includeComponents;
    }

    public long getTimeout() {
        return this.timeout;
    }
}
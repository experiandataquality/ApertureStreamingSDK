package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

/**
 * The components that differ by country and address type. Note that parameters with blank values will not be returned.
 */
public final class AddressValidationComponent {
    /**
     * The post/zip code.
     **/
    @SerializedName("postal_code")
    private String postalCode;

    /**
     * The secondary postal code (if available).
     **/
    @SerializedName("secondary_postal_code")
    private String secondaryPostalCode;

    /**
     * Address language.
     **/
    @SerializedName("language")
    private String language;

    /**
     * The residence or organization.
     **/
    @SerializedName("address_type")
    private String addressType;

    /**
     * The name of the country where the address is located.
     **/
    @SerializedName("country_name")
    private String countryName;

    /**
     * The 3-letter ISO country code.
     **/
    @SerializedName("country_iso_3")
    private String countryISO3;

    /**
     * The delivery service component.
     **/
    @SerializedName("delivery_service")
    private AddressValidationDeliveryServiceElement deliveryService;

    /**
     * The secondary delivery service component.
     **/
    @SerializedName("secondary_delivery_service")
    private AddressValidationDeliveryServiceElement secondaryDeliveryService;

    /**
     * The sub building component.
     **/
    @SerializedName("sub_building")
    private AddressValidationSubBuildingElement subBuilding;

    /**
     * The building component.
     **/
    @SerializedName("building")
    private AddressValidationBuildingElement building;

    /**
     * The organization component.
     **/
    @SerializedName("organization")
    private AddressValidationOrganisationElement organization;

    /**
     * The street component.
     **/
    @SerializedName("street")
    private AddressValidationStreetElement street;

    /**
     * The secondary street component.
     **/
    @SerializedName("secondary_street")
    private AddressValidationStreetElement secondaryStreet;

    /**
     * The route service.
     **/
    @SerializedName("route_service")
    private AddressValidationRouteServiceElement routeService;

    /**
     * The locality component.
     **/
    @SerializedName("locality")
    private AddressValidationLocalityElement locality;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSecondaryPostalCode() {
        return secondaryPostalCode;
    }

    public void setSecondaryPostalCode(final String secondaryPostalCode) {
        this.secondaryPostalCode = secondaryPostalCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISO3() {
        return countryISO3;
    }

    public void setCountryISO3(final String countryISO3) {
        this.countryISO3 = countryISO3;
    }

    public AddressValidationDeliveryServiceElement getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(final AddressValidationDeliveryServiceElement deliveryService) {
        this.deliveryService = deliveryService;
    }

    public AddressValidationDeliveryServiceElement getSecondaryDeliveryService() {
        return secondaryDeliveryService;
    }

    public void setSecondaryDeliveryService(final AddressValidationDeliveryServiceElement secondaryDeliveryService) {
        this.secondaryDeliveryService = secondaryDeliveryService;
    }

    public AddressValidationSubBuildingElement getSubBuilding() {
        return subBuilding;
    }

    public void setSubBuilding(final AddressValidationSubBuildingElement subBuilding) {
        this.subBuilding = subBuilding;
    }

    public AddressValidationBuildingElement getBuilding() {
        return building;
    }

    public void setBuilding(final AddressValidationBuildingElement building) {
        this.building = building;
    }

    public AddressValidationOrganisationElement getOrganization() {
        return organization;
    }

    public void setOrganization(final AddressValidationOrganisationElement organization) {
        this.organization = organization;
    }

    public AddressValidationStreetElement getStreet() {
        return street;
    }

    public void setStreet(final AddressValidationStreetElement street) {
        this.street = street;
    }

    public AddressValidationStreetElement getSecondaryStreet() {
        return secondaryStreet;
    }

    public void setSecondaryStreet(final AddressValidationStreetElement secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public AddressValidationRouteServiceElement getRouteService() {
        return routeService;
    }

    public void setRouteService(final AddressValidationRouteServiceElement routeService) {
        this.routeService = routeService;
    }

    public AddressValidationLocalityElement getLocality() {
        return locality;
    }

    public void setLocality(final AddressValidationLocalityElement locality) {
        this.locality = locality;
    }


}

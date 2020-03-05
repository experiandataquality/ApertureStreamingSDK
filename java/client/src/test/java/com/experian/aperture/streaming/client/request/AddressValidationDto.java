package com.experian.aperture.streaming.client.request;

import java.util.List;

final class AddressValidationDto {
    private String referenceId;
    private String countryIso;
    private String dataset;
    private List<String> organizations;
    private List<String> deliveryServices;
    private List<String> subBuildings;
    private List<String> buildings;
    private List<String> streets;
    private List<String> localities;
    private String postalCode;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(final String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(final String countryIso) {
        this.countryIso = countryIso;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(final String dataset) {
        this.dataset = dataset;
    }

    public List<String> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(final List<String> organizations) {
        this.organizations = organizations;
    }

    public List<String> getDeliveryServices() {
        return deliveryServices;
    }

    public void setDeliveryServices(final List<String> deliveryServices) {
        this.deliveryServices = deliveryServices;
    }

    public List<String> getSubBuildings() {
        return subBuildings;
    }

    public void setSubBuildings(final List<String> subBuildings) {
        this.subBuildings = subBuildings;
    }

    public List<String> getBuildings() {
        return buildings;
    }

    public void setBuildings(final List<String> buildings) {
        this.buildings = buildings;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(final List<String> streets) {
        this.streets = streets;
    }

    public List<String> getLocalities() {
        return localities;
    }

    public void setLocalities(final List<String> localities) {
        this.localities = localities;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
}

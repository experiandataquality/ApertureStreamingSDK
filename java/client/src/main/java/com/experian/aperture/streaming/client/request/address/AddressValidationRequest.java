package com.experian.aperture.streaming.client.request.address;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBase;

import java.util.List;

/**
 * The address validation request model.
 */
public final class AddressValidationRequest  extends RequestBase {
    /**
     * The 3-letter ISO country code.
     */
    private String countryIso;
    /**
     * The name of the dataset for the country that the address is in. If undefined, the default dataset for the specified country will be used. Check documentation for the default source for each country.
     */
    private String dataset;
    /**
     * The P. O. Box or Box number.
     */
    private List<String> deliveryService;
    /**
     * The organization, company or department name for any commercial or governmental address.
     */
    private List<String> organization;
    /**
     * The floor number, building level or suite name.
     */
    private List<String> subBuilding;
    /**
     * The building name.
     */
    private List<String> building;
    /**
     * The name of the street. This parameter is optional but a street number is required to match to a residential address.
     */
    private List<String> street;
    /**
     * The locality.
     */
    private List<String> locality;
    /**
     * The country postal code.
     */
    private String postalCode;

    AddressValidationRequest(final String referenceId, final String countryIso) throws  IllegalArgumentException {
        super(referenceId);
        Contract.requiresNotEmpty(countryIso, ResourceReader.getErrorMessageWithKey("CountryIsoRequired"));
        this.countryIso = countryIso;
    }
    /**
     * Gets the country iso.
     * @return The country iso.
     */
    public String getCountryIso() {
        return this.countryIso;
    }
    /**
     * Gets the dataset.
     * @return The dataset.
     */
    public String getDataset() {
        return this.dataset;
    }
    /**
     * Gets the delivery service.
     * @return The delivery service.
     */
    public List<String> getDeliveryService() {
        return this.deliveryService;
    }
    /**
     * Gets the organization.
     * @return The organization.
     */
    public List<String> getOrganization() {
        return this.organization;
    }
    /**
     * Gets the sub building.
     * @return The sub building.
     */
    public List<String> getSubBuilding() {
        return this.subBuilding;
    }
    /**
     * Gets the building.
     * @return The building.
     */
    public List<String> getBuilding() {
        return this.building;
    }
    /**
     * Gets the street.
     * @return The street.
     */
    public List<String> getStreet() {
        return this.street;
    }
    /**
     * Gets the locality.
     * @return The locality.
     */
    public List<String> getLocality() {
        return this.locality;
    }
    /**
     * Gets the postalCode.
     * @return The postalCode.
     */
    public String getPostalCode() {
        return this.postalCode;
    }
    /**
     * Sets the dataset.
     * @param dataset The dataset.
     */
    public void setDataset(final String dataset) {
        this.dataset = dataset;
    }
    /**
     * Sets the delivery service.
     * @param deliveryService The delivery service.
     */
    public void setDeliveryService(final List<String>  deliveryService) {
        this.deliveryService = deliveryService;
    }
    /**
     * Sets the organization.
     * @param organization The organization.
     */
    public void setOrganization(final List<String> organization) {
        this.organization = organization;
    }
    /**
     * Sets the sub building.
     * @param subBuilding The sub building.
     */
    public void setSubBuilding(final List<String> subBuilding) {
        this.subBuilding = subBuilding;
    }
    /**
     * Sets the building.
     * @param building The building.
     */
    public void setBuilding(final List<String> building) {
        this.building = building;
    }
    /**
     * Sets the street.
     * @param street The street.
     */
    public void setStreet(final List<String> street) {
        this.street = street;
    }
    /**
     * Sets the locality.
     * @param locality The locality.
     */
    public void setLocality(final List<String> locality) {
        this.locality = locality;
    }
    /**
     * Sets the postalCode.
     * @param postalCode The postalCode.
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
}

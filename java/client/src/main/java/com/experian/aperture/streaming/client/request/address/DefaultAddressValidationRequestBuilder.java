package com.experian.aperture.streaming.client.request.address;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Deines the default AddressValidation request builder.
 */
public final class DefaultAddressValidationRequestBuilder implements RequestBuilder.AddressValidationRequestBuilder {
    private final String referenceIdAlphanumericError = ResourceReader.getErrorMessageWithKey("ReferenceIdAlphanumericError");
    private final String referenceIdLengthError = ResourceReader.getErrorMessageWithKey("ReferenceIdLengthError");
    private final String referenceIdRequiredEmptySpaceError = ResourceReader.getErrorMessageWithKey("ReferenceIdRequiredEmptySpaceError");
    private final String countryIsoRequiredError = ResourceReader.getErrorMessageWithKey("CountryIsoRequired");
    private final String referenceId;
    private String countryIso;
    private String dataset;
    private List<String> organizations = new ArrayList<>();
    private List<String> deliveryServices = new ArrayList<>();
    private List<String> subBuildings = new ArrayList<>();
    private List<String> buildings = new ArrayList<>();
    private List<String> streets = new ArrayList<>();
    private List<String> localities = new ArrayList<>();
    private String postalCode;

    public DefaultAddressValidationRequestBuilder(final String referenceId) {
        Contract.requiresNotWhiteSpaces(referenceId, referenceIdRequiredEmptySpaceError);
        Contract.requiresReferenceIdWithinRange(referenceId, referenceIdLengthError);
        Contract.requiresReferenceIdAlphanumeric(referenceId, referenceIdAlphanumericError);
        this.referenceId = referenceId;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withCountryIso(final String countryIso) {
        Contract.requiresNotEmpty(countryIso, countryIsoRequiredError);
        this.countryIso = countryIso;
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withDataset(final String dataset) {
        this.dataset = dataset;
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withDeliveryService(final String... deliveryServices) {
        for (String deliveryService : deliveryServices) {
            this.deliveryServices.add(deliveryService);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withOrganization(final String... organizations) {
        for (String organization : organizations) {
            this.organizations.add(organization);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withSubBuilding(final String... subBuildings) {
        for (String subBuilding : subBuildings) {
            this.subBuildings.add(subBuilding);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withBuilding(final String... buildings) {
        for (String building : buildings) {
            this.buildings.add(building);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withStreet(final String... streets) {
        for (String street : streets) {
            this.streets.add(street);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withLocality(final String... localities) {
        for (String locality : localities) {
            this.localities.add(locality);
        }
        return this;
    }

    @Override
    public RequestBuilder.AddressValidationRequestBuilder withPostalCode(final String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public AddressValidationRequest build() {
        AddressValidationRequest request = new AddressValidationRequest(this.referenceId, this.countryIso);
        request.setDataset(this.dataset);
        request.setDeliveryService(this.deliveryServices);
        request.setOrganization(this.organizations);
        request.setSubBuilding(this.subBuildings);
        request.setBuilding(this.buildings);
        request.setStreet(this.streets);
        request.setLocality(this.localities);
        request.setPostalCode(this.postalCode);
        return request;
    }
}
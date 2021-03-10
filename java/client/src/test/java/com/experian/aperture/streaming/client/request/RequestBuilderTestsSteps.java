package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.request.address.AddressValidationRequest;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.request.enrichment.*;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * The request builder test steps.
 */
final class RequestBuilderTestsSteps {
    private RequestBuilder requestBuilder;
    private EmailValidationRequest emailValidationRequest;
    private PhoneValidationRequest phoneValidationRequest;
    private EnrichmentRequest enrichmentRequest;
    private AddressValidationRequest addressValidationRequest;
    private EnrichmentDatasetKeys keys;
    private EnrichmentDatasetAttributes attributes;

    /**
     * Sets up a request builder using the default builder.
     * @return The steps.
     */
    RequestBuilderTestsSteps givenISetupRequestBuilder() {
        requestBuilder = RequestBuilder.builder();
        return this;
    }

    /**
     * Builds an email validation request with the specified reference Id and input.
     * @param referenceId The reference Id.
     * @param email The email input.
     * @return The steps.
     */
    RequestBuilderTestsSteps whenIBuildEmailValidationRequest(final String referenceId, final String email) {
        this.emailValidationRequest = requestBuilder
                .withEmailRequest(referenceId)
                .withEmail(email)
                .build();
        return this;
    }

    /**
     * Builds a phone validation request with the specified reference Id and inputs.
     * @param referenceId The reference Id.
     * @param number The number input.
     * @param outputFormat The output format
     * @param cacheValueDays The cache value in days.
     * @return The steps.
     */
    RequestBuilderTestsSteps whenIBuildPhoneValidationRequest(final String referenceId, final String number, final String outputFormat, final int cacheValueDays) {
        this.phoneValidationRequest = requestBuilder
                .withPhoneRequest(referenceId)
                .withNumber(number)
                .withOutputFormat(outputFormat)
                .withCacheValueDays(cacheValueDays)
                .build();
        return this;
    }

    /**
     * Builds an enrichment data set keys with the specified inputs.
     * @param dto The enrichment data set keys DTO.
     * @return The steps.
     */
    RequestBuilderTestsSteps whenIBuildEnrichmentDatasetKeys(final EnrichmentDatasetKeyDto dto) {
        this.keys = EnrichmentDatasetKeysBuilder.builder()
                .withDpid(dto.getDpid())
                .withPostcode(dto.getPostcode())
                .withPin(dto.getPin())
                .withGlobalAddressKey(dto.getGlobalAddressKey())
                .withEmailAddress(dto.getEmailAddress())
                .withMobile(dto.getMobile())
                .withGnafPid(dto.getGnafPid())
                .withHin(dto.getHin())
                .build();
        return this;
    }

    /**
     * Builds an enrichment data set attributes with the specified inputs.
     * @param ausCvHouseholdList The AUS CV household list.
     * @param ausCVPostcodeList The AUS CV postcode list.
     * @param ausCVPersonList The AUS CV people.
     * @param geocodesList The geocodes list.
     * @param usaRegionalGeocodesList The USA regional geocodes list.
     * @param ukLocationEssentialList The UK Location Essential list.
     * @param nzlRegionalGeocodesList The NZL Regional Geocodes list.
     * @param nzlCvHouseholdList The NZL CV household list.
     * @return The steps.
     */
    @SuppressWarnings("checkstyle:parameterNumber")
    RequestBuilderTestsSteps whenIBuildEnrichmentDatasetAttributes(final List<AusCVHousehold> ausCvHouseholdList,
                                                                   final List<AusCVPostcode> ausCVPostcodeList,
                                                                   final List<AusCVPerson> ausCVPersonList,
                                                                   final List<Geocodes> geocodesList,
                                                                   final List<UsaRegionalGeocodes> usaRegionalGeocodesList,
                                                                   final List<UkLocationEssential> ukLocationEssentialList,
                                                                   final List<NzlRegionalGeocodes> nzlRegionalGeocodesList,
                                                                   final List<NzlCVHousehold> nzlCvHouseholdList) {
        this.attributes = EnrichmentDatasetAttributesBuilder.builder()
                .withAusCVHouseholdList(ausCvHouseholdList.toArray(new AusCVHousehold[ausCvHouseholdList.size()]))
                .withAusCVPostcodeList(ausCVPostcodeList.toArray(new AusCVPostcode[ausCVPostcodeList.size()]))
                .withAusCVPersonList(ausCVPersonList.toArray(new AusCVPerson[ausCVPersonList.size()]))
                .withGeocodesList(geocodesList.toArray(new Geocodes[geocodesList.size()]))
                .withUsaRegionalGeocodesList(usaRegionalGeocodesList.toArray(new UsaRegionalGeocodes[usaRegionalGeocodesList.size()]))
                .withUkLocationEssentialList(ukLocationEssentialList.toArray(new UkLocationEssential[ukLocationEssentialList.size()]))
                .withNzlRegionalGeocodesList(nzlRegionalGeocodesList.toArray(new NzlRegionalGeocodes[nzlRegionalGeocodesList.size()]))
                .withNzlCVHouseholdList(nzlCvHouseholdList.toArray(new NzlCVHousehold[nzlCvHouseholdList.size()]))
                .build();
        return this;
    }

    /**
     * Builds a enrichment request with the specified reference Id and inputs.
     * @param referenceId The reference Id.
     * @param country The country
     * @return The steps.
     */
    RequestBuilderTestsSteps whenIBuildEnrichmentRequest(final String referenceId, final String country) {
        this.enrichmentRequest = requestBuilder
                .withEnrichmentRequest(referenceId)
                .withCountry(country)
                .withKeys(this.keys)
                .withAttributes(this.attributes)
                .build();
        return this;
    }

    /**
     * Builds an address validation request with the specified reference Id and input.
     * @param dto The address validation DTO.
     * @return The steps.
     */
    RequestBuilderTestsSteps whenIBuildAddressValidationRequest(final AddressValidationDto dto) {
        this.addressValidationRequest = requestBuilder
                .withAddressValidationRequest(dto.getReferenceId())
                .withCountryIso(dto.getCountryIso())
                .withDataset(dto.getDataset())
                .withDeliveryService(dto.getDeliveryServices().toArray(new String[dto.getDeliveryServices().size()]))
                .withOrganization(dto.getOrganizations().toArray(new String[dto.getOrganizations().size()]))
                .withSubBuilding(dto.getSubBuildings().toArray(new String[dto.getSubBuildings().size()]))
                .withBuilding(dto.getBuildings().toArray(new String[dto.getBuildings().size()]))
                .withStreet(dto.getStreets().toArray(new String[dto.getStreets().size()]))
                .withLocality(dto.getLocalities().toArray(new String[dto.getLocalities().size()]))
                .withPostalCode(dto.getPostalCode())
                .build();
        return this;
    }

    /**
     * Validates the email validation request values.
     * @param expectedEmail The expected email.
     * @param expectedReferenceId The expected reference Id.
     * @return The steps.
     */
    RequestBuilderTestsSteps thenEmailValidationRequestShouldHave(final String expectedEmail, final String expectedReferenceId) {
        assertThat(this.emailValidationRequest.getEmail(), is(expectedEmail));
        assertThat(this.emailValidationRequest.getReferenceId(), is(expectedReferenceId));
        return this;
    }


    /**
     * Validates the phone validation request values.
     * @param expectedNumber The expected number.
     * @param expectedOutputFormat The expected output format.
     * @param expectedCacheValueDays The expected cache value in days.
     * @param expectedReferenceId The expected reference Id.
     * @return The steps.
     */
    RequestBuilderTestsSteps thenPhoneValidationRequestShouldHave(final String expectedNumber, final String expectedOutputFormat, final int expectedCacheValueDays, final String expectedReferenceId) {
        assertThat(this.phoneValidationRequest.getNumber(), is(expectedNumber));
        assertThat(this.phoneValidationRequest.getOutputFormat(), is(expectedOutputFormat));
        assertThat(this.phoneValidationRequest.getCacheValueDays(), is(expectedCacheValueDays));
        assertThat(this.phoneValidationRequest.getReferenceId(), is(expectedReferenceId));
        return this;
    }

    /**
     * Validates the enrichment data set keys values.
     * @param expectedDto The expected enrichment data set keys DTO.
     * @return The steps.
     */
    RequestBuilderTestsSteps thenEnrichmentDatasetKeysShouldHave(final EnrichmentDatasetKeyDto expectedDto) {
        assertNotNull(this.keys);
        assertThat(this.keys.getDpid(), is(expectedDto.getDpid()));
        assertThat(this.keys.getPostcode(), is(expectedDto.getPostcode()));
        assertThat(this.keys.getPin(), is(expectedDto.getPin()));
        assertThat(this.keys.getGlobalAddressKey(), is(expectedDto.getGlobalAddressKey()));
        assertThat(this.keys.getEmailAddress(), is(expectedDto.getEmailAddress()));
        assertThat(this.keys.getMobile(), is(expectedDto.getMobile()));
        assertThat(this.keys.getGnafPid(), is(expectedDto.getGnafPid()));
        assertThat(this.keys.getHin(), is(expectedDto.getHin()));
        return this;
    }

    /**
     * Validates the enrichment data set attributes values.
     * @param ausCvHouseholdList The expected AUS CV household list.
     * @param ausCVPostcodeList The expected AUS CV postcode list.
     * @param ausCVPersonList The expected AUS CV people.
     * @param geocodesList The expected geocodes list.
     * @param usaRegionalGeocodesList The expected USA regional geocodes list.
     * @param ukLocationEssentialList The expected UK Location Essential list.
     * @param nzlRegionalGeocodesList The expected NZL Regional Geocodes list.
     * @param nzlCvHouseholdList The expected NZL CV household list.
     * @return The steps.
     */
    @SuppressWarnings("checkstyle:parameterNumber")
    RequestBuilderTestsSteps thenEnrichmentDatasetAttributesShouldHave(final List<AusCVHousehold> ausCvHouseholdList,
                                                                       final List<AusCVPostcode> ausCVPostcodeList,
                                                                       final List<AusCVPerson> ausCVPersonList,
                                                                       final List<Geocodes> geocodesList,
                                                                       final List<UsaRegionalGeocodes> usaRegionalGeocodesList,
                                                                       final List<UkLocationEssential> ukLocationEssentialList,
                                                                       final List<NzlRegionalGeocodes> nzlRegionalGeocodesList,
                                                                       final List<NzlCVHousehold> nzlCvHouseholdList) {
        assertNotNull(this.attributes);
        assertArrayEquals(this.attributes.getAusCVHousehold().toArray(), ausCvHouseholdList.toArray());
        assertArrayEquals(this.attributes.getAusCVPostcode().toArray(), ausCVPostcodeList.toArray());
        assertArrayEquals(this.attributes.getAusCVPerson().toArray(), ausCVPersonList.toArray());
        assertArrayEquals(this.attributes.getGeocodes().toArray(), geocodesList.toArray());
        assertArrayEquals(this.attributes.getUsaRegionalGeocodes().toArray(), usaRegionalGeocodesList.toArray());
        assertArrayEquals(this.attributes.getUkLocationEssential().toArray(), ukLocationEssentialList.toArray());
        assertArrayEquals(this.attributes.getNzlRegionalGeocodes().toArray(), nzlRegionalGeocodesList.toArray());
        assertArrayEquals(this.attributes.getNzlCVHousehold().toArray(), nzlCvHouseholdList.toArray());
        return this;
    }

    /**
     * Validates the enrichment request values.
     * @param expectedCountry The expected country.
     * @param referenceId The expected reference Id.
     * @return The steps.
     */
    RequestBuilderTestsSteps thenEnrichmentRequestShouldHave(final String expectedCountry, final String referenceId) {
        assertThat(this.enrichmentRequest.getCountryIso(), is(expectedCountry));
        assertThat(this.enrichmentRequest.getReferenceId(), is(referenceId));
        assertNotNull(this.enrichmentRequest.getKeys());
        assertNotNull(this.enrichmentRequest.getAttributes());
        return this;
    }

    /**
     * Validates the address validation request values.
     * @param expectedDto The expected address validation DTO.
     * @return The steps.
     */
    RequestBuilderTestsSteps thenAddressValidationRequestShouldHave(final AddressValidationDto expectedDto) {
        assertThat(this.addressValidationRequest.getReferenceId(), is(expectedDto.getReferenceId()));
        assertThat(this.addressValidationRequest.getCountryIso(), is(expectedDto.getCountryIso()));
        assertThat(this.addressValidationRequest.getDataset(), is(expectedDto.getDataset()));
        assertTrue(this.addressValidationRequest.getDeliveryService().containsAll(expectedDto.getDeliveryServices()));
        assertTrue(this.addressValidationRequest.getOrganization().containsAll(expectedDto.getOrganizations()));
        assertTrue(this.addressValidationRequest.getSubBuilding().containsAll(expectedDto.getSubBuildings()));
        assertTrue(this.addressValidationRequest.getBuilding().containsAll(expectedDto.getBuildings()));
        assertTrue(this.addressValidationRequest.getStreet().containsAll(expectedDto.getStreets()));
        assertTrue(this.addressValidationRequest.getLocality().containsAll(expectedDto.getLocalities()));
        assertThat(this.addressValidationRequest.getPostalCode(), is(expectedDto.getPostalCode()));
        return this;
    }
}
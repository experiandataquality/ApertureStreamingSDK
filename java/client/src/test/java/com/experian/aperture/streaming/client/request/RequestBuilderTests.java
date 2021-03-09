package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.RandomGenerator;
import com.experian.aperture.streaming.client.request.enrichment.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * RequestBuilderTests tests.
 */
public class RequestBuilderTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private RequestBuilderTestsSteps steps;

    private String randomString = RandomGenerator.generateRandomString();
    private String randomNumber = RandomGenerator.generateRandomNumber();

    /**
     * Setup before each test.
     */
    @Before
    public void setUp() {
        this.steps = new RequestBuilderTestsSteps();
    }

    /**
     * Assert that a new email request is created based on the specified values.
     */
    @Test
    public void withEmailRequest_shouldBuildEmailValidationRequestSuccessfully() {
        final String referenceId = "ref-1";
        final String email = "abc@abc.com";
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEmailValidationRequest(referenceId, email)
                .thenEmailValidationRequestShouldHave(email, referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is null.
     */
    @Test
    public void withEmailRequest_shouldThrowErrorWhenReferenceIdIsNull() {
        final String referenceId = null;
        final String email = "abc@abc.com";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEmailValidationRequest(referenceId, email)
                .thenEmailValidationRequestShouldHave(email, referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is empty.
     */
    @Test
    public void withEmailRequest_shouldThrowErrorWhenReferenceIdIsEmpty() {
        final String referenceId = "";
        final String email = "abc@abc.com";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEmailValidationRequest(referenceId, email)
                .thenEmailValidationRequestShouldHave(email, referenceId);
    }

    /**
     * Assert that an exception is thrown when email is null.
     */
    @Test
    public void withEmailRequest_shouldThrowErrorWhenEmailIsNull() {
        final String referenceId = "ref-1";
        final String email = null;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The email field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEmailValidationRequest(referenceId, email)
                .thenEmailValidationRequestShouldHave(email, referenceId);
    }

    /**
     * Assert that an exception is thrown when email is empty.
     */
    @Test
    public void withEmailRequest_shouldThrowErrorWhenEmailIsEmpty() {
        final String referenceId = "ref-1";
        final String email = "";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The email field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEmailValidationRequest(referenceId, email)
                .thenEmailValidationRequestShouldHave(email, referenceId);
    }

    /**
     * Assert that a new phone request is created based on the specified values.
     */
    @Test
    public void withPhoneRequest_shouldBuildPhoneValidationRequestSuccessfully() {
        final String referenceId = "ref-1";
        final String outputFormat = "E164";
        final int cacheValueDays = 5;
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildPhoneValidationRequest(referenceId, randomNumber, outputFormat, cacheValueDays)
                .thenPhoneValidationRequestShouldHave(randomNumber, outputFormat, cacheValueDays, referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is null.
     */
    @Test
    public void withPhoneRequest_shouldThrowErrorWhenReferenceIdIsNull() {
        final String referenceId = null;
        final String outputFormat = "E164";
        final int cacheValueDays = 5;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildPhoneValidationRequest(referenceId, randomNumber, outputFormat, cacheValueDays)
                .thenPhoneValidationRequestShouldHave(randomNumber, outputFormat, cacheValueDays, referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is empty.
     */
    @Test
    public void withPhoneRequest_shouldThrowErrorWhenReferenceIdIsEmpty() {
        final String referenceId = "";
        final String outputFormat = "E164";
        final int cacheValueDays = 5;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildPhoneValidationRequest(referenceId, randomNumber, outputFormat, cacheValueDays)
                .thenPhoneValidationRequestShouldHave(randomNumber, outputFormat, cacheValueDays, referenceId);
    }

    /**
     * Assert that an exception is thrown when number is null.
     */
    @Test
    public void withPhoneRequest_shouldThrowErrorWhenNumberIsNull() {
        final String referenceId = "ref-1";
        final String number = null;
        final String outputFormat = "E164";
        final int cacheValueDays = 5;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The number field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildPhoneValidationRequest(referenceId, number, outputFormat, cacheValueDays)
                .thenPhoneValidationRequestShouldHave(number, outputFormat, cacheValueDays, referenceId);
    }

    /**
     * Assert that an exception is thrown when number is empty.
     */
    @Test
    public void withPhoneRequest_shouldThrowErrorWhenNumberIsEmpty() {
        final String referenceId = "ref-1";
        final String number = "";
        final String outputFormat = "E164";
        final int cacheValueDays = 5;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The number field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildPhoneValidationRequest(referenceId, number, outputFormat, cacheValueDays)
                .thenPhoneValidationRequestShouldHave(number, outputFormat, cacheValueDays, referenceId);
    }

    /**
     * Assert that a new enrichment data set keys is created based on the specified values.
     */
    @Test
    public void buildEnrichmentDatasetKeys_shouldBuildEnrichmentDatasetKeysSuccessfully() {
        final String emailAddress = "abc@abc.com";
        final String gnafPid = "pid";
        final String hin = "hin";
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        dto.setPostcode(randomString);
        dto.setPin(randomString);
        dto.setGlobalAddressKey(randomString);
        dto.setEmailAddress(emailAddress);
        dto.setMobile(randomString);
        dto.setGnafPid(gnafPid);
        dto.setHin(hin);
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .thenEnrichmentDatasetKeysShouldHave(dto);
    }

    /**
     * Assert that a new enrichment data set attributes is created based on the specified values.
     */
    @Test
    public void buildEnrichmentDatasetAttributes_shouldBuildEnrichmentDatasetAttributessSuccessfully() {
        final List<AusCVHousehold> ausCvHouseholdList = Arrays.asList(AusCVHousehold.ADDRESS, AusCVHousehold.ADULTS_AT_ADDRESS_CODE,
                AusCVHousehold.ADULTS_AT_ADDRESS_DESCRIPTION, AusCVHousehold.AFFLUENCE_CODE,
                AusCVHousehold.AFFLUENCE_DESCRIPTION, AusCVHousehold.SA1,
                AusCVHousehold.STATE, AusCVHousehold.SUBURB);
        final List<AusCVPostcode> ausCVPostcodeList = Arrays.asList(AusCVPostcode.ADULTS_AT_ADDRESS_CODE, AusCVPostcode.ADULTS_AT_ADDRESS_DESCRIPTION);
        final List<AusCVPerson> ausCVPersonList = Arrays.asList(AusCVPerson.PIN, AusCVPerson.GENDER, AusCVPerson.HIN, AusCVPerson.LINKAGE_POSTCODE);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        final List<UsaRegionalGeocodes> usaRegionalGeocodesList = Arrays.asList(UsaRegionalGeocodes.LATITUDE, UsaRegionalGeocodes.LONGITUDE);
        final List<UkLocationEssential> ukLocationEssentialList = Arrays.asList(UkLocationEssential.LATITUDE, UkLocationEssential.LONGITUDE, UkLocationEssential.UDPRN);
        final List<NzlRegionalGeocodes> nzlRegionalGeocodes = Arrays.asList(NzlRegionalGeocodes.LINZ_PARCEL_ID, NzlRegionalGeocodes.ADDRESSABLE, NzlRegionalGeocodes.GENERAL_ELECTORATE_CODE);
        final List<NzlCVHousehold> nzlCVHouseholdList = Arrays.asList(NzlCVHousehold.Adults_At_Address, NzlCVHousehold.Children_At_Address);
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetAttributes(ausCvHouseholdList, ausCVPostcodeList, ausCVPersonList, geocodesList, usaRegionalGeocodesList, ukLocationEssentialList, nzlRegionalGeocodes, nzlCVHouseholdList)
                .thenEnrichmentDatasetAttributesShouldHave(ausCvHouseholdList, ausCVPostcodeList, ausCVPersonList, geocodesList, usaRegionalGeocodesList, ukLocationEssentialList, nzlRegionalGeocodes, nzlCVHouseholdList);
    }

    /**
     * Assert that a new enrichment request is created based on the specified values.
     */
    @Test
    public void withEnrichmentRequest_shouldBuildEnrichmentRequestSuccessfully() {
        final String referenceId = "ref-1";
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, "country")
                .thenEnrichmentRequestShouldHave("country", referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is null.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenReferenceIdIsNull() {
        final String referenceId = null;
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, "country")
                .thenEnrichmentRequestShouldHave("country", referenceId);
    }

    /**
     * Assert that an exception is thrown when reference Id is empty.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenReferenceIdIsEmpty() {
        final String referenceId = "";
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The referenceId field must not be empty spaces.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, "country")
                .thenEnrichmentRequestShouldHave("country", referenceId);
    }

    /**
     * Assert that an exception is thrown when country is null.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenCountryIsNull() {
        final String referenceId = "ref-1";
        final String country = null;
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The countryIso field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, country)
                .thenEnrichmentRequestShouldHave(country, referenceId);
    }

    /**
     * Assert that an exception is thrown when country is empty.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenCountryIsEmpty() {
        final String referenceId = "ref-1";
        final String country = "";
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The countryIso field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, country)
                .thenEnrichmentRequestShouldHave(country, referenceId);
    }

    /**
     * Assert that an exception is thrown when attributes are not set.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenAttributesIsNull() {
        final String referenceId = "ref-1";
        final EnrichmentDatasetKeyDto dto = new EnrichmentDatasetKeyDto();
        dto.setDpid(randomString);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The attributes field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetKeys(dto)
                .whenIBuildEnrichmentRequest(referenceId, "country")
                .thenEnrichmentRequestShouldHave("country", referenceId);
    }

    /**
     * Assert that an exception is thrown when keys are not set.
     */
    @Test
    public void withEnrichmentRequest_shouldThrowErrorWhenKeysIsNull() {
        final String referenceId = "ref-1";
        final List<Geocodes> geocodesList = Arrays.asList(Geocodes.LATITUDE, Geocodes.LONGITUDE);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The keys field is required.");
        this.steps
                .givenISetupRequestBuilder()
                .whenIBuildEnrichmentDatasetAttributes(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), geocodesList, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())
                .whenIBuildEnrichmentRequest(referenceId, "country")
                .thenEnrichmentRequestShouldHave("country", referenceId);
    }
}
package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the Australian ConsumerView Household Data dataset.
 */
public final class EnrichmentDatasetAusCVHousehold {
    /**
     * Unique Experian-assigned household identifier.
     * Example: 987654326
     */
    @SerializedName("hin")
    private String hin;

    /**
     * The full address. An additional mail_suppression attribute will be returned if the address
     * is suppressed and should not be contacted.
     * Example: 22 TOURMALINE DR
     */
    @SerializedName("address")
    private String address;

    /**
     * The suburb where the address is located.
     * Example: WEST WODONGA
     */
    @SerializedName("suburb")
    private String suburb;

    /**
     * The postal code or zip code of the address.
     * Example: 7140
     */
    @SerializedName("postcode")
    private String postcode;

    /**
     * The state where the address is located.
     * Example: VIC
     */
    @SerializedName("state")
    private String state;

    /**
     * Indicates whether the address is residential.
     * Example: R
     */
    @SerializedName("residential_flag")
    private String residentialFlag;

    /**
     * Unique 14-character alphanumeric persistent identifier of the address record.
     * An additional "mail_suppresion" attribute will be returned if the address is
     * suppressed and should not be contacted.
     * Example: GAVIC420630433
     */
    @SerializedName("gnaf_pid")
    private String gnafPid;

    /**
     * The latitude of the address.
     * Example: -36.1243447
     */
    @SerializedName("gnaf_latitude")
    private Double gnafLatitude;

    /**
     * The longitude of the address.
     * Example: 146.86340866
     */
    @SerializedName("gnaf_longitude")
    private Double gnafLongitude;

    /**
     * Unique 11-digit identifier allocated to each Mesh Block.
     * Example: 20620060000
     */
    @SerializedName("meshblock")
    private String meshblock;

    /**
     * The 7 digit SA1 code.
     * Example: 2107330
     */
    @SerializedName("sa1")
    private String sa1;

    /**
     * The Local Government Area persistent identifier.
     * Example: 27170
     */
    @SerializedName("local_government_area_code")
    private String localGovernmentAreaCode;

    /**
     * The Local Government Area name.
     * Example: Wodonga (RC)
     */
    @SerializedName("local_government_area_name")
    private String localGovernmentAreaName;

    /**
     * Experian Mosaic group (2018). Alphabetic value.
     * See the ConsumerView Fact Sheet for more details.
     * Example: M
     */
    @SerializedName("mosaic_group_2018")
    private String mosaicGroup2018;

    /**
     * Experian Mosaic type (2018). Alphanumeric value.
     * See the ConsumerView Fact Sheet for more details.
     * Example: M47
     */
    @SerializedName("mosaic_type_2018")
    private String mosaicType2018;

    /**
     * Experian Mosaic segment (2018). May contain letters, numbers and special characters.
     * See the ConsumerView Fact Sheet for more details.
     * Example: M47_3
     */
    @SerializedName("mosaic_segment_2018")
    private String mosaicSegment2018;

    /**
     * A code which indicates the household level of wealth based on household demographics,
     * assets and investments. Number 1-7 or null.
     * See "affluence_description" for more information.
     * Example: 4
     */
    @SerializedName("affluence_code")
    private String affluenceCode;

    /**
     * Describes the household's level of wealth.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Average income Average assets
     */
    @SerializedName("affluence_description")
    private String affluenceDescription;

    /**
     * A code which estimates the number of adults (people aged 18+) living in the household.
     * Number 1-10 or null. See "adults_at_address_description" for more information.
     * Example: 2
     */
    @SerializedName("adults_at_address_code")
    private String adultsAtAddressCode;

    /**
     * Describes the number of adults (people aged 18+) living in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Two adults
     */
    @SerializedName("adults_at_address_description")
    private String adultsAtAddressDescription;

    /**
     * A code which represents the likelihood of the presence of children aged 0-10 in the household.
     * Number 1-10 or null. See "children_at_address_description_0_10_years" for more information.
     * Example: 5
     */
    @SerializedName("children_at_address_code_0_10_years")
    private String childrenAtAddressCode010Years;

    /**
     * Describes the likelihood of the presence of children aged 0-10 in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Average likelihood
     */
    @SerializedName("children_at_address_description_0_10_years")
    private String childrenAtAddressDescription010Years;

    /**
     * A code which represents the likelihood of the presence of children aged 11-18 in the household.
     * Number 1-10 or null. See "children_at_address_description_11_18_years" for more information.
     * Example: 7
     */
    @SerializedName("children_at_address_code_11_18_years")
    private String childrenAtAddressCode1118Years;

    /**
     * Describes the likelihood of the presence of children aged 11-18 in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Moderately high likelihood
     */
    @SerializedName("children_at_address_description_11_18_years")
    private String childrenAtAddressDescription1118Years;

    /**
     * A code which indicates the demand for credit. Number 1-12 or null.
     * See "credit_demand_description" for more information.
     * Note: for privacy reasons, credit data is aggregated at sub-Mesh Block level, rather than address level.
     * Example: 6
     */
    @SerializedName("credit_demand_code")
    private String creditDemandCode;

    /**
     * Describes the demand for credit. See the ConsumerView Fact Sheet for more details.
     * Example: Moderate Likelihood of Credit Demand (60-70%)
     */
    @SerializedName("credit_demand_description")
    private String creditDemandDescription;

    /**
     * A code which estimates the annual income of the household. Number 1-7 or null.
     * See "household_income_description" for more information.
     * Example: 2
     */
    @SerializedName("household_income_code")
    private String householdIncomeCode;

    /**
     * Describes the annual income of the household. See the ConsumerView Fact Sheet for more details.
     * Example: $20,800 - $41,599
     */
    @SerializedName("household_income_description")
    private String householdIncomeDescription;

    /**
     * A code which indicates the composition of the household. Number 1-6 or null.
     * See "household_composition_description" for more information.
     * Example: 3
     */
    @SerializedName("household_composition_code")
    private String householdCompositionCode;

    /**
     * Describes the composition of the household. See the ConsumerView Fact Sheet for more details.
     * Example: Couples
     */
    @SerializedName("household_composition_description")
    private String householdCompositionDescription;

    /**
     * A code which estimates the age category of the person likely to be the head of the household.
     * Number 1-15 or null. See "head_of_household_age_description" for more information.
     * Example: 15
     */
    @SerializedName("head_of_household_age_code")
    private String headOfHouseholdAgeCode;

    /**
     * Describes the age category of the person likely to be the head of the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Age 85 and over
     */
    @SerializedName("head_of_household_age_description")
    private String headOfHouseholdAgeDescription;

    /**
     * A code which indicates the life stage of the household's occupants. Number 1-10 or null.
     * See "lifestage_description" for more information.
     * Example: 9
     */
    @SerializedName("lifestage_code")
    private String lifestageCode;

    /**
     * Describes the life stage of the household's occupants. See the ConsumerView Fact Sheet for more details.
     * Example: Elderly Couples
     */
    @SerializedName("lifestage_description")
    private String lifestageDescription;

    /**
     * A code which estimates the length of time the occupants have been living in the household for.
     * Number 1-15 or null. See "length_of_residence_description" for more information.
     * Example: 15
     */
    @SerializedName("length_of_residence_code")
    private String lengthOfResidenceCode;

    /**
     * Describes the length of time the occupants have been living in the household for.
     * See the ConsumerView Fact Sheet for more details.
     * Example: 14+ yrs
     */
    @SerializedName("length_of_residence_description")
    private String lengthOfResidenceDescription;

    /**
     * Experian Mosaic factor score for Family Composition. Number ranging from -40000 to 40000.
     * Example: 1012
     */
    @SerializedName("mosaic_factor1_score_2018")
    private String mosaicFactor1Score2018;

    /**
     * Experian Mosaic factor score for Prosperity. Number ranging from -40000 to 40000.
     * Example: -13182
     */
    @SerializedName("mosaic_factor2_score_2018")
    private String mosaicFactor2Score2018;

    /**
     * Experian Mosaic factor score for Dependants. Number ranging from -40000 to 40000.
     * Example: 869
     */
    @SerializedName("mosaic_factor3_score_2018")
    private String mosaicFactor3Score2018;

    /**
     * Experian Mosaic factor score for Cultural Diversity. Number ranging from -40000 to 40000.
     * Example: 10913
     */
    @SerializedName("mosaic_factor4_score_2018")
    private String mosaicFactor4Score2018;

    /**
     * Experian Mosaic factor score for Housing Ownership. Number ranging from -40000 to 40000.
     * Example: 850
     */
    @SerializedName("mosaic_factor5_score_2018")
    private String mosaicFactor5Score2018;

    /**
     * Experian Mosaic factor percentile for Family Composition. Number ranging from 0 to 99.
     * Example: 51
     */
    @SerializedName("mosaic_factor1_percentile_2018")
    private String mosaicFactor1Percentile2018;

    /**
     * Experian Mosaic factor percentile for Prosperity. Number ranging from 0 to 99.
     * Example: 2
     */
    @SerializedName("mosaic_factor2_percentile_2018")
    private String mosaicFactor2Percentile2018;

    /**
     * Experian Mosaic factor percentile for Dependants. Number ranging from 0 to 99.
     * Example: 50
     */
    @SerializedName("mosaic_factor3_percentile_2018")
    private String mosaicFactor3Percentile2018;

    /**
     * Experian Mosaic factor percentile for Cultural Diversity. Number ranging from 0 to 99.
     * Example: 86
     */
    @SerializedName("mosaic_factor4_percentile_2018")
    private String mosaicFactor4Percentile2018;

    /**
     * Experian Mosaic factor percentile for Housing Ownership. Number ranging from 0 to 99.
     * Example: 39
     */
    @SerializedName("mosaic_factor5_percentile_2018")
    private String mosaicFactor5Percentile2018;

    /**
     * A code which indicates financial risk. Number 1-12 or 99.
     * See "risk_insight_description" for more information.
     * Note: for privacy reasons, credit data is aggregated at sub-Mesh Block level, rather than address level.
     * Example: 1
     */
    @SerializedName("risk_insight_code")
    private String riskInsightCode;

    /**
     * Describes the financial risk. See the ConsumerView Fact Sheet for more details.
     * Example: Highest Likelihood of Credit Risk (top 5%)
     */
    @SerializedName("risk_insight_description")
    private String riskInsightDescription;

    /**
     * A code which indicates the household’s preferred form of media. Number 1-8 or null.
     * See "channel_preference_description" for more information.
     * Example: 8
     */
    @SerializedName("channel_preference")
    private String channelPreference;

    /**
     * Describes the household's preferred form of media. See the ConsumerView Fact Sheet for more details.
     * Example: Keeping it Local
     */
    @SerializedName("channel_preference_description")
    private String channelPreferenceDescription;

    /**
     * Experian Mosaic group. Alphabetic value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L
     */
    @SerializedName("mosaic_group")
    private String mosaicGroup;

    /**
     * Experian Mosaic type. Alphanumeric value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46
     */
    @SerializedName("mosaic_type")
    private String mosaicType;

    /**
     * Experian Mosaic segment. May contain letters, numbers and special characters.
     * This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46_5
     */
    @SerializedName("mosaic_segment")
    private String mosaicSegment;

    /**
     * Experian Mosaic group (2015). Alphabetic value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L
     */
    @SerializedName("mosaic_group_2015")
    private String mosaicGroup2015;

    /**
     * Experian Mosaic type (2015). Alphanumeric value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46
     */
    @SerializedName("mosaic_type_2015")
    private String mosaicType2015;

    /**
     * Experian Mosaic segment (2015). May contain letters, numbers and special characters.
     * This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46_5
     */
    @SerializedName("mosaic_segment_2015")
    private String mosaicSegment2015;

    /**
     * Only returned if the address is suppressed and should not be contacted. Only possible value: "Y".
     * Example: Y
     */
    @SerializedName("mail_suppression")
    private String mailSuppression;

    /**
     * Gets the hin.
     * @return The hin.
     */
    public String getHin() {
        return this.hin;
    }

    /**
     * Sets the hin.
     * @param hin The hin.
     */
    public void setHin(final String hin) {
        this.hin = hin;
    }

    /**
     * Gets the address.
     * @return The address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the address.
     * @param address The address.
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Gets the suburb.
     * @return The suburb.
     */
    public String getSuburb() {
        return this.suburb;
    }

    /**
     * Sets the suburb.
     * @param suburb The suburb.
     */
    public void setSuburb(final String suburb) {
        this.suburb = suburb;
    }

    /**
     * Gets the postcode.
     * @return The postcode.
     */
    public String getPostcode() {
        return this.postcode;
    }

    /**
     * Sets the postcode.
     * @param postcode The postcode.
     */
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets the state.
     * @return The state.
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state.
     * @param state The state.
     */
    public void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the residentialFlag.
     * @return The residentialFlag.
     */
    public String getResidentialFlag() {
        return this.residentialFlag;
    }

    /**
     * Sets the residentialFlag.
     * @param residentialFlag The residentialFlag.
     */
    public void setResidentialFlag(final String residentialFlag) {
        this.residentialFlag = residentialFlag;
    }

    /**
     * Gets the gnafPid.
     * @return The gnafPid.
     */
    public String getGnafPid() {
        return this.gnafPid;
    }

    /**
     * Sets the gnafPid.
     * @param gnafPid The gnafPid.
     */
    public void setGnafPid(final String gnafPid) {
        this.gnafPid = gnafPid;
    }

    /**
     * Gets the gnafLatitude.
     * @return The gnafLatitude.
     */
    public Double getGnafLatitude() {
        return this.gnafLatitude;
    }

    /**
     * Sets the gnafLatitude.
     * @param gnafLatitude The gnafLatitude.
     */
    public void setGnafLatitude(final Double gnafLatitude) {
        this.gnafLatitude = gnafLatitude;
    }

    /**
     * Gets the gnafLongitude.
     * @return The gnafLongitude.
     */
    public Double getGnafLongitude() {
        return this.gnafLongitude;
    }

    /**
     * Sets the gnafLongitude.
     * @param gnafLongitude The gnafLongitude.
     */
    public void setGnafLongitude(final Double gnafLongitude) {
        this.gnafLongitude = gnafLongitude;
    }

    /**
     * Gets the meshblock.
     * @return The meshblock.
     */
    public String getMeshblock() {
        return this.meshblock;
    }

    /**
     * Sets the meshblock.
     * @param meshblock The meshblock.
     */
    public void setMeshblock(final String meshblock) {
        this.meshblock = meshblock;
    }

    /**
     * Gets the sa1.
     * @return The sa1.
     */
    public String getSa1() {
        return this.sa1;
    }

    /**
     * Sets the sa1.
     * @param sa1 The sa1.
     */
    public void setSa1(final String sa1) {
        this.sa1 = sa1;
    }

    /**
     * Gets the localGovernmentAreaCode.
     * @return The localGovernmentAreaCode.
     */
    public String getLocalGovernmentAreaCode() {
        return this.localGovernmentAreaCode;
    }

    /**
     * Sets the localGovernmentAreaCode.
     * @param localGovernmentAreaCode The localGovernmentAreaCode.
     */
    public void setLocalGovernmentAreaCode(final String localGovernmentAreaCode) {
        this.localGovernmentAreaCode = localGovernmentAreaCode;
    }

    /**
     * Gets the localGovernmentAreaName.
     * @return The localGovernmentAreaName.
     */
    public String getLocalGovernmentAreaName() {
        return this.localGovernmentAreaName;
    }

    /**
     * Sets the localGovernmentAreaName.
     * @param localGovernmentAreaName The localGovernmentAreaName.
     */
    public void setLocalGovernmentAreaName(final String localGovernmentAreaName) {
        this.localGovernmentAreaName = localGovernmentAreaName;
    }

    /**
     * Gets the mosaicGroup2018.
     * @return The mosaicGroup2018.
     */
    public String getMosaicGroup2018() {
        return this.mosaicGroup2018;
    }

    /**
     * Sets the mosaicGroup2018.
     * @param mosaicGroup2018 The mosaicGroup2018.
     */
    public void setMosaicGroup2018(final String mosaicGroup2018) {
        this.mosaicGroup2018 = mosaicGroup2018;
    }

    /**
     * Gets the mosaicType2018.
     * @return The mosaicType2018.
     */
    public String getMosaicType2018() {
        return this.mosaicType2018;
    }

    /**
     * Sets the mosaicType2018.
     * @param mosaicType2018 The mosaicType2018.
     */
    public void setMosaicType2018(final String mosaicType2018) {
        this.mosaicType2018 = mosaicType2018;
    }

    /**
     * Gets the mosaicSegment2018.
     * @return The mosaicSegment2018.
     */
    public String getMosaicSegment2018() {
        return this.mosaicSegment2018;
    }

    /**
     * Sets the mosaicSegment2018.
     * @param mosaicSegment2018 The mosaicSegment2018.
     */
    public void setMosaicSegment2018(final String mosaicSegment2018) {
        this.mosaicSegment2018 = mosaicSegment2018;
    }

    /**
     * Gets the affluenceCode.
     * @return The affluenceCode.
     */
    public String getAffluenceCode() {
        return this.affluenceCode;
    }

    /**
     * Sets the affluenceCode.
     * @param affluenceCode The affluenceCode.
     */
    public void setAffluenceCode(final String affluenceCode) {
        this.affluenceCode = affluenceCode;
    }

    /**
     * Gets the affluenceDescription.
     * @return The affluenceDescription.
     */
    public String getAffluenceDescription() {
        return this.affluenceDescription;
    }

    /**
     * Sets the affluenceDescription.
     * @param affluenceDescription The affluenceDescription.
     */
    public void setAffluenceDescription(final String affluenceDescription) {
        this.affluenceDescription = affluenceDescription;
    }

    /**
     * Gets the adultsAtAddressCode.
     * @return The adultsAtAddressCode.
     */
    public String getAdultsAtAddressCode() {
        return this.adultsAtAddressCode;
    }

    /**
     * Sets the adultsAtAddressCode.
     * @param adultsAtAddressCode The adultsAtAddressCode.
     */
    public void setAdultsAtAddressCode(final String adultsAtAddressCode) {
        this.adultsAtAddressCode = adultsAtAddressCode;
    }

    /**
     * Gets the adultsAtAddressDescription.
     * @return The adultsAtAddressDescription.
     */
    public String getAdultsAtAddressDescription() {
        return this.adultsAtAddressDescription;
    }

    /**
     * Sets the adultsAtAddressDescription.
     * @param adultsAtAddressDescription The adultsAtAddressDescription.
     */
    public void setAdultsAtAddressDescription(final String adultsAtAddressDescription) {
        this.adultsAtAddressDescription = adultsAtAddressDescription;
    }

    /**
     * Gets the childrenAtAddressCode010Years.
     * @return The childrenAtAddressCode010Years.
     */
    public String getChildrenAtAddressCode010Years() {
        return this.childrenAtAddressCode010Years;
    }

    /**
     * Sets the childrenAtAddressCode010Years.
     * @param childrenAtAddressCode010Years The childrenAtAddressCode010Years.
     */
    public void setChildrenAtAddressCode010Years(final String childrenAtAddressCode010Years) {
        this.childrenAtAddressCode010Years = childrenAtAddressCode010Years;
    }

    /**
     * Gets the childrenAtAddressDescription010Years.
     * @return The childrenAtAddressDescription010Years.
     */
    public String getChildrenAtAddressDescription010Years() {
        return this.childrenAtAddressDescription010Years;
    }

    /**
     * Sets the childrenAtAddressDescription010Years.
     * @param childrenAtAddressDescription010Years The childrenAtAddressDescription010Years.
     */
    public void setChildrenAtAddressDescription010Years(final String childrenAtAddressDescription010Years) {
        this.childrenAtAddressDescription010Years = childrenAtAddressDescription010Years;
    }

    /**
     * Gets the childrenAtAddressCode1118Years.
     * @return The childrenAtAddressCode1118Years.
     */
    public String getChildrenAtAddressCode1118Years() {
        return this.childrenAtAddressCode1118Years;
    }

    /**
     * Sets the childrenAtAddressCode1118Years.
     * @param childrenAtAddressCode1118Years The childrenAtAddressCode1118Years.
     */
    public void setChildrenAtAddressCode1118Years(final String childrenAtAddressCode1118Years) {
        this.childrenAtAddressCode1118Years = childrenAtAddressCode1118Years;
    }

    /**
     * Gets the childrenAtAddressDescription1118Years.
     * @return The childrenAtAddressDescription1118Years.
     */
    public String getChildrenAtAddressDescription1118Years() {
        return this.childrenAtAddressDescription1118Years;
    }

    /**
     * Sets the childrenAtAddressDescription1118Years.
     * @param childrenAtAddressDescription1118Years The childrenAtAddressDescription1118Years.
     */
    public void setChildrenAtAddressDescription1118Years(final String childrenAtAddressDescription1118Years) {
        this.childrenAtAddressDescription1118Years = childrenAtAddressDescription1118Years;
    }

    /**
     * Gets the creditDemandCode.
     * @return The creditDemandCode.
     */
    public String getCreditDemandCode() {
        return this.creditDemandCode;
    }

    /**
     * Sets the creditDemandCode.
     * @param creditDemandCode The creditDemandCode.
     */
    public void setCreditDemandCode(final String creditDemandCode) {
        this.creditDemandCode = creditDemandCode;
    }

    /**
     * Gets the creditDemandDescription.
     * @return The creditDemandDescription.
     */
    public String getCreditDemandDescription() {
        return this.creditDemandDescription;
    }

    /**
     * Sets the creditDemandDescription.
     * @param creditDemandDescription The creditDemandDescription.
     */
    public void setCreditDemandDescription(final String creditDemandDescription) {
        this.creditDemandDescription = creditDemandDescription;
    }

    /**
     * Gets the householdIncomeCode.
     * @return The householdIncomeCode.
     */
    public String getHouseholdIncomeCode() {
        return this.householdIncomeCode;
    }

    /**
     * Sets the householdIncomeCode.
     * @param householdIncomeCode The householdIncomeCode.
     */
    public void setHouseholdIncomeCode(final String householdIncomeCode) {
        this.householdIncomeCode = householdIncomeCode;
    }

    /**
     * Gets the householdIncomeDescription.
     * @return The householdIncomeDescription.
     */
    public String getHouseholdIncomeDescription() {
        return this.householdIncomeDescription;
    }

    /**
     * Sets the householdIncomeDescription.
     * @param householdIncomeDescription The householdIncomeDescription.
     */
    public void setHouseholdIncomeDescription(final String householdIncomeDescription) {
        this.householdIncomeDescription = householdIncomeDescription;
    }

    /**
     * Gets the householdCompositionCode.
     * @return The householdCompositionCode.
     */
    public String getHouseholdCompositionCode() {
        return this.householdCompositionCode;
    }

    /**
     * Sets the householdCompositionCode.
     * @param householdCompositionCode The householdCompositionCode.
     */
    public void setHouseholdCompositionCode(final String householdCompositionCode) {
        this.householdCompositionCode = householdCompositionCode;
    }

    /**
     * Gets the householdCompositionDescription.
     * @return The householdCompositionDescription.
     */
    public String getHouseholdCompositionDescription() {
        return this.householdCompositionDescription;
    }

    /**
     * Sets the householdCompositionDescription.
     * @param householdCompositionDescription The householdCompositionDescription.
     */
    public void setHouseholdCompositionDescription(final String householdCompositionDescription) {
        this.householdCompositionDescription = householdCompositionDescription;
    }

    /**
     * Gets the headOfHouseholdAgeCode.
     * @return The headOfHouseholdAgeCode.
     */
    public String getHeadOfHouseholdAgeCode() {
        return this.headOfHouseholdAgeCode;
    }

    /**
     * Sets the headOfHouseholdAgeCode.
     * @param headOfHouseholdAgeCode The headOfHouseholdAgeCode.
     */
    public void setHeadOfHouseholdAgeCode(final String headOfHouseholdAgeCode) {
        this.headOfHouseholdAgeCode = headOfHouseholdAgeCode;
    }

    /**
     * Gets the headOfHouseholdAgeDescription.
     * @return The headOfHouseholdAgeDescription.
     */
    public String getHeadOfHouseholdAgeDescription() {
        return this.headOfHouseholdAgeDescription;
    }

    /**
     * Sets the headOfHouseholdAgeDescription.
     * @param headOfHouseholdAgeDescription The headOfHouseholdAgeDescription.
     */
    public void setHeadOfHouseholdAgeDescription(final String headOfHouseholdAgeDescription) {
        this.headOfHouseholdAgeDescription = headOfHouseholdAgeDescription;
    }

    /**
     * Gets the lifestageCode.
     * @return The lifestageCode.
     */
    public String getLifestageCode() {
        return this.lifestageCode;
    }

    /**
     * Sets the lifestageCode.
     * @param lifestageCode The lifestageCode.
     */
    public void setLifestageCode(final String lifestageCode) {
        this.lifestageCode = lifestageCode;
    }

    /**
     * Gets the lifestageDescription.
     * @return The lifestageDescription.
     */
    public String getLifestageDescription() {
        return this.lifestageDescription;
    }

    /**
     * Sets the lifestageDescription.
     * @param lifestageDescription The lifestageDescription.
     */
    public void setLifestageDescription(final String lifestageDescription) {
        this.lifestageDescription = lifestageDescription;
    }

    /**
     * Gets the lengthOfResidenceCode.
     * @return The lengthOfResidenceCode.
     */
    public String getLengthOfResidenceCode() {
        return this.lengthOfResidenceCode;
    }

    /**
     * Sets the lengthOfResidenceCode.
     * @param lengthOfResidenceCode The lengthOfResidenceCode.
     */
    public void setLengthOfResidenceCode(final String lengthOfResidenceCode) {
        this.lengthOfResidenceCode = lengthOfResidenceCode;
    }

    /**
     * Gets the lengthOfResidenceDescription.
     * @return The lengthOfResidenceDescription.
     */
    public String getLengthOfResidenceDescription() {
        return this.lengthOfResidenceDescription;
    }

    /**
     * Sets the lengthOfResidenceDescription.
     * @param lengthOfResidenceDescription The lengthOfResidenceDescription.
     */
    public void setLengthOfResidenceDescription(final String lengthOfResidenceDescription) {
        this.lengthOfResidenceDescription = lengthOfResidenceDescription;
    }

    /**
     * Gets the mosaicFactor1Score2018.
     * @return The mosaicFactor1Score2018.
     */
    public String getMosaicFactor1Score2018() {
        return this.mosaicFactor1Score2018;
    }

    /**
     * Sets the mosaicFactor1Score2018.
     * @param mosaicFactor1Score2018 The mosaicFactor1Score2018.
     */
    public void setMosaicFactor1Score2018(final String mosaicFactor1Score2018) {
        this.mosaicFactor1Score2018 = mosaicFactor1Score2018;
    }

    /**
     * Gets the mosaicFactor2Score2018.
     * @return The mosaicFactor2Score2018.
     */
    public String getMosaicFactor2Score2018() {
        return this.mosaicFactor2Score2018;
    }

    /**
     * Sets the mosaicFactor2Score2018.
     * @param mosaicFactor2Score2018 The mosaicFactor2Score2018.
     */
    public void setMosaicFactor2Score2018(final String mosaicFactor2Score2018) {
        this.mosaicFactor2Score2018 = mosaicFactor2Score2018;
    }

    /**
     * Gets the mosaicFactor3Score2018.
     * @return The mosaicFactor3Score2018.
     */
    public String getMosaicFactor3Score2018() {
        return this.mosaicFactor3Score2018;
    }

    /**
     * Sets the mosaicFactor3Score2018.
     * @param mosaicFactor3Score2018 The mosaicFactor3Score2018.
     */
    public void setMosaicFactor3Score2018(final String mosaicFactor3Score2018) {
        this.mosaicFactor3Score2018 = mosaicFactor3Score2018;
    }

    /**
     * Gets the mosaicFactor4Score2018.
     * @return The mosaicFactor4Score2018.
     */
    public String getMosaicFactor4Score2018() {
        return this.mosaicFactor4Score2018;
    }

    /**
     * Sets the mosaicFactor4Score2018.
     * @param mosaicFactor4Score2018 The mosaicFactor4Score2018.
     */
    public void setMosaicFactor4Score2018(final String mosaicFactor4Score2018) {
        this.mosaicFactor4Score2018 = mosaicFactor4Score2018;
    }

    /**
     * Gets the mosaicFactor5Score2018.
     * @return The mosaicFactor5Score2018.
     */
    public String getMosaicFactor5Score2018() {
        return this.mosaicFactor5Score2018;
    }

    /**
     * Sets the mosaicFactor5Score2018.
     * @param mosaicFactor5Score2018 The mosaicFactor5Score2018.
     */
    public void setMosaicFactor5Score2018(final String mosaicFactor5Score2018) {
        this.mosaicFactor5Score2018 = mosaicFactor5Score2018;
    }

    /**
     * Gets the mosaicFactor1Percentile2018.
     * @return The mosaicFactor1Percentile2018.
     */
    public String getMosaicFactor1Percentile2018() {
        return this.mosaicFactor1Percentile2018;
    }

    /**
     * Sets the mosaicFactor1Percentile2018.
     * @param mosaicFactor1Percentile2018 The mosaicFactor1Percentile2018.
     */
    public void setMosaicFactor1Percentile2018(final String mosaicFactor1Percentile2018) {
        this.mosaicFactor1Percentile2018 = mosaicFactor1Percentile2018;
    }

    /**
     * Gets the mosaicFactor2Percentile2018.
     * @return The mosaicFactor2Percentile2018.
     */
    public String getMosaicFactor2Percentile2018() {
        return this.mosaicFactor2Percentile2018;
    }

    /**
     * Sets the mosaicFactor2Percentile2018.
     * @param mosaicFactor2Percentile2018 The mosaicFactor2Percentile2018.
     */
    public void setMosaicFactor2Percentile2018(final String mosaicFactor2Percentile2018) {
        this.mosaicFactor2Percentile2018 = mosaicFactor2Percentile2018;
    }

    /**
     * Gets the mosaicFactor3Percentile2018.
     * @return The mosaicFactor3Percentile2018.
     */
    public String getMosaicFactor3Percentile2018() {
        return this.mosaicFactor3Percentile2018;
    }

    /**
     * Sets the mosaicFactor3Percentile2018.
     * @param mosaicFactor3Percentile2018 The mosaicFactor3Percentile2018.
     */
    public void setMosaicFactor3Percentile2018(final String mosaicFactor3Percentile2018) {
        this.mosaicFactor3Percentile2018 = mosaicFactor3Percentile2018;
    }

    /**
     * Gets the mosaicFactor4Percentile2018.
     * @return The mosaicFactor4Percentile2018.
     */
    public String getMosaicFactor4Percentile2018() {
        return this.mosaicFactor4Percentile2018;
    }

    /**
     * Sets the mosaicFactor4Percentile2018.
     * @param mosaicFactor4Percentile2018 The mosaicFactor4Percentile2018.
     */
    public void setMosaicFactor4Percentile2018(final String mosaicFactor4Percentile2018) {
        this.mosaicFactor4Percentile2018 = mosaicFactor4Percentile2018;
    }

    /**
     * Gets the mosaicFactor5Percentile2018.
     * @return The mosaicFactor5Percentile2018.
     */
    public String getMosaicFactor5Percentile2018() {
        return this.mosaicFactor5Percentile2018;
    }

    /**
     * Sets the mosaicFactor5Percentile2018.
     * @param mosaicFactor5Percentile2018 The mosaicFactor5Percentile2018.
     */
    public void setMosaicFactor5Percentile2018(final String mosaicFactor5Percentile2018) {
        this.mosaicFactor5Percentile2018 = mosaicFactor5Percentile2018;
    }

    /**
     * Gets the riskInsightCode.
     * @return The riskInsightCode.
     */
    public String getRiskInsightCode() {
        return this.riskInsightCode;
    }

    /**
     * Sets the riskInsightCode.
     * @param riskInsightCode The riskInsightCode.
     */
    public void setRiskInsightCode(final String riskInsightCode) {
        this.riskInsightCode = riskInsightCode;
    }

    /**
     * Gets the riskInsightDescription.
     * @return The riskInsightDescription.
     */
    public String getRiskInsightDescription() {
        return this.riskInsightDescription;
    }

    /**
     * Sets the riskInsightDescription.
     * @param riskInsightDescription The riskInsightDescription.
     */
    public void setRiskInsightDescription(final String riskInsightDescription) {
        this.riskInsightDescription = riskInsightDescription;
    }

    /**
     * Gets the channelPreference.
     * @return The channelPreference.
     */
    public String getChannelPreference() {
        return this.channelPreference;
    }

    /**
     * Sets the channelPreference.
     * @param channelPreference The channelPreference.
     */
    public void setChannelPreference(final String channelPreference) {
        this.channelPreference = channelPreference;
    }

    /**
     * Gets the channelPreferenceDescription.
     * @return The channelPreferenceDescription.
     */
    public String getChannelPreferenceDescription() {
        return this.channelPreferenceDescription;
    }

    /**
     * Sets the channelPreferenceDescription.
     * @param channelPreferenceDescription The channelPreferenceDescription.
     */
    public void setChannelPreferenceDescription(final String channelPreferenceDescription) {
        this.channelPreferenceDescription = channelPreferenceDescription;
    }

    /**
     * Gets the mosaicGroup.
     * @return The mosaicGroup.
     */
    public String getMosaicGroup() {
        return this.mosaicGroup;
    }

    /**
     * Sets the mosaicGroup.
     * @param mosaicGroup The mosaicGroup.
     */
    public void setMosaicGroup(final String mosaicGroup) {
        this.mosaicGroup = mosaicGroup;
    }

    /**
     * Gets the mosaicType.
     * @return The mosaicType.
     */
    public String getMosaicType() {
        return this.mosaicType;
    }

    /**
     * Sets the mosaicType.
     * @param mosaicType The mosaicType.
     */
    public void setMosaicType(final String mosaicType) {
        this.mosaicType = mosaicType;
    }

    /**
     * Gets the mosaicSegment.
     * @return The mosaicSegment.
     */
    public String getMosaicSegment() {
        return this.mosaicSegment;
    }

    /**
     * Sets the mosaicSegment.
     * @param mosaicSegment The mosaicSegment.
     */
    public void setMosaicSegment(final String mosaicSegment) {
        this.mosaicSegment = mosaicSegment;
    }

    /**
     * Gets the mosaicGroup2015.
     * @return The mosaicGroup2015.
     */
    public String getMosaicGroup2015() {
        return this.mosaicGroup2015;
    }

    /**
     * Sets the mosaicGroup2015.
     * @param mosaicGroup2015 The mosaicGroup2015.
     */
    public void setMosaicGroup2015(final String mosaicGroup2015) {
        this.mosaicGroup2015 = mosaicGroup2015;
    }

    /**
     * Gets the mosaicType2015.
     * @return The mosaicType2015.
     */
    public String getMosaicType2015() {
        return this.mosaicType2015;
    }

    /**
     * Sets the mosaicType2015.
     * @param mosaicType2015 The mosaicType2015.
     */
    public void setMosaicType2015(final String mosaicType2015) {
        this.mosaicType2015 = mosaicType2015;
    }

    /**
     * Gets the mosaicSegment2015.
     * @return The mosaicSegment2015.
     */
    public String getMosaicSegment2015() {
        return this.mosaicSegment2015;
    }

    /**
     * Sets the mosaicSegment2015.
     * @param mosaicSegment2015 The mosaicSegment2015.
     */
    public void setMosaicSegment2015(final String mosaicSegment2015) {
        this.mosaicSegment2015 = mosaicSegment2015;
    }

    /**
     * Gets the mailSuppression.
     * @return The mailSuppression.
     */
    public String getMailSuppression() {
        return this.mailSuppression;
    }

    /**
     * Sets the mailSuppression.
     * @param mailSuppression The mailSuppression.
     */
    public void setMailSuppression(final String mailSuppression) {
        this.mailSuppression = mailSuppression;
    }
}

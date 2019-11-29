package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the Australian ConsumerView Postcode Data dataset.
 */
public final class EnrichmentAusCVPostcodeMetadata {
    /**
     * The postal code or zip code of the address.
     * Example: 7140
     */
    @SerializedName("postcode")
    private DatasetMetadata postcode;

    /**
     * A code which indicates the household level of wealth based on household demographics,
     * assets and investments. Number 1-7 or null.
     * See "affluence_description" for more information.
     * Example: 4
     */
    @SerializedName("affluence_code")
    private DatasetMetadata affluenceCode;

    /**
     * Describes the household's level of wealth.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Average income Average assets
     */
    @SerializedName("affluence_description")
    private DatasetMetadata affluenceDescription;

    /**
     * A code which estimates the number of adults (people aged 18+) living in the household.
     * Number 1-10 or null. See "adults_at_address_description" for more information.
     * Example: 2
     */
    @SerializedName("adults_at_address_code")
    private DatasetMetadata adultsAtAddressCode;

    /**
     * Describes the number of adults (people aged 18+) living in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Two adults
     */
    @SerializedName("adults_at_address_description")
    private DatasetMetadata adultsAtAddressDescription;

    /**
     * A code which represents the likelihood of the presence of children aged 0-10 in the household.
     * Number 1-10 or null. See "children_at_address_description_0_10_years" for more information.
     * Example: 5
     */
    @SerializedName("children_at_address_code_0_10_years")
    private DatasetMetadata childrenAtAddressCode010Years;

    /**
     * Describes the likelihood of the presence of children aged 0-10 in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Average likelihood
     */
    @SerializedName("children_at_address_description_0_10_years")
    private DatasetMetadata childrenAtAddressDescription010Years;

    /**
     * A code which represents the likelihood of the presence of children aged 11-18 in the household.
     * Number 1-10 or null. See "children_at_address_description_11_18_years" for more information.
     * Example: 7
     */
    @SerializedName("children_at_address_code_11_18_years")
    private DatasetMetadata childrenAtAddressCode1118Years;

    /**
     * Describes the likelihood of the presence of children aged 11-18 in the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Moderately high likelihood
     */
    @SerializedName("children_at_address_description_11_18_years")
    private DatasetMetadata childrenAtAddressDescription1118Years;

    /**
     * A code which indicates the demand for credit. Number 1-12 or null.
     * See "credit_demand_description" for more information.
     * Note: for privacy reasons, credit data is aggregated at sub-Mesh Block level, rather than address level.
     * Example: 6
     */
    @SerializedName("credit_demand_code")
    private DatasetMetadata creditDemandCode;

    /**
     * Describes the demand for credit. See the ConsumerView Fact Sheet for more details.
     * Example: Moderate Likelihood of Credit Demand (60-70%)
     */
    @SerializedName("credit_demand_description")
    private DatasetMetadata creditDemandDescription;

    /**
     * A code which estimates the annual income of the household. Number 1-7 or null.
     * See "household_income_description" for more information.
     * Example: 2
     */
    @SerializedName("household_income_code")
    private DatasetMetadata householdIncomeCode;

    /**
     * Describes the annual income of the household. See the ConsumerView Fact Sheet for more details.
     * Example: $20,800 - $41,599
     */
    @SerializedName("household_income_description")
    private DatasetMetadata householdIncomeDescription;

    /**
     * A code which indicates the composition of the household. Number 1-6 or null.
     * See "household_composition_description" for more information.
     * Example: 3
     */
    @SerializedName("household_composition_code")
    private DatasetMetadata householdCompositionCode;

    /**
     * Describes the composition of the household. See the ConsumerView Fact Sheet for more details.
     * Example: Couples
     */
    @SerializedName("household_composition_description")
    private DatasetMetadata householdCompositionDescription;

    /**
     * A code which estimates the age category of the person likely to be the head of the household.
     * Number 1-15 or null. See "head_of_household_age_description" for more information.
     * Example: 15
     */
    @SerializedName("head_of_household_age_code")
    private DatasetMetadata headOfHouseholdAgeCode;

    /**
     * Describes the age category of the person likely to be the head of the household.
     * See the ConsumerView Fact Sheet for more details.
     * Example: Age 85 and over
     */
    @SerializedName("head_of_household_age_description")
    private DatasetMetadata headOfHouseholdAgeDescription;

    /**
     * A code which indicates the life stage of the household's occupants. Number 1-10 or null.
     * See "lifestage_description" for more information.
     * Example: 9
     */
    @SerializedName("lifestage_code")
    private DatasetMetadata lifestageCode;

    /**
     * Describes the life stage of the household's occupants. See the ConsumerView Fact Sheet for more details.
     * Example: Elderly Couples
     */
    @SerializedName("lifestage_description")
    private DatasetMetadata lifestageDescription;

    /**
     * A code which estimates the length of time the occupants have been living in the household for.
     * Number 1-15 or null. See "length_of_residence_description" for more information.
     * Example: 15
     */
    @SerializedName("length_of_residence_code")
    private DatasetMetadata lengthOfResidenceCode;

    /**
     * Describes the length of time the occupants have been living in the household for.
     * See the ConsumerView Fact Sheet for more details.
     * Example: 14+ yrs
     */
    @SerializedName("length_of_residence_description")
    private DatasetMetadata lengthOfResidenceDescription;

    /**
     * A code which indicates financial risk. Number 1-12 or 99.
     * See "risk_insight_description" for more information.
     * Note: for privacy reasons, credit data is aggregated at sub-Mesh Block level, rather than address level.
     * Example: 1
     */
    @SerializedName("risk_insight_code")
    private DatasetMetadata riskInsightCode;

    /**
     * Describes the financial risk. See the ConsumerView Fact Sheet for more details.
     * Example: Highest Likelihood of Credit Risk (top 5%)
     */
    @SerializedName("risk_insight_description")
    private DatasetMetadata riskInsightDescription;

    /**
     * Experian Mosaic group (2018). Alphabetic value.
     * See the ConsumerView Fact Sheet for more details.
     * Example: M
     */
    @SerializedName("mosaic_group_2018")
    private DatasetMetadata mosaicGroup2018;

    /**
     * Experian Mosaic type (2018). Alphanumeric value.
     * See the ConsumerView Fact Sheet for more details.
     * Example: M47
     */
    @SerializedName("mosaic_type_2018")
    private DatasetMetadata mosaicType2018;

    /**
     * Experian Mosaic group. Alphabetic value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L
     */
    @SerializedName("mosaic_group")
    private DatasetMetadata mosaicGroup;

    /**
     * Experian Mosaic type. Alphanumeric value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46
     */
    @SerializedName("mosaic_type")
    private DatasetMetadata mosaicType;

    /**
     * Experian Mosaic group (2015). Alphabetic value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L
     */
    @SerializedName("mosaic_group_2015")
    private DatasetMetadata mosaicGroup2015;

    /**
     * Experian Mosaic type (2015). Alphanumeric value. This attribute mainly has backward compatibility purposes.
     * Please consider using the latest available Experian Mosaic attributes instead.
     * Example: L46
     */
    @SerializedName("mosaic_type_2015")
    private DatasetMetadata mosaicType2015;

    /**
     * Gets the postcode.
     * @return The postcode.
     */
    public DatasetMetadata getPostcode() {
        return this.postcode;
    }

    /**
     * Sets the postcode.
     * @param postcode The postcode.
     */
    public void setPostcode(final DatasetMetadata postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets the mosaicGroup2018.
     * @return The mosaicGroup2018.
     */
    public DatasetMetadata getMosaicGroup2018() {
        return this.mosaicGroup2018;
    }

    /**
     * Sets the mosaicGroup2018.
     * @param mosaicGroup2018 The mosaicGroup2018.
     */
    public void setMosaicGroup2018(final DatasetMetadata mosaicGroup2018) {
        this.mosaicGroup2018 = mosaicGroup2018;
    }

    /**
     * Gets the mosaicType2018.
     * @return The mosaicType2018.
     */
    public DatasetMetadata getMosaicType2018() {
        return this.mosaicType2018;
    }

    /**
     * Sets the mosaicType2018.
     * @param mosaicType2018 The mosaicType2018.
     */
    public void setMosaicType2018(final DatasetMetadata mosaicType2018) {
        this.mosaicType2018 = mosaicType2018;
    }

    /**
     * Gets the affluenceCode.
     * @return The affluenceCode.
     */
    public DatasetMetadata getAffluenceCode() {
        return this.affluenceCode;
    }

    /**
     * Sets the affluenceCode.
     * @param affluenceCode The affluenceCode.
     */
    public void setAffluenceCode(final DatasetMetadata affluenceCode) {
        this.affluenceCode = affluenceCode;
    }

    /**
     * Gets the affluenceDescription.
     * @return The affluenceDescription.
     */
    public DatasetMetadata getAffluenceDescription() {
        return this.affluenceDescription;
    }

    /**
     * Sets the affluenceDescription.
     * @param affluenceDescription The affluenceDescription.
     */
    public void setAffluenceDescription(final DatasetMetadata affluenceDescription) {
        this.affluenceDescription = affluenceDescription;
    }

    /**
     * Gets the adultsAtAddressCode.
     * @return The adultsAtAddressCode.
     */
    public DatasetMetadata getAdultsAtAddressCode() {
        return this.adultsAtAddressCode;
    }

    /**
     * Sets the adultsAtAddressCode.
     * @param adultsAtAddressCode The adultsAtAddressCode.
     */
    public void setAdultsAtAddressCode(final DatasetMetadata adultsAtAddressCode) {
        this.adultsAtAddressCode = adultsAtAddressCode;
    }

    /**
     * Gets the adultsAtAddressDescription.
     * @return The adultsAtAddressDescription.
     */
    public DatasetMetadata getAdultsAtAddressDescription() {
        return this.adultsAtAddressDescription;
    }

    /**
     * Sets the adultsAtAddressDescription.
     * @param adultsAtAddressDescription The adultsAtAddressDescription.
     */
    public void setAdultsAtAddressDescription(final DatasetMetadata adultsAtAddressDescription) {
        this.adultsAtAddressDescription = adultsAtAddressDescription;
    }

    /**
     * Gets the childrenAtAddressCode010Years.
     * @return The childrenAtAddressCode010Years.
     */
    public DatasetMetadata getChildrenAtAddressCode010Years() {
        return this.childrenAtAddressCode010Years;
    }

    /**
     * Sets the childrenAtAddressCode010Years.
     * @param childrenAtAddressCode010Years The childrenAtAddressCode010Years.
     */
    public void setChildrenAtAddressCode010Years(final DatasetMetadata childrenAtAddressCode010Years) {
        this.childrenAtAddressCode010Years = childrenAtAddressCode010Years;
    }

    /**
     * Gets the childrenAtAddressDescription010Years.
     * @return The childrenAtAddressDescription010Years.
     */
    public DatasetMetadata getChildrenAtAddressDescription010Years() {
        return this.childrenAtAddressDescription010Years;
    }

    /**
     * Sets the childrenAtAddressDescription010Years.
     * @param childrenAtAddressDescription010Years The childrenAtAddressDescription010Years.
     */
    public void setChildrenAtAddressDescription010Years(final DatasetMetadata childrenAtAddressDescription010Years) {
        this.childrenAtAddressDescription010Years = childrenAtAddressDescription010Years;
    }

    /**
     * Gets the childrenAtAddressCode1118Years.
     * @return The childrenAtAddressCode1118Years.
     */
    public DatasetMetadata getChildrenAtAddressCode1118Years() {
        return this.childrenAtAddressCode1118Years;
    }

    /**
     * Sets the childrenAtAddressCode1118Years.
     * @param childrenAtAddressCode1118Years The childrenAtAddressCode1118Years.
     */
    public void setChildrenAtAddressCode1118Years(final DatasetMetadata childrenAtAddressCode1118Years) {
        this.childrenAtAddressCode1118Years = childrenAtAddressCode1118Years;
    }

    /**
     * Gets the childrenAtAddressDescription1118Years.
     * @return The childrenAtAddressDescription1118Years.
     */
    public DatasetMetadata getChildrenAtAddressDescription1118Years() {
        return this.childrenAtAddressDescription1118Years;
    }

    /**
     * Sets the childrenAtAddressDescription1118Years.
     * @param childrenAtAddressDescription1118Years The childrenAtAddressDescription1118Years.
     */
    public void setChildrenAtAddressDescription1118Years(final DatasetMetadata childrenAtAddressDescription1118Years) {
        this.childrenAtAddressDescription1118Years = childrenAtAddressDescription1118Years;
    }

    /**
     * Gets the creditDemandCode.
     * @return The creditDemandCode.
     */
    public DatasetMetadata getCreditDemandCode() {
        return this.creditDemandCode;
    }

    /**
     * Sets the creditDemandCode.
     * @param creditDemandCode The creditDemandCode.
     */
    public void setCreditDemandCode(final DatasetMetadata creditDemandCode) {
        this.creditDemandCode = creditDemandCode;
    }

    /**
     * Gets the creditDemandDescription.
     * @return The creditDemandDescription.
     */
    public DatasetMetadata getCreditDemandDescription() {
        return this.creditDemandDescription;
    }

    /**
     * Sets the creditDemandDescription.
     * @param creditDemandDescription The creditDemandDescription.
     */
    public void setCreditDemandDescription(final DatasetMetadata creditDemandDescription) {
        this.creditDemandDescription = creditDemandDescription;
    }

    /**
     * Gets the householdIncomeCode.
     * @return The householdIncomeCode.
     */
    public DatasetMetadata getHouseholdIncomeCode() {
        return this.householdIncomeCode;
    }

    /**
     * Sets the householdIncomeCode.
     * @param householdIncomeCode The householdIncomeCode.
     */
    public void setHouseholdIncomeCode(final DatasetMetadata householdIncomeCode) {
        this.householdIncomeCode = householdIncomeCode;
    }

    /**
     * Gets the householdIncomeDescription.
     * @return The householdIncomeDescription.
     */
    public DatasetMetadata getHouseholdIncomeDescription() {
        return this.householdIncomeDescription;
    }

    /**
     * Sets the householdIncomeDescription.
     * @param householdIncomeDescription The householdIncomeDescription.
     */
    public void setHouseholdIncomeDescription(final DatasetMetadata householdIncomeDescription) {
        this.householdIncomeDescription = householdIncomeDescription;
    }

    /**
     * Gets the householdCompositionCode.
     * @return The householdCompositionCode.
     */
    public DatasetMetadata getHouseholdCompositionCode() {
        return this.householdCompositionCode;
    }

    /**
     * Sets the householdCompositionCode.
     * @param householdCompositionCode The householdCompositionCode.
     */
    public void setHouseholdCompositionCode(final DatasetMetadata householdCompositionCode) {
        this.householdCompositionCode = householdCompositionCode;
    }

    /**
     * Gets the householdCompositionDescription.
     * @return The householdCompositionDescription.
     */
    public DatasetMetadata getHouseholdCompositionDescription() {
        return this.householdCompositionDescription;
    }

    /**
     * Sets the householdCompositionDescription.
     * @param householdCompositionDescription The householdCompositionDescription.
     */
    public void setHouseholdCompositionDescription(final DatasetMetadata householdCompositionDescription) {
        this.householdCompositionDescription = householdCompositionDescription;
    }

    /**
     * Gets the headOfHouseholdAgeCode.
     * @return The headOfHouseholdAgeCode.
     */
    public DatasetMetadata getHeadOfHouseholdAgeCode() {
        return this.headOfHouseholdAgeCode;
    }

    /**
     * Sets the headOfHouseholdAgeCode.
     * @param headOfHouseholdAgeCode The headOfHouseholdAgeCode.
     */
    public void setHeadOfHouseholdAgeCode(final DatasetMetadata headOfHouseholdAgeCode) {
        this.headOfHouseholdAgeCode = headOfHouseholdAgeCode;
    }

    /**
     * Gets the headOfHouseholdAgeDescription.
     * @return The headOfHouseholdAgeDescription.
     */
    public DatasetMetadata getHeadOfHouseholdAgeDescription() {
        return this.headOfHouseholdAgeDescription;
    }

    /**
     * Sets the headOfHouseholdAgeDescription.
     * @param headOfHouseholdAgeDescription The headOfHouseholdAgeDescription.
     */
    public void setHeadOfHouseholdAgeDescription(final DatasetMetadata headOfHouseholdAgeDescription) {
        this.headOfHouseholdAgeDescription = headOfHouseholdAgeDescription;
    }

    /**
     * Gets the lifestageCode.
     * @return The lifestageCode.
     */
    public DatasetMetadata getLifestageCode() {
        return this.lifestageCode;
    }

    /**
     * Sets the lifestageCode.
     * @param lifestageCode The lifestageCode.
     */
    public void setLifestageCode(final DatasetMetadata lifestageCode) {
        this.lifestageCode = lifestageCode;
    }

    /**
     * Gets the lifestageDescription.
     * @return The lifestageDescription.
     */
    public DatasetMetadata getLifestageDescription() {
        return this.lifestageDescription;
    }

    /**
     * Sets the lifestageDescription.
     * @param lifestageDescription The lifestageDescription.
     */
    public void setLifestageDescription(final DatasetMetadata lifestageDescription) {
        this.lifestageDescription = lifestageDescription;
    }

    /**
     * Gets the lengthOfResidenceCode.
     * @return The lengthOfResidenceCode.
     */
    public DatasetMetadata getLengthOfResidenceCode() {
        return this.lengthOfResidenceCode;
    }

    /**
     * Sets the lengthOfResidenceCode.
     * @param lengthOfResidenceCode The lengthOfResidenceCode.
     */
    public void setLengthOfResidenceCode(final DatasetMetadata lengthOfResidenceCode) {
        this.lengthOfResidenceCode = lengthOfResidenceCode;
    }

    /**
     * Gets the lengthOfResidenceDescription.
     * @return The lengthOfResidenceDescription.
     */
    public DatasetMetadata getLengthOfResidenceDescription() {
        return this.lengthOfResidenceDescription;
    }

    /**
     * Sets the lengthOfResidenceDescription.
     * @param lengthOfResidenceDescription The lengthOfResidenceDescription.
     */
    public void setLengthOfResidenceDescription(final DatasetMetadata lengthOfResidenceDescription) {
        this.lengthOfResidenceDescription = lengthOfResidenceDescription;
    }

    /**
     * Gets the riskInsightCode.
     * @return The riskInsightCode.
     */
    public DatasetMetadata getRiskInsightCode() {
        return this.riskInsightCode;
    }

    /**
     * Sets the riskInsightCode.
     * @param riskInsightCode The riskInsightCode.
     */
    public void setRiskInsightCode(final DatasetMetadata riskInsightCode) {
        this.riskInsightCode = riskInsightCode;
    }

    /**
     * Gets the riskInsightDescription.
     * @return The riskInsightDescription.
     */
    public DatasetMetadata getRiskInsightDescription() {
        return this.riskInsightDescription;
    }

    /**
     * Sets the riskInsightDescription.
     * @param riskInsightDescription The riskInsightDescription.
     */
    public void setRiskInsightDescription(final DatasetMetadata riskInsightDescription) {
        this.riskInsightDescription = riskInsightDescription;
    }

    /**
     * Gets the mosaicGroup.
     * @return The mosaicGroup.
     */
    public DatasetMetadata getMosaicGroup() {
        return this.mosaicGroup;
    }

    /**
     * Sets the mosaicGroup.
     * @param mosaicGroup The mosaicGroup.
     */
    public void setMosaicGroup(final DatasetMetadata mosaicGroup) {
        this.mosaicGroup = mosaicGroup;
    }

    /**
     * Gets the mosaicType.
     * @return The mosaicType.
     */
    public DatasetMetadata getMosaicType() {
        return this.mosaicType;
    }

    /**
     * Sets the mosaicType.
     * @param mosaicType The mosaicType.
     */
    public void setMosaicType(final DatasetMetadata mosaicType) {
        this.mosaicType = mosaicType;
    }

    /**
     * Gets the mosaicGroup2015.
     * @return The mosaicGroup2015.
     */
    public DatasetMetadata getMosaicGroup2015() {
        return this.mosaicGroup2015;
    }

    /**
     * Sets the mosaicGroup2015.
     * @param mosaicGroup2015 The mosaicGroup2015.
     */
    public void setMosaicGroup2015(final DatasetMetadata mosaicGroup2015) {
        this.mosaicGroup2015 = mosaicGroup2015;
    }

    /**
     * Gets the mosaicType2015.
     * @return The mosaicType2015.
     */
    public DatasetMetadata getMosaicType2015() {
        return this.mosaicType2015;
    }

    /**
     * Sets the mosaicType2015.
     * @param mosaicType2015 The mosaicType2015.
     */
    public void setMosaicType2015(final DatasetMetadata mosaicType2015) {
        this.mosaicType2015 = mosaicType2015;
    }
}

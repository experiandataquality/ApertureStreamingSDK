package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the  New Zealand ConsumerView Household dataset.
 * */
public final class EnrichmentDatasetNzlCVHousehold {
    /**
     * A code which estimates the age category of the person likely to be the head of the household.
     * Example: 10
     */
    @SerializedName("head_of_household_age")
    private String headOfHouseholdAge;

    /**
     * TA code which represents the likelihood of the presence of children in the household.
     * Example: 4
     */
    @SerializedName("children_at_address")
    private String childrenAtAddress;

    /**
     * A code which indicates the composition of the household.
     * Example: 3
     */
    @SerializedName("household_composition")
    private String householdComposition;

    /**
     * A code which indicates the life stage of the head of household.
     * Example: 10
     */
    @SerializedName("head_of_household_lifestage")
    private String headOfHouseholdLifeStage;

    /**
     * A code which estimates the number of adults (people aged 18+) living in the household.
     * Example: 2
     */
    @SerializedName("adults_at_address")
    private String adultAtAddress;

    /**
     * A code that appends the mosaic group for the searched address. Mosaic classifies all NZ households into nine Groups and 34 Types.
     * Example: G
     */
    @SerializedName("mosaic_group")
    private String mosaicGroup;

    /**
     * A code that appends the mosaic type for the searched address. Mosaic classifies all NZ households into nine Groups and 34 Types.
     * Example: G25
     */
    @SerializedName("mosaic_type_group")
    private String mosaicTypeGroup;

    /**
     * A code that appends the mosaic segment code for the searched address. MosaicSegments offer the next level of discrimination from Mosaic Types, with 110 Segments available.
     * Example: 25_2
     */
    @SerializedName("mosaic_segment")
    private String mosaicSegment;

    /**
     * Gets the front of property head of household age.
     * @return The front of property head of household age.
     * */
    public String getHeadOfHouseholdAge() {
        return this.headOfHouseholdAge;
    }

    /**
     * Sets the front of property head of household age.
     * @param headOfHouseholdAge The front of property head of household age.
     */
    public void setHeadOfHouseholdAge(final String headOfHouseholdAge) {
        this.headOfHouseholdAge = headOfHouseholdAge;
    }

    /**
     * Gets the front of property children at address.
     * @return The front of property children at address.
     * */
    public String getChildrenAtAddress() {
        return this.childrenAtAddress;
    }

    /**
     * Sets the front of property children at address.
     * @param childrenAtAddress The front of property children at address.
     */
    public void setChildrenAtAddress(final String childrenAtAddress) {
        this.childrenAtAddress = childrenAtAddress;
    }

    /**
     * Gets the front of property house hold composition.
     * @return The front of property house hold composition.
     * */
    public String getHouseholdComposition() {
        return this.householdComposition;
    }

    /**
     * Sets the front of property house hold composition.
     * @param householdComposition The front of property house hold composition.
     */
    public void setHouseholdComposition(final String householdComposition) {
        this.householdComposition = householdComposition;
    }

    /**
     * Gets the front of property head of household life stage.
     * @return The front of property head of household life stage.
     * */
    public String getHeadOfHouseholdLifeStage() {
        return this.headOfHouseholdLifeStage;
    }

    /**
     * Sets the front of property head of household life stage.
     * @param headOfHouseholdLifeStage The front of property head of household life stage.
     */
    public void setHeadOfHouseholdLifeStage(final String headOfHouseholdLifeStage) {
        this.headOfHouseholdLifeStage = headOfHouseholdLifeStage;
    }

    /**
     * Gets the front of property adult at address.
     * @return The front of property adult at address.
     * */
    public String getAdultAtAddress() {
        return this.adultAtAddress;
    }

    /**
     * Sets the front of property adult at address.
     * @param adultAtAddress The front of property adult at address.
     */
    public void setAdultAtAddress(final String adultAtAddress) {
        this.adultAtAddress = adultAtAddress;
    }

    /**
     * Gets the front of property mosaic group.
     * @return The front of property mosaic group.
     * */
    public String getMosaicGroup() {
        return this.mosaicGroup;
    }

    /**
     * Sets the front of property mosaic group.
     * @param mosaicGroup The front of property mosaic group.
     */
    public void setMosaicGroup(final String mosaicGroup) {
        this.mosaicGroup = mosaicGroup;
    }

    /**
     * Gets the front of property mosaic type group.
     * @return The front of property mosaic type group.
     * */
    public String getMosaicTypeGroup() {
        return this.mosaicTypeGroup;
    }

    /**
     * Sets the front of property mosaic type group.
     * @param mosaicTypeGroup The front of property mosaic type group.
     */
    public void setMosaicTypeGroup(final String mosaicTypeGroup) {
        this.mosaicTypeGroup = mosaicTypeGroup;
    }

    /**
     * Gets the front of property mosaic segment.
     * @return The front of property mosaic segment.
     * */
    public String getMosaicSegment() {
        return this.mosaicSegment;
    }

    /**
     * Sets the front of property mosaic segment.
     * @param mosaicSegment The front of property mosaic segment.
     */
    public void setMosaicSegment(final String mosaicSegment) {
        this.mosaicSegment = mosaicSegment;
    }
}
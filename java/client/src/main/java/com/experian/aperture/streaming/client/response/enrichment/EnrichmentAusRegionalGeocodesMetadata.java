package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the AUS Regional Geocodes dataset.
 * */
public final class EnrichmentAusRegionalGeocodesMetadata {
    /**
     * The latitude.
     * Example: -37.90471923
     */
    @SerializedName("latitude")
    private DatasetMetadata latitude;

    /**
     * The longitude.
     * Example: 144.99818990
     * */
    @SerializedName("longitude")
    private DatasetMetadata longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: building
     * */
    @SerializedName("match_level")
    private DatasetMetadata matchLevel;

    /**
     * Unique 11-digit identifier allocated to each Mesh Block.
     * Example: 20045090000
     */
    @SerializedName("meshblock")
    private DatasetMetadata meshblock;

    /**
     * The 7 digit SA1 code.
     * Example: 2116938
     */
    @SerializedName("sa1")
    private DatasetMetadata sa1;

    /**
     * The Local Government Area code.
     * Example: 20910
     */
    @SerializedName("lga_code")
    private DatasetMetadata lgaCode;

    /**
     * The Local Government Area name.
     * Example: Bayside (C)
     */
    @SerializedName("lga_name")
    private DatasetMetadata lgaName;

    /**
     * Sets the latitude.
     * @param latitude The latitude.
     * */
    public void setLatitude(final DatasetMetadata latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the latitude.
     * @return The latitude.
     * */
    public DatasetMetadata getLatitude() {
        return this.latitude;
    }

    /**
     * Sets the longitude.
     * @param longitude The longitude.
     * */
    public void setLongitude(final DatasetMetadata longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the longitude.
     * @return The longitude.
     * */
    public DatasetMetadata getLongitude() {
        return this.longitude;
    }

    /**
     * Sets the match level.
     * @param matchLevel The matchLevel.
     * */
    public void setMatchLevel(final DatasetMetadata matchLevel) {
        this.matchLevel = matchLevel;
    }

    /**
     * Gets the match level.
     * @return The match level.
     * */
    public DatasetMetadata getMatchLevel() {
        return this.matchLevel;
    }

    /**
     * Gets the meshblock.
     * @return The meshblock.
     */
    public DatasetMetadata getMeshblock() {
        return this.meshblock;
    }

    /**
     * Sets the meshblock.
     * @param meshblock The meshblock.
     */
    public void setMeshblock(final DatasetMetadata meshblock) {
        this.meshblock = meshblock;
    }

    /**
     * Gets the sa1.
     * @return The sa1.
     */
    public DatasetMetadata getSa1() {
        return this.sa1;
    }

    /**
     * Sets the sa1.
     * @param sa1 The sa1.
     */
    public void setSa1(final DatasetMetadata sa1) {
        this.sa1 = sa1;
    }

    /**
     * Gets the LGA code.
     * @return The LGA code.
     */
    public DatasetMetadata getLgaCode() {
        return this.lgaCode;
    }

    /**
     * Sets the LGA code.
     * @param lgaCode The LGA code.
     */
    public void setLgaCode(final DatasetMetadata lgaCode) {
        this.lgaCode = lgaCode;
    }

    /**
     * Gets the LGA name.
     * @return The LGA name.
     */
    public DatasetMetadata getLgaName() {
        return this.lgaName;
    }

    /**
     * Sets the LGA name.
     * @param lgaName The LGA name.
     */
    public void setLgaName(final DatasetMetadata lgaName) {
        this.lgaName = lgaName;
    }
}
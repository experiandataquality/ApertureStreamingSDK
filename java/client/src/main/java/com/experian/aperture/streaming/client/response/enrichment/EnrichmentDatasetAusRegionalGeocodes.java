package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the AUS Regional Geocodes dataset.
 * */
public final class EnrichmentDatasetAusRegionalGeocodes {
    /**
     * The latitude.
     * Example: -37.90471923
     * */
    @SerializedName("latitude")
    private Double latitude;

    /**
     * The longitude.
     * Example: 144.99818990
     * */
    @SerializedName("longitude")
    private Double longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: building
     * */
    @SerializedName("match_level")
    private String matchLevel;

    /**
     * Unique 11-digit identifier allocated to each Mesh Block.
     * Example: 20045090000
     */
    @SerializedName("meshblock")
    private String meshblock;

    /**
     * The 7 digit SA1 code.
     * Example: 2116938
     */
    @SerializedName("sa1")
    private String sa1;

    /**
     * The Local Government Area code.
     * Example: 20910
     */
    @SerializedName("lga_code")
    private String lgaCode;

    /**
     * The Local Government Area name.
     * Example: Bayside (C)
     */
    @SerializedName("lga_name")
    private String lgaName;

    /**
     * Sets the latitude.
     * @param latitude The latitude.
     * */
    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the latitude.
     * @return The latitude.
     * */
    public Double getLatitude() {
        return this.latitude;
    }

    /**
     * Sets the longitude.
     * @param longitude The longitude.
     * */
    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the longitude.
     * @return The longitude.
     * */
    public Double getLongitude() {
        return this.longitude;
    }

    /**
     * Sets the matchLevel.
     * @param matchLevel The match level.
     * */
    public void setMatchLevel(final String matchLevel) {
        this.matchLevel = matchLevel;
    }

    /**
     * Gets the match level.
     * @return The match level.
     * */
    public String getMatchLevel() {
        return this.matchLevel;
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
     * Gets the LGA code.
     * @return The LGA code.
     */
    public String getLgaCode() {
        return this.lgaCode;
    }

    /**
     * Sets the LGA code.
     * @param lgaCode The LGA code.
     */
    public void setLgaCode(final String lgaCode) {
        this.lgaCode = lgaCode;
    }

    /**
     * Gets the LGA name.
     * @return The LGA name.
     */
    public String getLgaName() {
        return this.lgaName;
    }

    /**
     * Sets the LGA name.
     * @param lgaName The LGA name.
     */
    public void setLgaName(final String lgaName) {
        this.lgaName = lgaName;
    }
}
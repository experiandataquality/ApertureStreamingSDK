package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the Uk Location Complete dataset.
 * */
public final class EnrichmentDatasetUkLocationComplete {
    /**
     * The latitude.
     * Example: 52.941300
     * */
    @SerializedName("latitude")
    private Double latitude;

    /**
     * The longitude.
     * Example: 1.163120
     * */
    @SerializedName("longitude")
    private Double longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: Premises
     * */
    @SerializedName("match_level")
    private String matchLevel;

    /**
     *  Specifies the UDPRN for the specified address.
     * */
    @SerializedName("udprn")
    private String udprn;

    /**
     *  Specifies the UPRN for the specified address.
     * */
    @SerializedName("uprn")
    private String uprn;

    /**
     * The X coordinate.
     * */
    @SerializedName("x_coordinate")
    private Double xCoordinate;

    /**
     * The Y coordinate.
     * */
    @SerializedName("y_coordinate")
    private Double yCoordinate;

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
     * Sets the x coordinate.
     * @param xCoordinate The x coordinate.
     * */
    public void setXCoordinate(final double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets the x coordinate.
     * @return The x coordinate.
     * */
    public Double getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Sets the y coordinate.
     * @param yCoordinate The y coordinate.
     * */
    public void setYCoordinate(final double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Gets the y coordinate.
     * @return The y coordinate.
     * */
    public Double getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Sets the UDPRN.
     * @param udprn The UDPRN.
     * */
    public void setUdprn(final String udprn) {
        this.udprn = udprn;
    }

    /**
     * Gets the UDPRN.
     * @return The UDPRN.
     * */
    public String getUdprn() {
        return this.udprn;
    }

    /**
     * Sets the UPRN.
     * @param uprn The UPRN.
     * */
    public void setUprn(final String uprn) {
        this.uprn = uprn;
    }

    /**
     * Gets the UPRN.
     * @return The UPRN.
     * */
    public String getUprn() {
        return this.uprn;
    }
}

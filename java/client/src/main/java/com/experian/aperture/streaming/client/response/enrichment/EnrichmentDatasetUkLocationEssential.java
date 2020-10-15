package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the UK Location Essential dataset.
 * */
public final class EnrichmentDatasetUkLocationEssential {
    /**
     * The latitude.
     * Example: 51.5011234
     * */
    @SerializedName("latitude")
    private Double latitude;

    /**
     * The longitude.
     * Example: -0.1041234
     * */
    @SerializedName("longitude")
    private Double longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: Building
     * */
    @SerializedName("match_level")
    private String matchLevel;

    /**
     * The UDPRN.
     * Example: 55244256
     * */
    @SerializedName("udprn")
    private String udprn;

    /**
     * The UPRN.
     * Example: 010091977422
     * */
    @SerializedName("uprn")
    private String uprn;

    /**
     * The X Coordinate.
     * Example: 531677.95
     * */
    @SerializedName("x_coordinate")
    private Double xCoordinate;

    /**
     * The Y Coordinate.
     * Example: 179757.59
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

    /**
     * Sets the x coordinate.
     * @param xCoordinate The x coordinate.
     * */
    public void setXCoordinate(final Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets the x coordinate.
     * @return The x coordinate.
     * */
    public Double getxCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Sets the y coordinate.
     * @param yCoordinate The y coordinate.
     * */
    public void setYCoordinate(final Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Gets the y coordinate.
     * @return The y coordinate.
     * */
    public Double getYCoordinate() {
        return this.yCoordinate;
    }
}

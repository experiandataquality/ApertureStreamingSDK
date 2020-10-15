package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the UK Location Essential dataset.
 * */
public final class EnrichmentUkLocationEssentialMetadata {
    /**
     * The latitude.
     * Example: 51.5011234
     */
    @SerializedName("latitude")
    private DatasetMetadata latitude;

    /**
     * The longitude.
     * Example: -0.1041234
     * */
    @SerializedName("longitude")
    private DatasetMetadata longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: Building
     * */
    @SerializedName("match_level")
    private DatasetMetadata matchLevel;

    /**
     * The UDPRN.
     * Example: 55244256
     * */
    @SerializedName("udprn")
    private DatasetMetadata udprn;

    /**
     * The UPRN.
     * Example: 010091977422
     * */
    @SerializedName("uprn")
    private DatasetMetadata uprn;

    /**
     * The x coordinate.
     * Example: 531677.95
     * */
    @SerializedName("x_coordinate")
    private DatasetMetadata xCoordinate;

    /**
     * The y coordinate.
     * Example: 179757.59
     * */
    @SerializedName("y_coordinate")
    private DatasetMetadata yCoordinate;

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
     * Sets the UDPRN.
     * @param udprn The UDPRN.
     * */
    public void setUdprn(final DatasetMetadata udprn) {
        this.udprn = udprn;
    }

    /**
     * Gets the UDPRN.
     * @return The UDPRN.
     * */
    public DatasetMetadata getUdprn() {
        return this.udprn;
    }

    /**
     * Sets the UPRN.
     * @param uprn The UPRN.
     * */
    public  void setUprn(final DatasetMetadata uprn) {
        this.uprn = uprn;
    }

    /**
     * Gets the UPRN.
     * @return The UPRN.
     * */
    public DatasetMetadata getUprn() {
        return this.uprn;
    }

    /**
     * Sets the x coordinate.
     * @param xCoordinate The x coordinate.
     * */
    public void setXCoordinate(final DatasetMetadata xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets the x coordinate.
     * @return The x coordinate.
     * */
    public DatasetMetadata getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Sets the y coordinate.
     * @param yCoordinate The y coordinate.
     * */
    public void setYCoordinate(final DatasetMetadata yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Gets the y coordinate.
     * @return The y coordinate.
     * */
    public DatasetMetadata getYCoordinate() {
        return this.yCoordinate;
    }
}

package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Attribute-level metadata for the Geocodes dataset.
 * */
public final class EnrichmentGeocodesMetadata {
    /**
     * The latitude.
     * Example: 52.941300
     */
    @SerializedName("latitude")
    private DatasetMetadata latitude;

    /**
     * The longitude.
     * Example: -1.163120
     * */
    @SerializedName("longitude")
    private DatasetMetadata longitude;

    /**
     * Specifies the accuracy of the coordinates for the specified address.
     * Example: Premises
     * */
    @SerializedName("match_level")
    private DatasetMetadata matchLevel;

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
}

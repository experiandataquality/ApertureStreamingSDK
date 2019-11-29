package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Enrichment attributes that can be returned, based on the Geocodes dataset.
 * */
public final class EnrichmentDatasetGeocode {
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
}

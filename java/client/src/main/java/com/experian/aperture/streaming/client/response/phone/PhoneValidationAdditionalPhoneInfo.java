package com.experian.aperture.streaming.client.response.phone;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata fields and values that can be returned, in addition to the main core information.
 */
public final class PhoneValidationAdditionalPhoneInfo {
    /**
     * The name of the MSISDN operator where the phone number was originally registered.
     * Examples: Sprint, EE Limited (TM).
     **/
    @SerializedName("original_operator_name")
    private String originalOperatorName;

    /**
     * The status of the network where the phone number was originally registered.
     * Examples: Available
     **/
    @SerializedName("original_network_status")
    private String originalNetworkStatus;

    /**
     * The Mobile Country Code (MCC) and Mobile Network Code (MNC) where the phone number was originally registered.
     * Examples: 310012
     **/
    @SerializedName("original_home_network_identity")
    private String originalHomeNetworkIdentity;

    /**
     * The international calling code of the country where the phone number was originally registered.
     * Examples: 1, 44, 61
     **/
    @SerializedName("original_country_prefix")
    private String originalCountryPrefix;

    /**
     * The name of the country where the phone number was originally registered.
     * Examples: United States of America, United Kingdom, Australia
     **/
    @SerializedName("original_country_name")
    private String originalCountryName;

    /**
     * The 3-letter ISO code of the country where the phone number was originally registered.
     * Examples: USA, GBR, AUS
     **/
    @SerializedName("original_country_iso")
    private String originalCountryIso;

    /**
     * The name of the MSISDN operator where the phone number is currently registered.
     * Examples: Verizon (Verizon Wireless), T-Mobile UK (EE)
     **/
    @SerializedName("operator_name")
    private String operatorName;

    /**
     * The status of the network where the phone number is currently registered.
     * Examples: Available
     **/
    @SerializedName("network_status")
    private String networkStatus;

    /**
     * The Mobile Country Code (MCC) and Mobile Network Code (MNC) where the phone number is currently registered.
     * Examples: 310012
     **/
    @SerializedName("home_network_identity")
    private String homeNetworkIdentity;

    /**
     * The international calling code of the country where the phone number is currently registered.
     * Examples: 1, 44, 61
     **/
    @SerializedName("country_prefix")
    private String countryPrefix;

    /**
     * The name of the country where the phone number is currently registered.
     * Examples: United States of America, United Kingdom, Australia.
     **/
    @SerializedName("country_name")
    private String countryName;

    /**
     * The 3-letter ISO code of the country where the phone number is currently registered.
     * Examples: USA, GBR, AUS
     **/
    @SerializedName("country_iso")
    private String countryIso;

    /**
     * Indicates whether the phone number is ported or not.
     * Examples: true
     **/
    @SerializedName("is_ported")
    private String isPorted;

    /**
     * The requested number of days to look back in the cache for this phone number.
     * Examples: 7
     **/
    @SerializedName("cache_value_days")
    private int cacheValueDays;

    /**
     * The last date this phone number was checked.
     * Examples: 2019-03-21
     **/
    @SerializedName("date_cached")
    private String dateCached;

    public String getOriginalOperatorName() {
        return this.originalOperatorName;
    }

    public void setOriginalOperatorName(final String originalOperatorName) {
        this.originalOperatorName = originalOperatorName;
    }

    public String getOriginalNetworkStatus() {
        return this.originalNetworkStatus;
    }

    public void setOriginalNetworkStatus(final String originalNetworkStatus) {
        this.originalNetworkStatus = originalNetworkStatus;
    }

    public String getOriginalHomeNetworkIdentity() {
        return this.originalHomeNetworkIdentity;
    }

    public void setOriginalHomeNetworkIdentity(final String originalHomeNetworkIdentity) {
        this.originalHomeNetworkIdentity = originalHomeNetworkIdentity;
    }

    public String getOriginalCountryPrefix() {
        return this.originalCountryPrefix;
    }

    public void setOriginalCountryPrefix(final String originalCountryPrefix) {
        this.originalCountryPrefix = originalCountryPrefix;
    }

    public String getOriginalCountryName() {
        return this.originalCountryName;
    }

    public void setOriginalCountryName(final String originalCountryName) {
        this.originalCountryName = originalCountryName;
    }

    public String getOriginalCountryIso() {
        return this.originalCountryIso;
    }

    public void setOriginalCountryIso(final String originalCountryIso) {
        this.originalCountryIso = originalCountryIso;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(final String operatorName) {
        this.operatorName = operatorName;
    }

    public String getNetworkStatus() {
        return this.networkStatus;
    }

    public void setNetworkStatus(final String networkStatus) {
        this.networkStatus = networkStatus;
    }

    public String getHomeNetworkIdentity() {
        return this.homeNetworkIdentity;
    }

    public void setHomeNetworkIdentity(final String homeNetworkIdentity) {
        this.homeNetworkIdentity = homeNetworkIdentity;
    }

    public String getCountryPrefix() {
        return this.countryPrefix;
    }

    public void setCountryPrefix(final String countryPrefix) {
        this.countryPrefix = countryPrefix;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getCountryIso() {
        return this.countryIso;
    }

    public void setCountryIso(final String countryIso) {
        this.countryIso = countryIso;
    }

    public String getIsPorted() {
        return this.isPorted;
    }

    public void setIsPorted(final String isPorted) {
        this.isPorted = isPorted;
    }

    public int getCacheValueDays() {
        return this.cacheValueDays;
    }

    public void setCacheValueDays(final int cacheValueDays) {
        this.cacheValueDays = cacheValueDays;
    }

    public String getDateCached() {
        return this.dateCached;
    }

    public void setDateCached(final String dateCached) {
        this.dateCached = dateCached;
    }
}
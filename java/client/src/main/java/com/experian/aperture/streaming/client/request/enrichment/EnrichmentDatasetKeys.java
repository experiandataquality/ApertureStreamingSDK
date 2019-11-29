package com.experian.aperture.streaming.client.request.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * Keys you can use to search datasets.
 */
public final class EnrichmentDatasetKeys {
    /**
     * Unique Experian-assigned person identifier.
     * Example: 100000047
     */
    @SerializedName("pin")
    private String pin;

    /**
     * The consumer's email address.
     * Example: sample@example.com
     */
    @SerializedName("email_address")
    private String emailAddress;

    /**
     * The consumer's cell phone number.
     * Example: 7123456789
     */
    @SerializedName("mobile")
    private String mobile;

    /**
     * Unique 8-digit identifier allocated to each address maintained in Australia Post’s National Address File.
     * Example: 31176490
     */
    @SerializedName("dpid")
    private String dpid;

    /**
     * Unique 14-character alphanumeric persistent identifier of the address record.
     * An additional "mail_suppresion" attribute will be returned if the address is suppressed
     * and should not be contacted.
     * Example: GAVIC420630433
     */
    @SerializedName("gnaf_pid")
    private String gnafPid;

    /**
     * Unique Experian-assigned household identifier.
     * Example: 987654326
     */
    @SerializedName("hin")
    private String hin;

    /**
     * The postal code or zip code of the address.
     * Example: 7140
     */
    @SerializedName("postcode")
    private String postcode;

    /**
     * A unique Experian identifier.
     * Example: aWQ9fDEgQXVkcmV5IFphcHAgRHJpdmV8SHVkc29ufEplcnNleSBDaXR5LCBOSiAwNzMwNX5mb3JtYXRJZD0xMjM0NX5RTD05fmdlbz0w
     * */
    @SerializedName("global_address_key")
    private String globalAddressKey;

    /**
     * Gets the pin.
     * @return The pin.
     */
    public String getPin() {
        return this.pin;
    }

    /**
     * Sets the pin.
     * @param pin The pin.
     */
    public void setPin(final String pin) {
        this.pin = pin;
    }

    /**
     * Gets the emailAddress.
     * @return The emailAddress.
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Sets the emailAddress.
     * @param emailAddress The emailAddress.
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the mobile.
     * @return The mobile.
     */

    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile.
     * @param mobile The mobile.
     */
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the dpid.
     * @return The dpid.
     */
    public String getDpid() {
        return this.dpid;
    }

    /**
     * Sets the dpid.
     * @param dpid The dpid.
     */
    public void setDpid(final String dpid) {
        this.dpid = dpid;
    }

    /**
     * Gets the gnafPid.
     * @return The gnafPid.
     */
    public String getGnafPid() {
        return this.gnafPid;
    }

    /**
     * Sets the gnafPid.
     * @param gnafPid The gnafPid.
     */
    public void setGnafPid(final String gnafPid) {
        this.gnafPid = gnafPid;
    }

    /**
     * Gets the hin.
     * @return The hin.
     */
    public String getHin() {
        return this.hin;
    }

    /**
     * Sets the hin.
     * @param hin The hin.
     */
    public void setHin(final String hin) {
        this.hin = hin;
    }

    /**
     * Gets the postcode.
     * @return The postcode.
     */
    public String getPostcode() {
        return this.postcode;
    }

    /**
     * Sets the postcode.
     * @param postcode The postcode.
     */
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets the global address key.
     * @return The global address key.
     * */
    public String getGlobalAddressKey() {
        return this.globalAddressKey;
    }

    /**
     * Sets the global address key.
     * @param globalAddressKey The global address key.
     * */
    public void setGlobalAddressKey(final String globalAddressKey) {
        this.globalAddressKey = globalAddressKey;
    }
}

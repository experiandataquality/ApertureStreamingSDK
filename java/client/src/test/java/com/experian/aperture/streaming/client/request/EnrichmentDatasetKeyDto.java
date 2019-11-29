package com.experian.aperture.streaming.client.request;

final class EnrichmentDatasetKeyDto {
    private String dpid;
    private String postcode;
    private String pin;
    private String globalAddressKey;
    private String emailAddress;
    private String mobile;
    private String gnafPid;
    private String hin;

    String getDpid() {
        return dpid;
    }

    void setDpid(final String dpid) {
        this.dpid = dpid;
    }

    String getPostcode() {
        return postcode;
    }

    void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    String getPin() {
        return pin;
    }

    void setPin(final String pin) {
        this.pin = pin;
    }

    String getGlobalAddressKey() {
        return globalAddressKey;
    }

    void setGlobalAddressKey(final String globalAddressKey) {
        this.globalAddressKey = globalAddressKey;
    }

    String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    String getMobile() {
        return mobile;
    }

    void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    String getGnafPid() {
        return gnafPid;
    }

    void setGnafPid(final String gnafPid) {
        this.gnafPid = gnafPid;
    }

    String getHin() {
        return hin;
    }

    void setHin(final String hin) {
        this.hin = hin;
    }
}
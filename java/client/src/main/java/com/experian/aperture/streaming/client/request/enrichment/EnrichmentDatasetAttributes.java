package com.experian.aperture.streaming.client.request.enrichment;

        import com.google.gson.annotations.SerializedName;
        import java.util.List;

/**
 * Datasets and their specific attributes.
 */
public final class EnrichmentDatasetAttributes {
    /**
     * The dataset named Australia ConsumerView Person Data and its associated attributes.
     */
    @SerializedName("aus_cv_person")
    private List<AusCVPerson> ausCVPerson;

    /**
     * The dataset named Australia ConsumerView Household Data and its associated attributes.
     */
    @SerializedName("aus_cv_household")
    private List<AusCVHousehold> ausCVHousehold;

    /**
     * The dataset named Australia ConsumerView Postcode Data and its associated attributes.
     */
    @SerializedName("aus_cv_postcode")
    private List<AusCVPostcode> ausCVPostcode;

    /**
     * The list of Gecodes Data.
     */
    @SerializedName("geocodes")
    private List<Geocodes> geocodes;

    /**
     * The list of USA Regional Gecodes Data.
     */
    @SerializedName("usa_regional_geocodes")
    private List<UsaRegionalGeocodes> usaRegionalGeocodes;

    /**
     * The list of AUS Regional Gecodes Data.
     */
    @SerializedName("aus_regional_geocodes")
    private List<AusRegionalGeocodes> ausRegionalGeocodes;

    /**
     * The list of UK Location Essential Data.
     */
    @SerializedName("uk_location_essential")
    private List<UkLocationEssential> ukLocationEssential;

    /**
     * The list of Uk Location Complete Data.
     */
    @SerializedName("uk_location_complete")
    private List<UkLocationComplete> ukLocationComplete;

    /**
     * The list of NZL Regional Geocodes Data.
     */
    @SerializedName("nzl_regional_geocodes")
    private List<NzlRegionalGeocodes> nzlRegionalGeocodes;

    /**
     * The dataset named New Zealand ConsumerView Household and its associated attributes.
     */
    @SerializedName("nzl_cv_household")
    private List<NzlCVHousehold> nzlCVHousehold;

    /**
     * Gets the ausCVPerson.
     * @return The ausCVPerson.
     */
    public List<AusCVPerson> getAusCVPerson() {
        return this.ausCVPerson;
    }

    /**
     * Sets the ausCVPerson.
     * @param ausCVPerson The ausCvPerson.
     */
    public void setAusCVPerson(final List<AusCVPerson> ausCVPerson) {
        this.ausCVPerson = ausCVPerson;
    }

    /**
     * Gets the ausCVHousehold.
     * @return The ausCVHousehold.
     */
    public List<AusCVHousehold> getAusCVHousehold() {
        return this.ausCVHousehold;
    }

    /**
     * Sets the ausCVHousehold.
     * @param ausCVHousehold The ausCvHousehold.
     */
    public void setAusCVHousehold(final List<AusCVHousehold> ausCVHousehold) {
        this.ausCVHousehold = ausCVHousehold;
    }

    /**
     * Gets the ausCVPostcode.
     * @return The ausCVPostcode.
     */
    public List<AusCVPostcode> getAusCVPostcode() {
        return this.ausCVPostcode;
    }

    /**
     * Sets the ausCVPostcode.
     * @param ausCVPostcode The ausCvPostcode.
     */
    public void setAusCVPostcode(final List<AusCVPostcode> ausCVPostcode) {
        this.ausCVPostcode = ausCVPostcode;
    }

    /**
     * Gets the list of geocodes.
     * @return The list of geocodes.
     * */
    public List<Geocodes> getGeocodes() {
        return this.geocodes;
    }

    /**
     * Sets the list of geocodes data.
     * @param geocodes The geocodes.
     * */
    public void setGeocodes(final List<Geocodes> geocodes) {
        this.geocodes = geocodes;
    }

    /**
     * Gets the list of USA regional geocodes.
     * @return The list of USA regional geocodes.
     * */
    public List<UsaRegionalGeocodes> getUsaRegionalGeocodes() {
        return this.usaRegionalGeocodes;
    }

    /**
     * Sets the list of USA regional geocodes data.
     * @param usaRegionalGeocodes The USA regional geocodes.
     * */
    public void setUsaRegionalGeocodes(final List<UsaRegionalGeocodes> usaRegionalGeocodes) {
        this.usaRegionalGeocodes = usaRegionalGeocodes;
    }

    /**
     * Gets the list of AUS regional geocodes.
     * @return The list of AUS regional geocodes.
     * */
    public List<AusRegionalGeocodes> getAusRegionalGeocodes() {
        return this.ausRegionalGeocodes;
    }

    /**
     * Sets the list of AUS regional geocodes data.
     * @param ausRegionalGeocodes The AUS regional geocodes.
     * */
    public void setAusRegionalGeocodes(final List<AusRegionalGeocodes> ausRegionalGeocodes) {
        this.ausRegionalGeocodes = ausRegionalGeocodes;
    }

    /**
     * Gets the list of UK Location Essential.
     * @return The list of UK Location Essential.
     * */
    public List<UkLocationEssential> getUkLocationEssential() {
        return this.ukLocationEssential;
    }

    /**
     * Sets the list of UK Location Essential data.
     * @param ukLocationEssential The UK Location Essential.
     * */
    public void setUkLocationEssential(final List<UkLocationEssential> ukLocationEssential) {
        this.ukLocationEssential = ukLocationEssential;
    }

    /**
     * Gets the ukLocationComplete.
     * @return The ukLocationComplete.
     */
    public List<UkLocationComplete> getUkLocationComplete() {
        return this.ukLocationComplete;
    }

    /**
     * Sets the ukLocationComplete.
     * @param ukLocationComplete The ukLocationComplete.
     */
    public void setUkLocationComplete(final List<UkLocationComplete> ukLocationComplete) {
        this.ukLocationComplete = ukLocationComplete;
    }

    /**
     * Gets the nzlRegionalGeocodes.
     * @return The nzlRegionalGeocodes.
     */
    public List<NzlRegionalGeocodes> getNzlRegionalGeocodes() {
        return this.nzlRegionalGeocodes;
    }

    /**
     * Sets the nzlRegionalGeocodes.
     * @param nzlRegionalGeocodes The nzlRegionalGeocodes.
     */
    public void setNzlRegionalGeocodes(final List<NzlRegionalGeocodes> nzlRegionalGeocodes) {
        this.nzlRegionalGeocodes = nzlRegionalGeocodes;
    }

    /**
     * Gets the list of nzlCVHousehold.
     * @return The nzlCVHousehold.
     * */
    public List<NzlCVHousehold> getNzlCVHousehold() {
        return this.nzlCVHousehold;
    }

    /**
     * Sets the list of nzlCvHousehold.
     * @param nzlCVHousehold The nzlCvHousehold.
     * */
    public void setNzlCVHousehold(final List<NzlCVHousehold> nzlCVHousehold) {
        this.nzlCVHousehold = nzlCVHousehold;
    }
}

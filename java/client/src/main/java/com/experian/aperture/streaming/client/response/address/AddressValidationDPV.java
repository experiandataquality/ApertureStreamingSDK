package com.experian.aperture.streaming.client.response.address;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * DPV information of the address.
 */
public final class AddressValidationDPV {
     /**
     * Indicates that the address is a private business that acts as a commercial mail-receiving agent for specific clients.
     **/
    @SerializedName("cmra_indicator")
    private String cmraIndicator;

    /**
     * The primary method used by the USPS to determine whether an address is considered deliverable.
     **/
    @SerializedName("dpv_indicator")
    private String dpvIndicator;

    /**
     * A combination of codes provided by USPS that denote the level of match, such as A1: ZIP4 not matched.
     **/
    @SerializedName("footnotes")
    private List<String> footnotes;

    /**
     * An address known to not receive mail deliveries (e.g. a house under construction).
     **/
    @SerializedName("no_stats_indicator")
    private String noStatsIndicator;

    /**
     * Indicates addresses known to be Post Office Box Street Addresses (PBSA).
     **/
    @SerializedName("pbsa_indicator")
    private String pbsaIndicator;

    /**
     * Applies to USA addresses only: a seed address is a non-existent address that will deactivate the DPV functionality. To activate it again, please visit the Self Service Portal.
     **/
    @SerializedName("seed_indicator")
    private String seedIndicator;

    /**
     * An address known to be unoccupied for over 90 days and therefore not receiving mail deliveries.
     **/
    @SerializedName("vacancy_indicator")
    private String vacancyIndicator;

    /**
     * Gets the cmraIndicator.
     * @return The cmraIndicator.
     */
    public String getCmraIndicator() {
        return cmraIndicator;
    }

    /**
     * Sets the cmraIndicator.
     * @param cmraIndicator The cmraIndicator.
     */
    public void setCmraIndicator(final String cmraIndicator) {
        this.cmraIndicator = cmraIndicator;
    }

    /**
     * Gets the dpvIndicator.
     * @return The dpvIndicator.
     */
    public String getDpvIndicator() {
        return dpvIndicator;
    }

    /**
     * Sets the dpvIndicator.
     * @param dpvIndicator The dpvIndicator.
     */
    public void setDpvIndicator(final String dpvIndicator) {
        this.dpvIndicator = dpvIndicator;
    }

    /**
     * Gets the footnotes.
     * @return The footnotes.
     */
    public List<String> getFootnotes() {
        return footnotes;
    }

    /**
     * Sets the footnotes.
     * @param footnotes The footnotes.
     */
    public void setFootnotes(final List<String> footnotes) {
        this.footnotes = footnotes;
    }

    /**
     * Gets the noStatsIndicator.
     * @return The noStatsIndicator.
     */
    public String getNoStatsIndicator() {
        return noStatsIndicator;
    }

    /**
     * Sets the noStatsIndicator.
     * @param noStatsIndicator The noStatsIndicator.
     */
    public void setNoStatsIndicator(final String noStatsIndicator) {
        this.noStatsIndicator = noStatsIndicator;
    }

    /**
     * Gets the pbsaIndicator.
     * @return The pbsaIndicator.
     */
    public String getPbsaIndicator() {
        return pbsaIndicator;
    }

    /**
     * Sets the pbsaIndicator.
     * @param pbsaIndicator The pbsaIndicator.
     */
    public void setPbsaIndicator(final String pbsaIndicator) {
        this.pbsaIndicator = pbsaIndicator;
    }

    /**
     * Gets the seedIndicator.
     * @return The seedIndicator.
     */
    public String getSeedIndicator() {
        return seedIndicator;
    }

    /**
     * Sets the seedIndicator.
     * @param seedIndicator The seedIndicator.
     */
    public void setSeedIndicator(final String seedIndicator) {
        this.seedIndicator = seedIndicator;
    }

    /**
     * Gets the vacancyIndicator.
     * @return The vacancyIndicator.
     */
    public String getVacancyIndicator() {
        return vacancyIndicator;
    }

    /**
     * Sets the vacancyIndicator.
     * @param vacancyIndicator The vacancyIndicator.
     */
    public void setVacancyIndicator(final String vacancyIndicator) {
        this.vacancyIndicator = vacancyIndicator;
    }
}

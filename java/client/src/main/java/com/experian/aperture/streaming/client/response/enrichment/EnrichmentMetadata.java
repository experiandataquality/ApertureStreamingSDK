package com.experian.aperture.streaming.client.response.enrichment;

import com.google.gson.annotations.SerializedName;

/**
 * The metadata model.
 */
public final class EnrichmentMetadata {
    /**
     * Ignore, currently not used.
     **/
    @SerializedName("code")
    private String code;

    /**
     * Ignore, currently not used.
     **/
    @SerializedName("message")
    private String message;

    /**
     * Ignore, currently not used.
     **/
    @SerializedName("detail")
    private String detail;

    /**
     * The dataset name and related attributes.
     **/
    @SerializedName("datasets")
    private EnrichmentMetadataDatasets datasets;

    /**
     * Gets the code.
     * @return The code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code.
     * @param code The code.
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * Gets the message.
     * @return The message.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message.
     * @param message The message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the detail.
     * @return The detail.
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * Sets the detail.
     * @param detail The detail.
     */
    public void setDetail(final String detail) {
        this.detail = detail;
    }

    /**
     * Gets the datasets.
     * @return The datasets.
     */
    public EnrichmentMetadataDatasets getDatasets() {
        return datasets;
    }

    /**
     * Sets the datasets.
     * @param datasets The datasets.
     */
    public void setDatasets(final EnrichmentMetadataDatasets datasets) {
        this.datasets = datasets;
    }
}

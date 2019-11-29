package com.experian.aperture.streaming.client.proxy;

import com.experian.aperture.streaming.client.Versions;
import com.google.gson.annotations.SerializedName;

/**
 * Base proxy model.
 */
public abstract class RequestProxyBase {
    @SerializedName("version")
    private Versions version;

    @SerializedName("reference_id")
    private String referenceId;

    @SerializedName("add_metadata")
    private boolean addMetadata;

    RequestProxyBase(final Versions version, final String referenceId, final boolean addMetadata) {
        this.version = version;
        this.referenceId = referenceId;
        this.addMetadata = addMetadata;
    }

    public Versions getVersion() {
        return this.version;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public boolean getAddMetadata() {
        return this.addMetadata;
    }
}
package com.experian.aperture.streaming.client.proxy;

import com.experian.aperture.streaming.client.Versions;
import com.experian.aperture.streaming.client.request.email.EmailValidationRequest;
import com.experian.aperture.streaming.client.options.email.EmailValidationOptions;
import com.google.gson.annotations.SerializedName;

/**
 * Proxy model for email validation request.
 */
public final class EmailValidationRequestProxy extends RequestProxyBase {
    @SerializedName("email")
    private String email;

    @SerializedName("timeout")
    private long timeout;

    public EmailValidationRequestProxy(final EmailValidationRequest request, final EmailValidationOptions options) {
        super(Versions.EMAIL_VALIDATION_REQUEST, request.getReferenceId(), options.getAddMetadata());
        this.email = request.getEmail();
        this.timeout = options.getTimeout().getSeconds();
    }

    public String getEmail() {
        return this.email;
    }

    public long getTimeout() {
        return this.timeout;
    }
}
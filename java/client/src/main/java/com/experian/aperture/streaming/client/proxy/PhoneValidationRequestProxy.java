package com.experian.aperture.streaming.client.proxy;

import com.experian.aperture.streaming.client.Versions;
import com.experian.aperture.streaming.client.request.phone.PhoneValidationRequest;
import com.experian.aperture.streaming.client.options.phone.PhoneValidationOptions;
import com.google.gson.annotations.SerializedName;

/**
 * Proxy model for phone validation request.
 */
public final class PhoneValidationRequestProxy extends RequestProxyBase {
    /**
     * The phone number submitted to be validated. Examples: 5026576033 or 0386221655.
     **/
    @SerializedName("number")
    private String number;

    /**
     * The type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
     * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
     */
    @SerializedName("output_format")
    private String outputFormat;

    /**
     * The number of days to look back in cache for the validation result for this phone number. If the result is cached, the response will be returned faster. Acceptable values from 0 (no cache) to 30. If not specified, the default value, 7, will be used.
     */
    @SerializedName("cache_value_days")
    private int cacheValueDays;

    @SerializedName("timeout")
    private long timeout;

    /**
     * The 3-letter ISO country code.
     **/
    @SerializedName("country_iso")
    private String countryIso;

    /**
     * Boolean value get ported date.
     */
    @SerializedName("get_ported_date")
    private boolean getPortedDate;

    public PhoneValidationRequestProxy(final PhoneValidationRequest request, final PhoneValidationOptions options) {
        super(Versions.PHONE_VALIDATION_REQUEST, request.getReferenceId(), options.getAddMetadata());
        this.number = request.getNumber();
        this.outputFormat = request.getOutputFormat();
        this.cacheValueDays = request.getCacheValueDays();
        this.countryIso = request.getCountryIso();
        this.timeout = options.getTimeout().getSeconds();
        this.getPortedDate = request.getGetPortedDate();
    }

    public String getNumber() {
        return this.number;
    }

    public String getOutputFormat() {
        return this.outputFormat;
    }

    public int getCacheValueDays() {
        return this.cacheValueDays;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getCountryIso() {
        return this.countryIso;
    }

    public boolean getGetPortedDate() {
        return this.getPortedDate;
    }
}
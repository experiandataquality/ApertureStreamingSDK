package com.experian.aperture.streaming.client.options.phone;

import com.experian.aperture.streaming.client.options.OptionsBase;

import java.time.Duration;

/**
 * The phone validation options.
 */
public final class PhoneValidationOptions extends OptionsBase {
    /**
     * The type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
     * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
     **/
    private String outputFormat;

    /**
     * The number of days to look back in cache for the validation result for this phone number. If the result is cached,
     * the response will be returned faster. Acceptable values from 0 (no cache) to 30. If not specified, the default value, 7, will be used.
     * Examples: 7.
     **/
    private int cacheValueDays;

    /**
     * Specifies to return additional metadata in response.
     */
    private boolean addMetadata;

    /**
     * The 3-letter ISO country code.
     */
    private String countryIso;

    /**
     * Boolean value get ported date.
     */
    private boolean getPortedDate;

    PhoneValidationOptions(final String outputFormat, final int cacheValueDays, final boolean addMetadata, final Duration timeout, final String countryIso, final  boolean getPortedDate) {
        super(timeout);
        this.outputFormat = outputFormat;
        this.cacheValueDays = cacheValueDays;
        this.addMetadata = addMetadata;
        this.countryIso = countryIso;
        this.getPortedDate = getPortedDate;
    }

    /**
     * Gets the type of phone number formatting to be returned.
     * @return The output format.
     **/
    public String getOutputFormat() {
        return this.outputFormat;
    }

    /**
     * Gets the number of days to look back in cache for the validation result for this phone number.
     * @return The cache value in days.
     **/
    public int getCacheValueDays() {
        return this.cacheValueDays;
    }

    /**
     * Gets the additional metadata option. An option that indicates
     * whether to return additional metadata in response.
     * @return The additional metadata option.
     */
    public boolean getAddMetadata() {
        return this.addMetadata;
    }

    /**
     * Gets the country Iso in 3 character length.
     * @return the 3-letter ISO country code.
     */
    public String getCountryIso() {
        return this.countryIso;
    }

    /**
     * Gets the get ported date.
     * @return boolean value.
     */
    public boolean getGetPortedDate() {
        return this.getPortedDate;
    }
}
package com.experian.aperture.streaming.client.request.phone;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;
import com.experian.aperture.streaming.client.request.RequestBase;

/**
 * The phone validation request model.
 */
public final class PhoneValidationRequest extends RequestBase {
    /**
     * The phone number that is the subject of the validation.
     * Examples: 6175014020.
     **/
    private String number;

    /**
     * The type of phone number formatting to be returned. If not specified, the default format, E164, will be used.
     * Examples: E164, PLUS_E164, NATIONAL, any 3-letter ISO country code.
     */
    private String outputFormat;

    /**
     * The number of days to look back in cache for the validation result for this phone number. If the result is cached, the response will be returned faster. Acceptable values from 0 (no cache) to 30. If not specified, the default value, 7, will be used.
     */
    private int cacheValueDays;

    /**
     3-letter ISO country code.
     */
    private String countryIso;

    /**
     * Boolean value for get ported date.
     */
    private boolean getPortedDate;

    PhoneValidationRequest(final String referenceId, final String number, final String outputFormat, final int cacheValueDays, final String countryIso, final boolean getPortedDate) {
        super(referenceId);
        Contract.requiresNotEmpty(number, ResourceReader.getErrorMessageWithKey("PhoneNumberRequired"));
        this.number = number;
        this.outputFormat = outputFormat;
        this.cacheValueDays = cacheValueDays;
        this.countryIso = countryIso;
        this.getPortedDate = getPortedDate;
    }

    /**
     * Gets the phone number.
     * @return The phone number.
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Gets the type of phone number formatting to be returned.
     * @return The phone number output format.
     */
    public String getOutputFormat() {
        return this.outputFormat;
    }

    /**
     * Gets the number of days to look back in cache for the validation result for this phone number.
     * @return The cache value in days.
     */
    public int getCacheValueDays() {
        return cacheValueDays;
    }

    /**
     * Gets the country Iso.
     * @return The country Iso.
     */
    public String getCountryIso() {
        return this.countryIso;
    }

    /**
     * Gets the get ported date.
     * @return The get ported date.
     */
    public boolean getGetPortedDate() {
        return  this.getPortedDate;
    }
}
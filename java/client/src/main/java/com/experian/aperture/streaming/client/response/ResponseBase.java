package com.experian.aperture.streaming.client.response;

import com.google.gson.annotations.SerializedName;

/**
 * Class representing the base for all streaming response.
 *
 * @param <T> The response result type.
 */
public abstract class ResponseBase<T> {
    /**
     * If you chose to submit a "Reference-Id" in the request header, the value will be returned with the response.
     *
     * @return referenceId
     **/
    @SerializedName("reference_id")
    private final String referenceId;

    /**
     * Unique Experian-assigned transaction identifier.
     * Examples: ab123ab1-abc1-1234-abcd-ab1a123a1a12.
     *
     * @return transactionId
     **/
    @SerializedName("transaction_id")
    private final String transactionId;

    /**
     * Error model containing the error details.
     *
     * @return error
     **/
    @SerializedName("error")
    private final ResponseError error;

    /**
     * The results.
     *
     * @return result
     **/
    @SerializedName("result")
    private final T result;

    /**
     * The maximum number of requests a customer is allowed to make per minute.
     * Examples: 150
     *
     * @return rate limit
     **/
    @SerializedName("x_rate_limit_limit")
    private final Long rateLimit;

    /**
     * The number of requests you have remaining in the current rate limit window.
     * Examples: 5
     *
     * @return rate remaining
     **/
    @SerializedName("x_rate_limit_remaining")
    private final Long rateRemaining;

    /**
     * The time at which the current rate limit window resets. Expressed in UTC epoch seconds.
     * Examples: 1547453281
     *
     * @return rate reset
     **/
    @SerializedName("x_rate_limit_reset")
    private final Long rateReset;

    @SuppressWarnings("checkstyle:parameterNumber")
    public ResponseBase(final String referenceId,
                        final String transactionId,
                        final ResponseError error,
                        final T result,
                        final Long rateLimit,
                        final Long rateRemaining,
                        final Long rateReset) {
        this.referenceId = referenceId;
        this.transactionId = transactionId;
        this.error = error;
        this.result = result;
        this.rateLimit = rateLimit;
        this.rateRemaining = rateRemaining;
        this.rateReset = rateReset;
    }

    /**
     * Ensure the response is successful by checking for the error and throws appropriate exception.
     *
     * @throws StreamingException The general exception that should be handled by user.
     */
    public void ensureSuccess() throws StreamingException {
        if (this.error == null) {
            return;
        }

        // throws general exception for now.
        // Streaming should return response with status code so that we can have more granular exception.
        throw new StreamingException(this.error.getDetail(), this.error);
    }

    /**
     * Ensure the response is successful by checking for the error.
     *
     * @return Return true if successful.
     */
    public Boolean ensureSuccessful() {
        if (this.error == null) {
            return true;
        }
        return false;
    }

    /**
     * Gets the validation results.
     *
     * @return The validation result.
     * @throws StreamingException Thrown when the response contain errors.
     */
    public T getResult() throws StreamingException {
        this.ensureSuccess();
        return result;
    }

    /**
     * Gets the reference Id.
     * @return The reference Id.
     */
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Gets the number of requests you have remaining in the current rate limit window.
     *
     * @return rate remaining.
     */
    public Long getRateRemaining() {
        return this.rateRemaining;
    }

    /**
     * Gets the time at which the current rate limit window resets. Expressed in UTC epoch seconds.
     *
     * @return The time at which the current rate limit window resets.
     */
    public Long getRateReset() {
        return this.rateReset;
    }
}
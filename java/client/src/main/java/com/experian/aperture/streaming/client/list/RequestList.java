package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.RequestProxyBase;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

/**
 * Defines the request list methods.
 *
 *  @param <T> The request model.
 */
public interface RequestList<T extends RequestProxyBase> {
    /**
     * Gets the remaining rate.
     * @return The remaining rate.
     */
    long getRateRemaining();

    /**
     * Sets the remaining rate.
     * @param rateRemaining The remaining rate.
     */
    void setRateRemaining(long rateRemaining);

    /**
     * Gets the time at which the current rate limit window resets.
     * @return The instant at which the current rate limit resets.
     */
    Instant getRateReset();

    /**
     * Sets the time at which the current rate limit window resets.
     * @param rateReset The time at which the current rate limit window resets.
     */
    void setRateReset(Instant rateReset);

    /**
     * Gets all the requests.
     * @return All the request.
     */
    HashMap<String, T> getRequests();

    /**
     * Adds a request with a key to the list.
     * @param request The request.
     * @param referenceId The reference Id.
     */
    void add(T request, String referenceId);

    /**
     * Removes a request from the list.
     * @param key The request key.
     */
    void remove(String key);

    /**
     * Checks if the request key is present in the list.
     * @param key The request key.
     * @return True if key is present.
     */
    boolean containsKey(String key);

    /**
     * Checks if a new request can be added to the list. This ensures the rate limit is not exceeded.
     * @return True if a new request can be added.
     */
    Boolean canAdd();

    /**
     * Gets all requests in the list.
     * @return All requests in the list.
     */
    List<T> getAll();

    /**
     * Registers the remaining rate.
     * @param rateRemaining the remaining rate.
     * @param rateReset The time at which the current rate limit window resets. Expressed in UTC epoch seconds.
     */
    void registerRateLimit(Long rateRemaining, Long rateReset);


    /**
     * Clears all requests.
     */
    void clear();

    /**
     * Gets all reference Ids.
     * @return The list of reference Ids.
     */
    List<String> getAllReferenceIds();
}
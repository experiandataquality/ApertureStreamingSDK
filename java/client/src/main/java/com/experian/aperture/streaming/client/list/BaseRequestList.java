package com.experian.aperture.streaming.client.list;

import com.experian.aperture.streaming.client.proxy.RequestProxyBase;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Defines the request list common methods.
 *
 *  @param <T> The request model.
 */
abstract class BaseRequestList<T extends RequestProxyBase> implements RequestList<T> {
    private final Long defaultRateRemaining = Long.valueOf(100);
    private final Long defaultRateResetInMilli = Long.valueOf(60000);
    private Long rateRemaining;
    private Instant rateReset;

    @Override
    public long getRateRemaining() {
        if (this.rateRemaining == null) {
            this.rateRemaining = this.defaultRateRemaining;
            return this.rateRemaining;
        }
        return this.rateRemaining;
    }

    @Override
    public void setRateRemaining(final long rateRemaining) {
        this.rateRemaining = rateRemaining;
    }

    @Override
    public Instant getRateReset() {
        if (this.rateReset == null) {
            this.rateReset = Instant.ofEpochMilli(Instant.now().toEpochMilli() + defaultRateResetInMilli);
            return this.rateReset;
        }
        return this.rateReset;
    }

    @Override
    public void setRateReset(final Instant rateReset) {
        this.rateReset = rateReset;
    }

    @Override
    public void add(final T request, final String referenceId) {
        if (this.containsKey(referenceId)) {
            throw new IllegalArgumentException(String.format("Duplicate reference Id %s.", referenceId));
        }

        if (this.canAdd()) {
            this.getRequests().put(referenceId, request);
        }
    }

    @Override
    public void remove(final String key) {
        if (this.containsKey(key)) {
            this.getRequests().remove(key);
        }
    }

    @Override
    public boolean containsKey(final String key) {
        return this.getRequests().containsKey(key);
    }

    @Override
    public Boolean canAdd() {
        // Checks if rateReset is greater than the current time.
        if (this.getRateReset().compareTo(Instant.now()) > 0) {
            return this.getRateRemaining() > 0;
        }
        // If the rateReset is in the past, a new request should be allowed.
        return true;
    }

    @Override
    public List<T> getAll() {
        if (this.getRequests().isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<T>(this.getRequests().values());
    }

    @Override
    public void registerRateLimit(final Long rateRemaining, final Long rateReset) {
        this.setRateRemaining(rateRemaining);
        this.setRateReset(Instant.ofEpochSecond(rateReset));
    }

    @Override
    public void clear() {
        this.getRequests().clear();
    }

    @Override
    public List<String> getAllReferenceIds() {
        return this.getAll().stream().map(x -> x.getReferenceId()).collect(Collectors.toList());
    }
}
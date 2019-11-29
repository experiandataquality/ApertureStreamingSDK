package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.ConnectionResponse;
import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.ResponseBase;

/**
 * Defines the default base response handler.
 *
 * @param <T> the ResponseBase model.
 */
public abstract class BaseResponseHandler<T extends ResponseBase> implements ConnectionResponse<T> {
    private final RequestList requestList;

    BaseResponseHandler(final RequestList requestList) {
        this.requestList = requestList;
    }

    @Override
    public void invoke(final T response) {
        this.requestList.remove(response.getReferenceId());
         if (response.ensureSuccessful()) {
             this.requestList.registerRateLimit(response.getRateRemaining(), response.getRateReset());
         }
    }
}
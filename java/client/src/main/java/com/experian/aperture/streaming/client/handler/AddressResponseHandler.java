package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.address.AddressValidationResponse;

/**
 * Defines the default address response handler.
 */
public final class AddressResponseHandler extends BaseResponseHandler<AddressValidationResponse> {
    public AddressResponseHandler(final RequestList requestList) {
        super(requestList);
    }
}
package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.phone.PhoneValidationResponse;

/**
 * Defines the default phone response handler.
 */
public class PhoneResponseHandler extends BaseResponseHandler<PhoneValidationResponse> {
    public PhoneResponseHandler(final RequestList requestList) {
        super(requestList);
    }
}
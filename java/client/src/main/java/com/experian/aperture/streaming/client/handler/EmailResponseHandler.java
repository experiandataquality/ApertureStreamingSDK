package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.list.RequestList;
import com.experian.aperture.streaming.client.response.email.EmailValidationResponse;

/**
 * Defines the default email response handler.
 */
public class EmailResponseHandler extends BaseResponseHandler<EmailValidationResponse> {
    public EmailResponseHandler(final RequestList requestList) {
        super(requestList);
    }
}
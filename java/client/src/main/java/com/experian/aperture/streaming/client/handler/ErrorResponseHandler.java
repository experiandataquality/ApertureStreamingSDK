package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the error response handler.
 */
public interface ErrorResponseHandler {
    /**
     * Handles an error response from the hub.
     * @param method The method name.
     * @param referenceId The reference Id.
     * @param errorMessage The error message.
     */
    void handle(StreamingMethod method, String referenceId, String errorMessage);

    /**
     * Sets a fail request subject.
     * @param failRequestSubject The fail request subject.
     */
    void setFailRequestSubject(PublishSubject<FailRequestResponse> failRequestSubject);
}
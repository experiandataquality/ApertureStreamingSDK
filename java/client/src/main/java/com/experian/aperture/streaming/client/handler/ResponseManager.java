package com.experian.aperture.streaming.client.handler;

import com.experian.aperture.streaming.client.StreamingMethod;
import com.experian.aperture.streaming.client.response.FailRequestResponse;
import io.reactivex.subjects.PublishSubject;

/**
 * Defines the response manager methods.
 */
public interface ResponseManager {
    /**
     * Registers the default response handlers.
     */
    void registerDefaultResponseHandlers();

    /**
     * Registers the request resend task.
     */
    void registerRequestResendHandler();

    /**
     * Handles an error response.
     * @param method The method name.
     * @param referenceId The reference Id.
     * @param errorMessage The error message.
     */
    void handleError(StreamingMethod method, String referenceId, String errorMessage);

    /**
     * Gets or subscribes to a fail request event.
     * @return The fail request subject.
     */
    PublishSubject<FailRequestResponse> getFailRequestSubject();
}
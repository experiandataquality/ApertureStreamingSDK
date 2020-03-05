package com.experian.aperture.streaming.client.request;

import com.experian.aperture.streaming.client.ResourceReader;
import com.experian.aperture.streaming.client.guard.Contract;

/**
 * Class representing the base for all streaming request.
 *
 */
public abstract class RequestBase {
    /**
     * Identifier that will be returned in the response to help you track the request.
     */
    private String referenceId;

    public RequestBase(final String referenceId) {
        Contract.requiresNotEmpty(referenceId, ResourceReader.getErrorMessageWithKey("ReferenceIdRequired"));
        Contract.requiresNotWhiteSpaces(referenceId, ResourceReader.getErrorMessageWithKey("ReferenceIdRequiredEmptySpaceError"));

        this.referenceId = referenceId;
    }

    /**
     * Gets the reference Id.
     * @return The reference Id.
     */
    public String getReferenceId() {
        return this.referenceId;
    }
}

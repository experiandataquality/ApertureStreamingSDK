package com.experian.aperture.streaming.client.response;

/**
 * Defines general exception thrown from error received in the response.
 */
public class StreamingException extends Exception {
    /**
     * A link to documentation that provides more details about the error you’ve encountered.
     * @return type
     **/
    private final String type;

    /**
     * The title of the error.
     * Examples: Bad Request.
     *
     * @return title
     **/
    private final String title;

    /**
     * The endpoint that returned the error.
     *
     * @return instance
     **/
    private final String instance;

    /**
     * A description of the error.
     * Examples: The request body was malformed.
     *
     * @return detail
     **/
    private final String detail;

    public StreamingException(final String message, final ResponseError cause) {
        super(message);
        this.type = cause.getType();
        this.title = cause.getTitle();
        this.instance = cause.getInstance();
        this.detail = cause.getDetail();
    }
}
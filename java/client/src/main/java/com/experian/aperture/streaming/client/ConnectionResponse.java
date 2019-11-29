package com.experian.aperture.streaming.client;

/**
 * The SignalR connection response.
 *
 * @param <T> the response model.
 */
public interface ConnectionResponse<T>  {
    /**
     * The method that will be invoked.
     *
     * @param response the response model.
     */
    void invoke(T response);
}
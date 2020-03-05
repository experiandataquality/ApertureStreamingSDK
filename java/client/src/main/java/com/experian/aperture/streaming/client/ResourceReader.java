package com.experian.aperture.streaming.client;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

/**
 * The reader to read resource from resources.
 */
public final class ResourceReader {
    private static Locale locale = new Locale("en", "US");
    private static ResourceBundle errorMessageBundle = ResourceBundle.getBundle("Message", locale);

    private ResourceReader() { }

    /**
     * Gets the error message with specified key.
     * @param key The resource key.
     * @throws NoSuchElementException When the specified key is not found in resource.
     * @return The error message.
     */
    public static String getErrorMessageWithKey(final String key) {
        validateResourceKey(key);
        return errorMessageBundle.getString(key);
    }

    /**
     * Gets the formatted error message with specified key.
     * @param key The resource key.
     * @param args Arguments referenced by the format specifiers in the format string.
     * @throws NoSuchElementException When the specified key is not found in resource.
     * @return The error message.
     */
    public static String getErrorMessageWithKeyFormat(final String key, final Object... args) {
        validateResourceKey(key);
        return String.format(errorMessageBundle.getString(key), args);
    }

    private static void validateResourceKey(final String key) {
        if (!errorMessageBundle.containsKey(key)) {
            throw new NoSuchElementException(String.format("The key '%s' not found in ErrorMessage.properties.", key));
        }
    }
}

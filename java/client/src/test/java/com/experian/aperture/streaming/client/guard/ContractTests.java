package com.experian.aperture.streaming.client.guard;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

/**
 * Contract tests.
 */
@RunWith(Theories.class)
public class ContractTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private final String message = "The referenceId field can only contain alphanumeric, '-', '/', '_' and ':' characters.";
    private final String referenceIdError = "The referenceId field must be less than 256 characters.";
    private final String referenceIdRequiredEmptySpaces = "The referenceId field must not be empty spaces.";

    /**
     * Contract tests to throw illegal argument exception.
     * @param input The string input.
     */
    @Theory
    public void requiresReferenceIdAlphanumeric_InvalidInputs_ShouldThrowExceptionWithMessage(@FromDataPoints("invalidCharacters") final String input) {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage(message);
        Contract.requiresReferenceIdAlphanumeric(input, message);
    }

    /**
     * Contract tests to not throw illegal argument exception.
     */
    @Test
    public void requiresNotWhiteSpaces_WhiteSpaceReferenceId_ShouldThrowExceptionWithMessage() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage(referenceIdRequiredEmptySpaces);
        Contract.requiresNotWhiteSpaces(" ", referenceIdRequiredEmptySpaces);
    }

    /**
     * Contract tests to not throw illegal argument exception.
     * @param input The string input.
     */
    @Theory
    public void requiresReferenceIdAlphanumeric_ValidInputs_ShouldNotThrowAnyException(@FromDataPoints("validInputs") final String input) {
        Contract.requiresReferenceIdAlphanumeric(input, message);
    }

    /**
     * Contract tests to not throw illegal argument exception for valid reference id length.
     */
    @Test
    public void requiresReferenceIdWithinRange_ReferenceIdOfLength256_ShouldNotThrowAnyException() {
        Contract.requiresReferenceIdWithinRange("AqItyKQliRxdKwmgn935vyc2aByQawViAAaxmhFmGiHfpjykm62l82sQG3F4eprY1pjNd7Liu8xwNSByXFxgUYWn50m1XvTLOC9yycmMlyky1WlON0HWta0xp3BmykBvKJMKUMks4cpBpPEL9yTJouUU2QouaaMOmLrHR8DjEVN6slSxpXCZQ1d96Wp05Uuw1BelSvhVnKWUjWQrxXzDhxRkXZ9SZ9dQQtvTAJKL3OCicYQoGjLkAclMJo8kX3Qz", referenceIdError);
    }

    /**
     * Contract tests to throw illegal argument exception when exceeding the maximum allowable length.
     */
    @Test
    public void requiresReferenceIdWithinRange_ReferenceIdOfLength257_ShouldThrowAnyExceptionWithMessage() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage(referenceIdError);
        Contract.requiresReferenceIdWithinRange("tiryGps3cwfPEcMWiAouIGPJdZOyhyC6pdYS3yQP2U27w4xUbs0UgrUxM2yxujlybevoIJMj1Nu6lr1EMcm1OqWrXqwV6Jpb3Q2xkEqVu0wWZtOHOjw4LAuL7PBIGvq1M7GMV4tVJMMzsaboedrFjR4Wy9nLpi051COxKuyCg3F4oJb1pr3mdhO2JxnMbJRvhWe90QjUa27qQvEy9kPGzTRvfAGYAYjRCSG0bNVLPVhy9XT8OMj16LrGL6v8H3jKv", referenceIdError);
    }

    @DataPoints("validInputs")
    public static String[] validInputs() {
        return new String[] {"a_A-00/00:00", "z_Z-99/99:99"};
    };

    @DataPoints("invalidCharacters")
    public static String[] invalidCharacters() {
        return new String[]{"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "{", "}", "|", "[", "]", "\\", "\"", ";", "'", "<", ">", "?", ",", "."};
    };
}

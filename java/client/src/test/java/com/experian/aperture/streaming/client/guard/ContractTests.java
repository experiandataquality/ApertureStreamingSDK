package com.experian.aperture.streaming.client.guard;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
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

    private final String message = "The field reference id must be alphanumeric.";
    private final String referenceIdError = "The field reference id must be less than 256 characters.";
    private final String referenceIdRequiredEmptySpaces = "The reference_id field must not be empty spaces.";

    /**
     * Contract tests to throw illegal argument exception.
     * @param inputs The string inputs.
     */
    @Theory
    public void shouldThrowIllegalArgumentException(final String inputs) {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage(message);
        Contract.requiresReferenceIdAlphanumeric(inputs, message);
    }

    /**
     * Contract tests to not throw illegal argument exception.
     */
    @Test
    public void shouldNotThrowIllegalArgumentExceptionWhenReferenceIdEmptySpaces() {
        this.exception.expect(IllegalArgumentException.class);
        this.exception.expectMessage(referenceIdRequiredEmptySpaces);
        Contract.requiresNotWhiteSpaces(" ", referenceIdRequiredEmptySpaces);
    }

    /**
     * Contract tests to not throw illegal argument exception.
     */
    @Test
    public void shouldNotThrowIllegalArgumentException() {
        Contract.requiresReferenceIdAlphanumeric("test12345:- ", message);
    }

    /**
     * Contract tests to not throw illegal argument exception.
     */
    @Test
    public void shouldNotThrowIllegalArgumentExceptionWhenReferenceIdInLength() {
        Contract.requiresReferenceIdWithinRange("test12345", referenceIdError);
    }

    @DataPoints
    public static String[] value() {
        return new String[] {"@", "%", "#$%$", "/\\", "<", ">", "><"};
    };
}

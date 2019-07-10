package com.library.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationResultTest {

    private ValidationResult validationResult = new ValidationResult();

    @Test
    public void add() {
        validationResult.add("result", "test result");
        assertFalse(validationResult.isSuccess());
    }

    @Test
    public void hasError() {
        validationResult.add("test", "test");
        assertTrue(validationResult.hasError("test"));
        assertFalse(validationResult.hasError("test2"));
    }

    @Test
    public void getError() {
        validationResult.add("result", "test result");
        validationResult.add("result2", "test result2");
        assertEquals("test result2", validationResult.getError("result2"));
    }
}
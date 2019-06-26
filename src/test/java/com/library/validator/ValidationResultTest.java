package com.library.validator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ValidationResultTest {

    private ValidationResult validationResult = new ValidationResult();

    @Test
    public void add() {
        validationResult.add("result", "test result");
        assertEquals(1, validationResult.getResultMap().size());
    }

    @Test
    public void getResultMap() {
        Map<String, String> expectedMap = new HashMap<>();
        assertEquals(expectedMap, validationResult.getResultMap());
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
package com.library.validator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ValidationResultTest {

    private ValidationResult validationResult = new ValidationResult();

    @Test
    public void add() {
        validationResult.add("result", "test result");
        assertEquals(1, validationResult.getResultMap().size());
    }

    @Test
    public void getResultMap() {
        Map <String, String> expectedMap = new HashMap<>();
        assertEquals(expectedMap, validationResult.getResultMap());
    }

    @Test
    public void getResultByKey() {
        validationResult.add("result", "test result");
        validationResult.add("result2", "test result2");
        assertEquals("test result2", validationResult.getResultByKey("result2"));
    }
}
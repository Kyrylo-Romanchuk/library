package com.library.data.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntegerConverterTest {

    private IntegerConverter integerConverter = new IntegerConverter();

    @Test
    public void convert() {
        assertEquals(Integer.valueOf(123456789), integerConverter.convert("123456789"));
        assertNull(integerConverter.convert("123abc"));
    }
}
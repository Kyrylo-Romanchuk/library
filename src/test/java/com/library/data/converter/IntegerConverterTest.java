package com.library.data.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerConverterTest {

    private IntegerConverter integerConverter = new IntegerConverter();

    @Test
    public void convert() {
        assertEquals(Integer.valueOf(123456789), integerConverter.convert("123456789"));
        assertEquals(null, integerConverter.convert("123abc"));
    }
}
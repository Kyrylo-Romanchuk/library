package com.library.data.converter;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class DateConverterTest {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private DateConverter dateConverter = new DateConverter();

    @Test
    public void convert() throws ParseException {
        assertEquals(simpleDateFormat.parse("06/24/2019"), dateConverter.convert("06/24/2019"));
    }
}
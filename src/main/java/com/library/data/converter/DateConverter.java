package com.library.data.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    }
}

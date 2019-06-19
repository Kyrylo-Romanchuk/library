package com.library.data.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date convert(String s) {
        try {
            return simpleDateFormat.parse(s);
        } catch (Exception e) {
            return null;
        }
    }
}

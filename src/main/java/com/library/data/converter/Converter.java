package com.library.data.converter;

public interface Converter<T, R> {
    R convert(T t);
}

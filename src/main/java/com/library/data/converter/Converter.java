package com.library.data.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<T, R> {
    R convert(T t);

    default List<R> convert(List<T> t){
        return t.stream().map(this::convert).collect(Collectors.toList());
    }
}

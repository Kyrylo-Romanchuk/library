package com.library.validator;

public interface Validator<T, R> {
    R validate(T t);
}

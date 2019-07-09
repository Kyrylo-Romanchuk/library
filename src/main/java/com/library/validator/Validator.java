package com.library.validator;

public interface Validator<T> {
    ValidationResult validate(T t);
}

package com.library.validator;

public interface Validator<T, R> {
    R validate(T t);

    default boolean stringIsEmpty(String string) {
        return string.matches("^\\s*$") || string == null;
    }

    default boolean integerIsEmpty(Integer integer) {
        return integer == null;
    }

    default boolean objectIsEmpty(Object object) {
        return object == null;
    }

    default boolean stringWithoutNumbers (String string){
        return string.matches("[a-zA-Z]+");
    }
}

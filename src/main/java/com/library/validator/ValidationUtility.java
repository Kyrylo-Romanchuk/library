package com.library.validator;

public class ValidationUtility {
    protected static boolean stringIsEmpty(String string) {
        return string == null || string.matches("\\s*");
    }

    protected static boolean integerIsEmpty(Integer integer) {
        return integer == null;
    }

    protected static boolean objectIsEmpty(Object object) {
        return object == null;
    }

    protected static boolean stringWithoutNumbers(String string) {
        return string == null || string.matches("[a-zA-Z]+");
    }
}

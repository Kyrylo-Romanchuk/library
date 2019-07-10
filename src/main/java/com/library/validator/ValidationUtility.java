package com.library.validator;

public class ValidationUtility {
    public static boolean stringIsEmpty(String string) {
        return string == null || string.matches("\\s*");
    }

    public static boolean integerIsEmpty(Integer integer) {
        return integer == null;
    }

    public static boolean objectIsEmpty(Object object) {
        return object == null;
    }

    public static boolean stringNotOnlyLetters(String string) {
        return string == null || !string.matches("[a-zA-Z]+");
    }
}

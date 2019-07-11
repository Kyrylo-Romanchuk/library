package com.library.validator;

public class ValidationUtility {
    public static boolean isEmpty(String string) {
        return string == null || string.matches("\\s*");
    }

    public static boolean isEmpty(Integer integer) {
        return integer == null;
    }

    public static boolean isEmpty(Object object) {
        return object == null;
    }

    public static boolean stringNotOnlyLetters(String string) {
        return string == null || !string.matches("[a-zA-Z]+");
    }
}

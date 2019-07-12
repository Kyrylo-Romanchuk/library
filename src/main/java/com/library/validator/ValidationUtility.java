package com.library.validator;

public class ValidationUtility {
    public static boolean isValid(String string) {
        return string != null && !string.matches("\\s*");
    }

    public static boolean isValid(Integer integer) {
        return integer != null;
    }

    public static boolean isValid(Object object) {
        return object != null;
    }

    public static boolean stringOnlyWords(String string) {
        return string != null && string.matches("[a-zA-Z\\s]*");
    }
}

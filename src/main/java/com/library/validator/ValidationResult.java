package com.library.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {
    private final Map<String, String> validationMap = new HashMap();

    public void add(String key, String result) {
        validationMap.put(key, result);
    }

    public Map<String, String> getResultMap() {
        return validationMap;
    }

    public boolean hasError(String key) {
        return validationMap.containsKey(key);
    }

    public String getError(String key) {
        return validationMap.get(key);
    }
}

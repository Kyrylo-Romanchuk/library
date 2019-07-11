package com.library.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractValidator<T> implements Validator<T> {
    protected final List<ValidationRegistry<T, ?>> validations = new ArrayList<>();

    @Override
    public ValidationResult validate(T t) {
        ValidationResult validationResult = new ValidationResult();
        for (ValidationRegistry validation : validations) {
            Object apply = validation.function.apply(t);
            boolean isValid = validation.predicate.test(apply);
            if (!isValid) {
                validationResult.add(validation.fieldName, validation.errorMessage);
            }
        }
        return validationResult;
    }

    class ValidationRegistry<T, R> {
        private final String fieldName;
        private final String errorMessage;
        private final Predicate<R> predicate;
        private final Function<T, R> function;

        public ValidationRegistry(String fieldName, Function<T, R> function, Predicate<R> predicate, String errorMessage) {
            this.fieldName = fieldName;
            this.function = function;
            this.errorMessage = errorMessage;
            this.predicate = predicate;
        }
    }
}

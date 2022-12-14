package com.profeel.monsterfac.monsterfactoryserver.common.exception;

import java.util.List;

public class ValidationErrorException extends RuntimeException {

    private List<ValidationError> errors;


    public ValidationErrorException(List<ValidationError> errors) {
        this.errors = errors;
    }
    public List<ValidationError> getErrors() {
        return errors;
    }
}

package com.port.accident.portaccident.exception;

public class DuplicateAccidentTypeException extends RuntimeException{

    public DuplicateAccidentTypeException() {
    }

    public DuplicateAccidentTypeException(String message) {
        super(message);
    }

    public DuplicateAccidentTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateAccidentTypeException(Throwable cause) {
        super(cause);
    }

    public DuplicateAccidentTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

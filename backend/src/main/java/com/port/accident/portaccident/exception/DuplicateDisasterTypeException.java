package com.port.accident.portaccident.exception;

public class DuplicateDisasterTypeException extends RuntimeException{

    public DuplicateDisasterTypeException() {
    }

    public DuplicateDisasterTypeException(String message) {
        super(message);
    }

    public DuplicateDisasterTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateDisasterTypeException(Throwable cause) {
        super(cause);
    }

    public DuplicateDisasterTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

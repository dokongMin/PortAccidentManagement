package com.port.accident.portaccident.exception;

public class DuplicateCreateCodeException extends RuntimeException {
    public DuplicateCreateCodeException() {
        super();
    }

    public DuplicateCreateCodeException(String message) {
        super(message);
    }

    public DuplicateCreateCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateCreateCodeException(Throwable cause) {
        super(cause);

    }
}

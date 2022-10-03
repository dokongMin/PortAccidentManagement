package com.port.accident.portaccident.exception;

public class DuplicateTrainingResultNameException extends RuntimeException {
    public DuplicateTrainingResultNameException() {
        super("훈련명(name)은 유니크한 값이여야 합니다.");
    }

    public DuplicateTrainingResultNameException(String message) {
        super(message);
    }

    public DuplicateTrainingResultNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateTrainingResultNameException(Throwable cause) {
        super(cause);

    }
}

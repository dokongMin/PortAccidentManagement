package com.port.accident.portaccident.exception;

public class CanNotCreateEntityException extends RuntimeException  {
    public CanNotCreateEntityException() {
        super("객체를 생성할 수 없습니다.");
    }

    public CanNotCreateEntityException(String message) {
        super(message);
    }

    public CanNotCreateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotCreateEntityException(Throwable cause) {
        super(cause);

    }
}

package com.freedom.nut.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InternalServerException extends RuntimeException {
    public InternalServerException(Throwable cause) {
        super(cause);
    }
}

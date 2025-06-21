package com.sid.gl.exceptions;

public class BadArgumentException extends Exception{
    public BadArgumentException(String message) {
        super(message);
    }

    public BadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadArgumentException(Throwable cause) {
        super(cause);
    }
}

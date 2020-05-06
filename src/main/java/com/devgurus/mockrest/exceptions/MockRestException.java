package com.devgurus.mockrest.exceptions;

public class MockRestException extends Exception{

    public MockRestException() {
    }

    public MockRestException(String message) {
        super(message);
    }

    public MockRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockRestException(Throwable cause) {
        super(cause);
    }

    public MockRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.to4ka.exceptions;

/**
 * Created by User on 3/16/2018.
 */
public class To4kaException extends Exception {

    public To4kaException() {
        super();
    }

    public To4kaException(String message) {
        super(message);
    }

    public To4kaException(String message, Throwable cause) {
        super(message, cause);
    }
}

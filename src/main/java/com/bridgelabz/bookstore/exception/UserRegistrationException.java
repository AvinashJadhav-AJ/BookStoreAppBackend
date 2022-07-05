package com.bridgelabz.bookstore.exception;

import org.springframework.http.HttpStatus;

public class UserRegistrationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message
     */
    public UserRegistrationException(String message) {
        super(message);
    }

    /**
     *
     * @param statusCode
     * @param statusmessage
     */
    public UserRegistrationException(int statusCode, String statusmessage) {
        super(statusmessage);
    }

    /**
     *
     * @param string
     * @param ok
     * @param object
     * @param string2
     */
    public UserRegistrationException(String string, HttpStatus ok, Object object, String string2) {

    }
}
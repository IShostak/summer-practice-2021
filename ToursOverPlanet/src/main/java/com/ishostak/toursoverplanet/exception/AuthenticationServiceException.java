package com.ishostak.toursoverplanet.exception;

public class AuthenticationServiceException  extends Exception {

    public AuthenticationServiceException(String message) {
        super(message);
    }

    public AuthenticationServiceException(String message, Exception ex) {
        super(message, ex);
    }

    public AuthenticationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

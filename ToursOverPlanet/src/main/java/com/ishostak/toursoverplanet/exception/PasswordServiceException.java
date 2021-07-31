package com.ishostak.toursoverplanet.exception;

/**
 * Exception for {@link com.ishostak.toursoverplanet.service.PasswordService}
 */
public class PasswordServiceException extends Throwable {

    public PasswordServiceException(String message) {
        super(message);
    }

    public PasswordServiceException(String message, Exception ex) {
        super(message, ex);
    }

    public PasswordServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

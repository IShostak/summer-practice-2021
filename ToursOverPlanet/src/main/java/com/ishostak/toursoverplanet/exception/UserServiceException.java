package com.ishostak.toursoverplanet.exception;

/**
 * Exception for {@link com.ishostak.toursoverplanet.service.UserService}
 */
public class UserServiceException extends Throwable {

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Exception ex) {
        super(message, ex);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

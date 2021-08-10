package com.ishostak.toursoverplanet.exception;

public class TourServiceException extends Throwable {

    public TourServiceException(String message) {
        super(message);
    }

    public TourServiceException(String message, Exception ex) {
        super(message, ex);
    }

    public TourServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

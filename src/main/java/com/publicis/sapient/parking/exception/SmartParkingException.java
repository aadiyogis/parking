package com.publicis.sapient.parking.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * aditya created on 19/12/21
 */
@Getter
@Setter
public class SmartParkingException extends RuntimeException {
    private String errorCode;
    private String errorText;

    public SmartParkingException(String errorCode, String errorText) {
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public SmartParkingException(String message, String errorCode, String errorText) {
        super(message);
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public SmartParkingException(String message, Throwable cause, String errorCode, String errorText) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public SmartParkingException(Throwable cause, String errorCode, String errorText) {
        super(cause);
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public SmartParkingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorText) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorText = errorText;
    }
}

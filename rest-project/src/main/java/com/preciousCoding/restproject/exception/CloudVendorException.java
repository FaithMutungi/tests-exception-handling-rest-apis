package com.preciousCoding.restproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public class CloudVendorException {
    private final String message;



    private final Throwable  throwable; //cause



    private final HttpStatus httpStatus;



    public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public Throwable getThrowable() {
        return throwable;
    }
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }



    }



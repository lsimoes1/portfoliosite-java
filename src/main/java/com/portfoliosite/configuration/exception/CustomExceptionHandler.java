package com.portfoliosite.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;


public class CustomExceptionHandler extends HttpStatusCodeException {

    public CustomExceptionHandler(String msg, HttpStatus statusCode){
        super(statusCode, msg);
    }
}

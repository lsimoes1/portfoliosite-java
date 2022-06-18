package com.portfoliosite.configuration.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            IllegalArgumentException.class,
            RestClientException.class,
            CustomExceptionHandler.class
    })
    public ResponseEntity errorResponseAPI(Exception ex){
        Throwable cause = ex.getCause();

        if(cause instanceof CustomExceptionHandler){
            return ResponseEntity.status(((CustomExceptionHandler) cause).getStatusCode())
                    .body(cause.getMessage());
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Erro na chamada API - %s", ex.getMessage()));
        }
    }

    @ExceptionHandler({
            JsonProcessingException.class,
            JsonMappingException.class,
            IOException.class
    })
    public ResponseEntity errorConverter(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(String.format("Erro ao converter o objeto - %s", ex.getMessage()));
    }
}

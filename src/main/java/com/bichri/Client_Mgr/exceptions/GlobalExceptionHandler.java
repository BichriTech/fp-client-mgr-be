package com.bichri.Client_Mgr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientAPIException.class)
    public ResponseEntity<ErrorsDetails> handleMobilAPIExceptions(ClientAPIException exception, WebRequest webRequest){

        ErrorsDetails errorsDetails = new ErrorsDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorsDetails, HttpStatus.BAD_REQUEST);

    }
}

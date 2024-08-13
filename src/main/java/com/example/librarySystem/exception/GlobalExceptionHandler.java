package com.example.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<Object> handleApiRequestException(ResourceNotFoundException ex) {
//
//        //1) create a payload containing exception details
//        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
//        ApiException apiException=new ApiException(ex.getMessage(), ex,badRequest, ZonedDateTime.now(ZoneId.of("z")));
//
//
//        return new ResponseEntity<>(apiException,badRequest);
//    }
}

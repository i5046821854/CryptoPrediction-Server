package com.capstone.crypto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(IllegalArgumentException e)
    {
        ErrorCodes errorCodes = ErrorCodes.INVALID_INPUT_VALUE;
        final ErrorResponse response = new ErrorResponse(errorCodes.getCode(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCodes.getStatus()));
    }
}

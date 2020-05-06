package com.devgurus.mockrest.exceptions;

import com.devgurus.mockrest.models.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value= { Exception.class})
    protected ResponseEntity<AppError> handleConflict(
            Exception ex ) {
        String message="Oops!!! Something went wrong.";
        AppError errorModel = new AppError(message, null);
        return new ResponseEntity<>(errorModel,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

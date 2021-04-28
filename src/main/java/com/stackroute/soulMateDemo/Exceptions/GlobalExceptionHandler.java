package com.stackroute.soulMateDemo.Exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;

    @ExceptionHandler(value = UserAlradyExistsException.class)
    public ResponseEntity<String> userExistException(){
        return new ResponseEntity<>(message1, HttpStatus.CONFLICT);
    }
}

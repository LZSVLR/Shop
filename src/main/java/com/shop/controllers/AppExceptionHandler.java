package com.shop.controllers;

import com.shop.exception.ApiError;
import com.shop.exception.CreateValidationException;
import com.shop.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    //Проверка name/=null
    @ExceptionHandler(CreateValidationException.class)                      // нахрена оно тут?
    public ResponseEntity<Object> handleClientNameIsNull(CreateValidationException e, WebRequest request)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.I_AM_A_TEAPOT, LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
    //Невалидный id
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e, WebRequest r)
    {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.I_AM_A_TEAPOT, LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
}

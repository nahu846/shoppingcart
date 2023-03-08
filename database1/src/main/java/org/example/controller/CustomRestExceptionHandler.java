package org.example.controller;

import org.example.exceptions.IdExistsException;
import org.example.exceptions.OrderException;
import org.example.exceptions.ValueOutOfBoundsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ValueOutOfBoundsException.class)
    ResponseEntity<?> handleWrongQty(RuntimeException exception, WebRequest request) {
        String bodyOfResponse = "Quantity is too big";
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = OrderException.class)
    ResponseEntity<?> handleWrongId(RuntimeException exception, WebRequest webRequest) {
        String bodyOfResponse = "Id not found";
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = IdExistsException.class)
    ResponseEntity<?> handleRepeatedId(RuntimeException exception, WebRequest webRequest) {
        String bodyOfResponse = "Id already exists";
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }
}

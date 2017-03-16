package com.thepeaklab.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

/**
 * @author David Reiher - dr@thepeaklab.com
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFound() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.FOUND)  // 302
    @ExceptionHandler(EntityExistsException.class)
    public void handleEntityExists() {
        // Nothing to do
    }

}



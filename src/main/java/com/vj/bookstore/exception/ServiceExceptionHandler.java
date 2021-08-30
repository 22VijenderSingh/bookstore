package com.vj.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(BookstoreServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String bookstoreExceptionHandler(BookstoreServiceException ex ){
            return ex.getMessage();
    }

}

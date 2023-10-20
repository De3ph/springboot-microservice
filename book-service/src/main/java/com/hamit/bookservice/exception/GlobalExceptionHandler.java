package com.hamit.bookservice.exception;

import com.hamit.bookservice.exception.exceptions.GlobalException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public GlobalException handleException(Exception e) {
        GlobalException exception = new GlobalException();
        exception.setMessage(e.getCause().toString());
        exception.setRaisedAt(new Timestamp(System.currentTimeMillis()));
        return exception;
    }
}

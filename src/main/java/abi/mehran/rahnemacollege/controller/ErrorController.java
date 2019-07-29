package abi.mehran.rahnemacollege.controller;

import abi.mehran.rahnemacollege.util.exception.EntityNotFoundException;
import abi.mehran.rahnemacollege.util.exception.ExceptionMessage;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    private Gson gson = new Gson();

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, gson.toJson(new ExceptionMessage(ex.getMessage(), 404)), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}

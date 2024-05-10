package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.types.ApiErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;


@ControllerAdvice
public class CustomErrorController implements ErrorController {


    //not found error

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //404 Page not found
    public @ResponseBody ApiErrorResponse handleNoResourceFoundException(NoResourceFoundException e) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setError("Page not found");
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ApiErrorResponse handleException(Exception e) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setError("An error occurred!: " + e.getMessage());
        //make a string of the stack trace joined by new lines


        return response;
    }


}

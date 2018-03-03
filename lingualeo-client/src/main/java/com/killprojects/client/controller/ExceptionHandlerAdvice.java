package com.killprojects.client.controller;

import com.killprojects.Error;
import com.killprojects.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by vladimir on 03.03.2018.
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerAdvice {


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result exception(Exception exception, WebRequest request) {
        return Result.error(Error.is(exception));
    }
}

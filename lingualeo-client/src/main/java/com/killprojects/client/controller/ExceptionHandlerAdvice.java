package com.killprojects.client.controller;

import com.killprojects.common.Error;
import com.killprojects.common.InternalSystemException;
import com.killprojects.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


/**
 * Created by vladimir on 03.03.2018.
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExceptionHandlerAdvice {


    @ExceptionHandler(value = InternalSystemException.class)
    @ResponseBody
    public Result exceptionHttp(InternalSystemException exception, WebRequest request) {
        return Result.error(Error.is(exception));
    }
}

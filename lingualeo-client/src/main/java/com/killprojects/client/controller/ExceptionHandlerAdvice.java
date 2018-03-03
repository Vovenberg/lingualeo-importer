package com.killprojects.client.controller;

import com.killprojects.client.exceptions.HttpRequestException;
import com.killprojects.common.Error;
import com.killprojects.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static com.killprojects.common.ErrorType.HTTP_ERROR;
import static com.killprojects.common.ErrorType.UNKNOWN_ERROR;

/**
 * Created by vladimir on 03.03.2018.
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExceptionHandlerAdvice {


    @ExceptionHandler(value = HttpRequestException.class)
    @ResponseBody
    public Result exceptionHttp(HttpRequestException exception, WebRequest request) {
        return Result.error(Error.is(HTTP_ERROR, exception));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exception(Exception exception, WebRequest request) {
        return Result.error(Error.is(UNKNOWN_ERROR, exception));
    }
}

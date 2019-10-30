package com.lqw.vblog.exception;

import com.lqw.vblog.constants.Response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice()
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseResult requestHandlingNoHandlerFound(){
        return new ResponseResult(ResponseCode.RESPONSE_NOT_FOUND.getCode(),null,ResponseCode.RESPONSE_NOT_FOUND.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ResponseResult requestHandlingHttpRequestMethodNotSupported(){
        return new ResponseResult(ResponseCode.METHOD_NOT_ALLOWED.getCode(),null,ResponseCode.METHOD_NOT_ALLOWED.getMessage());
    }

}

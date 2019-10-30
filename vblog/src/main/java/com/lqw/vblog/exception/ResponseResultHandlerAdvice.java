package com.lqw.vblog.exception;

import com.lqw.vblog.constants.Response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = BaseResponse.class)
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(value = Exception.class)

    public ResponseEntity<ResponseResult> error(HttpServletRequest request, Exception throwable) {
        ResponseResult resp = new ResponseResult();

        ResponseEntity<ResponseResult> responseEntity = null;

        // 请求参数错误返回
        if (throwable instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) throwable;

            StringBuilder result = new StringBuilder();
            for (ObjectError error : e.getBindingResult().getAllErrors()) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    result.append(error.getDefaultMessage());
                }
            }

            resp.setCode(ResponseCode.INVALID_PARAM.getCode());
            resp.setMessage(result.toString());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.OK);
        } else if (throwable instanceof MethodArgumentTypeMismatchException) {
            resp.setCode(ResponseCode.INVALID_PARAM.getCode());
            resp.setMessage(ResponseCode.INVALID_PARAM.getMessage());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.OK);
        } else if (throwable instanceof MissingServletRequestParameterException) {
            // 参数缺省

            resp.setCode(ResponseCode.LACK_PARAM.getCode());
            resp.setMessage(ResponseCode.LACK_PARAM.getMessage());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.OK);
        }
        // 业务错误返回
        else if (throwable instanceof ResponseException) {

            ResponseException be = (ResponseException) throwable;
            resp.setCode(be.getCode().getCode());
            resp.setMessage(be.getMessage());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.OK);
        } else if (throwable instanceof HttpRequestMethodNotSupportedException) {

            // 请求方法错误

            resp.setCode(ResponseCode.METHOD_NOT_ALLOWED.getCode());
            resp.setMessage(ResponseCode.METHOD_NOT_ALLOWED.getMessage());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.METHOD_NOT_ALLOWED);
        } else if (throwable instanceof NoHandlerFoundException) {
            // Not found返回

            NoHandlerFoundException e = (NoHandlerFoundException) throwable;
            resp.setCode(ResponseCode.RESPONSE_NOT_FOUND.getCode());
            resp.setMessage(ResponseCode.RESPONSE_NOT_FOUND.getMessage() + ":" + e.getHttpMethod() + " " + e.getRequestURL());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.NOT_FOUND);
        } else {
            // 系统出错返回

            resp.setCode(ResponseCode.RESPONSE_SERVER_ERROR.getCode());
            resp.setMessage(ResponseCode.RESPONSE_SERVER_ERROR.getMessage());
            responseEntity = new ResponseEntity<ResponseResult>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(MediaType.APPLICATION_JSON.equals(selectedContentType) || MediaType.APPLICATION_JSON_UTF8.equals(selectedContentType)){ // 判断响应的Content-Type为JSON格式的body
            if(body instanceof ResponseResult){ // 如果响应返回的对象为统一响应体，则直接返回body
                return body;
            }else{
                // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                ResponseResult responseResult =new ResponseResult(ResponseCode.RESPONSE_SUCCESS.getCode(),body,ResponseCode.RESPONSE_SUCCESS.getMessage());
                return responseResult;
            }
        }
        // 非JSON格式body直接返回即可
        return body;
    }
}

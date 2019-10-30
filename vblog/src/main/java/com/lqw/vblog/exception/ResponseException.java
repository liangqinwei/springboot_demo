package com.lqw.vblog.exception;

import com.lqw.vblog.constants.Response.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseException extends RuntimeException{

    private ResponseCode code;

    public ResponseException(ResponseCode code){
        this.code=code;
    }

    public ResponseException(Throwable cause,ResponseCode code){
        super(cause);
        this.code=code;
    }

}


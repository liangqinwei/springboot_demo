//package com.lqw.vblog.entity.ExceptionEntity;
//
//import com.alibaba.fastjson.JSON;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.lqw.vblog.constants.Response.ResponseStatus;
//import com.lqw.vblog.exception.ResponseException;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
//public class ResponseEntity implements Serializable {
//    private Integer code = 200;
//    private String msg = "ok";
//    private Object data = null;
//
//    public static ResponseEntity ERROR(String msg) {
//        return (new ResponseEntity()).setCode(500).setMsg(msg).setData("");
//    }
//
//    public ResponseEntity(ResponseException exception) {
//        this.code = exception.getResponseStatus().getCode();
//        this.msg = exception.getMessage();
//    }
//
//    public ResponseEntity(int code,String message) {
//        this.code = code;
//        this.msg = message;
//    }
//
//    public <T extends ResponseStatus> ResponseEntity(T status) {
//        this.code = status.getCode();
//        this.msg = status.getMessage();
//    }
//
//    public <T extends ResponseStatus> ResponseEntity(T status, String msg) {
//        this.code = status.getCode();
//        this.msg = msg;
//    }
//
//    public ResponseEntity(int code,Object data, String message) {
//        this.data = data;
//        this.msg=message;
//        this.code=code;
//    }
//
//    public ResponseEntity(Object data) {
//        this.data = data;
//
//    }
//
//    public ResponseEntity() {
//    }
//
//    public Integer getCode() {
//        return this.code;
//    }
//
//    public ResponseEntity setCode(Integer code) {
//        this.code = code;
//        return this;
//    }
//
//    public String getMsg() {
//        return this.msg;
//    }
//
//    public ResponseEntity setMsg(String msg) {
//        this.msg = msg;
//        return this;
//    }
//
//    public Object getData() {
//        return this.data;
//    }
//
//    public ResponseEntity setData(Object data) {
//        this.data = data;
//        return this;
//    }
//
//    public Map<String, Object> toMap() {
//        Map<String, Object> response = new HashMap();
//        response.put("code", this.code);
//        response.put("msg", this.msg);
//        if (null != this.data) {
//            response.put("data", this.data);
//        }
//
//
//        return response;
//    }
//
//
//    public String toString() {
//        return JSON.toJSONString(this.toMap());
//    }
//
//}

package com.lqw.vblog.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基本返回体
 *
 * @author lqw
 * @date 2019/9/6
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class ResponseResult implements Serializable {



    /**
     * 返回码，详见MessageCode.java
     */
    private int code;

    /**
     * 业务内容
     */
    private Object data;

    /**
     * 错误提示
     */
    private String message;

}

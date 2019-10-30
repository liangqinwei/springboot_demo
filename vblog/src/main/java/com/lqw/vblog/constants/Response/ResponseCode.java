package com.lqw.vblog.constants.Response;



public enum ResponseCode{

    /**
     * 通用响应
     */
    RESPONSE_TEXT(100,"请把信息反馈给用户"),
    RESPONSE_LINK(101,"建议跳转至新地址"),
    RESPONSE_IMAGE(102,"建议显示图片"),
    RESPONSE_SUCCESS(200,"success"),
    RESPONSE_NOT_MODIFIED(304,"nothing change"),
    RESPONSE_NOT_AUTHORIZED(401,"授权未通过"),
    RESPONSE_FORBIDDEN(403,"禁止访问."),
    RESPONSE_NOT_FOUND(404,"请求的资源不存在"),
    RESPONSE_SERVER_ERROR(500,"服务器内部错误"),
    RESPONSE_SERVER_Validate_ERROR(50001,"服务器内部错误"),
    INVALID_PARAM(4001001, "无效参数"),
    LACK_PARAM(4001002, "缺少参数"),
    AUTH_FAILED(401, "请求未认证，跳转登录页"),

    MOBILE_NOT_REGISTER(402, "请正确填写已登记的手机号码"),

    METHOD_NOT_ALLOWED(405, "请求方法错误")

    /**
     * 维修服务响应
     */
    ,RESPONSE_INSURANCE_EMPTY(60000,"空应答")

    ,RESPONSE_VEHICLE_NOT_FOUND(60001,"找不到车辆")
    ,RESPONSE_DATE_FORMAT_ERROR(60002,"日期格式异常，请使用yyyy-MM-dd")

    ,RESPONSE_INSURANCE_COMPANY_NOT_FOUND(60003,"找不到保险公司")
    ,RESPONSE_INCOMPLETE_DATA(60004,"同步数据不完整")
    ,RESPONSE_POLICYNO_EXIT(60005,"保单已经存在")

    ,RESPONSE_PACIFIC_INSURANCE_POLICY_ERROR(61101,"太平洋保险保单接口异常")
    ,RESPONSE_AXATP_INSURANCE_POLICY_ERROR(61201,"安盛保险保单接口异常")

    ,RESPONSE_PACIFIC_CASE_REAPEAT_ERROR(62001,"同一时间仅允许一个报案.")
    ,RESPONSE_PACIFIC_CASE_TIME_FORMAT_ERROR(62002,"报案时间格式异常.")
    ,RESPONSE_PACIFIC_CASE_ERROR(62003,"P17报案接口异常")
    ,RESPONSE_PACIFIC_CLAIM_ERROR(62004,"查询理赔进度异常.")
    ,RESPONSE_PACIFIC_CASE_CANCEL_ERROR(62005,"取消报案异常.")
    ,RESPONSE_PACIFIC_IMAGE_UPLOAD_ERROR(62006,"影像上传异常.")
    ,RESPONSE_PACIFIC_CASE_NO_LOSE(62007,"请求参数缺失.")
    ,RESPONSE_PACIFIC_CANCEL_STATUS_ERROR(62008,"不能注销已经结案的报案.")
    ,RESPONSE_PACIFIC_USER_NOT_FOUND(62009,"找不到用户信息")
    ,RESPONSE_PACIFIC_COMPRESSION_ERROR(62010,"压缩图片出错")
    ,RESPONSE_PACIFIC_SIGN_VERIFY_ERROR(62011,"通知验签失败")
    ;

    private int code;

    private String message;


    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据状态码获取反馈
     * @param code 状态码
     * @return 反馈体
     */
    static public ResponseCode get(int code){
        ResponseCode[] responseStatuses = values();
        for (ResponseCode responseStatus : responseStatuses) {
            if(responseStatus.getCode() == code){
                return responseStatus;
            }
        }
        return null;
    }

    /**
     * 根据CODE获取消息
     * @param code 状态码
     * @return 文案
     */
    static public String getMessage(int code) {
        ResponseCode[] responseStatuses = values();
        for (ResponseCode responseStatus : responseStatuses) {
            if(responseStatus.getCode() == code){
                return responseStatus.getMessage();
            }
        }
        return "";
    }


    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}

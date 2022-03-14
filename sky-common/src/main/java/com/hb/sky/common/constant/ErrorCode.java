package com.hb.sky.common.constant;


import com.hb.sky.common.standard.IErrorCode;

/**
 * 返回码
 *
 * @version v0.1, 2021/8/22 18:42, create by huangbiao.
 */
public enum ErrorCode implements IErrorCode {

    SUCCESS("10000", "成功"),

    REQUIRED_PARAM_NULL("90001", "必填参数为空"),
    PAGE_PARAM_ERROR("90002", "分页参数错误"),
    RECORD_REPEAT("90003", "已存在唯一性相同的记录"),
    INVALID_ORIGIN("90100", "Invalid Origin"),
    REQUEST_TOO_FREQUENTLY("90200", "亲，手速太快了！"),
    ERROR("99999", "系统异常，请稍后再试！"),
    ;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}

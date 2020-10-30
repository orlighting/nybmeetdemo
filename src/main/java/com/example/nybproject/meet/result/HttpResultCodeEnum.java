package com.example.nybproject.meet.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhaoDesong
 * @date 2020/10/30 16:15
 */
@Getter
@AllArgsConstructor
public enum HttpResultCodeEnum {

    /**
     * 通用部分
     */
    SUCCESS(0,"成功"),
    SYSTEM_ERROR(1001,"系统错误"),
    /**
     * 登录相关
     */
    LOGIN_FAIL(2001,"账号或密码错误"),
    /**
     * 账户相关
     */
    ACCOUNT_REGISTER_ID_CARD_REPEAT(3001,"身份证号已被注册"),
    ACCOUNT_REGISTER_MOBILE_REPEAT(3002,"手机号已被注册"),
    /**
     * TODO　待补充完整
     */
    ;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
}

package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;


/**
 * 用户类
 */
@Data
public class User {

    /**
     * 本用户的id
     */
    private Integer id;

    /**
     * 用户类型（省部级[0]、事业单位[1]、涉外展会负责单位[2]）
     */
    private Integer kind;

    /**
     * 用户账号审核状态（未审核[0]、已通过[1]、未通过[2]）
     */
    private Integer checkState;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String teleNum;

    /**
     * 用户所属单位
     */
    private String company;

    /**
     * 用户所属部门
     */
    private String department;

    /**
     * 用户电子邮箱
     */
    private String email;

    /**
     * 用户传真号
     */
    private String portraiture;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 记录是否被删除
     */
    private Boolean delete;

}

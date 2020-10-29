package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;


//用户类
@Data
public class User {

    /**
     * 本用户的id
     */
    Integer id;

    /**
     * 用户类型（省部级[0]、事业单位[1]、涉外展会负责单位[2]）
     */
    Integer kind;

    /**
     * 用户账号审核状态（未审核[0]、已通过[1]、未通过[2]）
     */
    Integer checkstate;

    /**
     * 用户密码
     */
    String password;

    /**
     * 用户真实姓名
     */
    String name;

    /**
     * 电话号码
     */
    String telenum;

    /**
     * 用户所属单位
     */
    String company;

    /**
     * 用户所属部门
     */
    String department;

    /**
     * 用户电子邮箱
     */
    String email;

    /**
     * 用户传真号
     */
    String portraiture;

    /**
     * 身份证号
     */
    String identitycard;

    /**
     * 记录创建时间
     */
    LocalDateTime createtime;

    /**
     * 记录更新时间
     */
    LocalDateTime updatetime;

    /**
     * 记录是否被删除
     */
    boolean delete;

}

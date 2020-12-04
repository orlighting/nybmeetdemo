package com.example.nybproject.meet.pojo;


import lombok.*;

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
     * 展会简称
     */
    private String meetAddr;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String name;

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

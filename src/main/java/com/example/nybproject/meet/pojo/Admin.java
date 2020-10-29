package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * 管理员类
 */
@Data
public class Admin {

    /**
     * 管理员的id
     */
    private Integer id;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String teleNum;

    /**
     * 部门
     */
    private String department;

    /**
     * 身份证号
     */
    private String identityNum;

    /**
     * 记录的创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录的更新时间
     */
    private LocalDateTime updateTime;

}

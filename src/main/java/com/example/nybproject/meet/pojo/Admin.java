package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;


//管理员类
@Data
public class Admin {

    /**
     * 管理员的id
     */
    Integer id;

    /**
     * 管理员密码
     */
    String password;

    /**
     * 电话号码
     */
    String teleNum;

    /**
     * 部门
     */
    String department;

    /**
     * 身份证号
     */
    String identityNum;

    /**
     * 记录的创建时间
     */
    LocalDateTime createTime;

    /**
     * 记录的更新时间
     */
    LocalDateTime updateTime;

}

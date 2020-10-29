package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;


//管理员类
@Data
public class Admin {

    Integer id;
    String password, telenum, department, identitynum;
    LocalDateTime createtime, updatetime;

}

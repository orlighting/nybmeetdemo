package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;


//用户类
@Data
public class User {

    String password, name, telenum, company, department, email, portraiture, identitycard;
    //kind 对应用户类型（省部级[0]、事业单位[1]、涉外展会负责单位[2]）,checkstate 对应用户账号审核状态（未审核[0]、已通过[1]、未通过[2]）
    Integer id, kind, checkstate;
    LocalDateTime createtime,updatetime;
    boolean delete;

}

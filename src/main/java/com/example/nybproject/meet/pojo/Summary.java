package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data

//总结报告类
public class Summary {

    //userid 对应总结申请人id，kind 对应总结类型（事业单位提交[0]，省部级提交[1]，涉外展会负责单位提交[2]）
    Integer id, userid, adminid, kind, countrynum, conpanynum, area, buyernum, medianum, turnover;
    LocalDateTime createtime, updatetime;
    boolean delete;

}

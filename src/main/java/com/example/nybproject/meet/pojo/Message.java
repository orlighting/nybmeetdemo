package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;


//消息类
@Data
public class Message {

    Integer id, adminid, userid;
    String title, content;
    LocalDateTime createtime, updatetime;
    //looked对应消息是否被浏览，未读[0], 已读[1]
    boolean looked, delete;

}

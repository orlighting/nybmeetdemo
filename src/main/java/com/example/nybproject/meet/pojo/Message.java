package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;


//消息类
@Data
public class Message {

    /**
     * 本消息的id
     */
    Integer id;

    /**
     * 发出本消息的管理员的id
     */
    Integer adminId;

    /**
     * 收到本消息的用户的id
     */
    Integer userId;

    /**
     * 消息标题
     */
    String title;

    /**
     * 消息内容
     */
    String content;

    /**
     * 记录创建时间
     */
    LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    LocalDateTime updateTime;

    /**
     * 消息是否被浏览
     */
    boolean looked;

    /**
     * 记录是否被删除
     */
    boolean delete;

}

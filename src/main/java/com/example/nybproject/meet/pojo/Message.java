package com.example.nybproject.meet.pojo;

import lombok.*;

import java.time.LocalDateTime;


/**
 * 消息类
 */
@Data
public class Message {

    /**
     * 本消息的id
     */
    private Integer id;

    /**
     * 发出本消息的管理员的id
     */
    private Integer adminId;

    /**
     * 收到本消息的用户的id
     */
    private Integer userId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 消息是否被浏览
     */
    private Boolean looked;

    /**
     * 记录是否被删除
     */
    private Boolean delete;

}

package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;


/**
 * 简易申报类
 */
@Data
public class EasyMeet {

    /**
     * 本简易表单的id
     */
    private Integer id;

    /**
     * 本简易表单对应的详细展会表单的id
     */
    private Integer dmeetId;

    /**
     * 提交该表单的用户的id
     */
    private Integer userId;

    /**
     * 审核该表单的管理员的id
     */
    private Integer adminId;

    /**
     * 目前展会计划的审核状态（审核中[0]、已通过[1]、未通过，重新提交[2]）
     */
    private Integer checkState;

    /**
     * 展会名称
     */
    private String name;

    /**
     * 主办单位
     */
    private String host;

    /**
     * 举办地点
     */
    private String place;

    /**
     * 备注
     */
    private String ps;

    /**
     * 举办时间
     */
    private LocalDateTime time;

    /**
     * 记录的创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录的更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 记录是否被删除
     */
    private Boolean delete;

}

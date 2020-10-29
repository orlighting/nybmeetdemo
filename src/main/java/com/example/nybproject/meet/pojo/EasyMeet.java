package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


//简易申报类
@Data
public class EasyMeet {

    /**
     * 本简易表单的id
     */
    Integer id;

    /**
     * 本简易表单对应的详细展会表单的id
     */
    Integer dmeetId;

    /**
     * 提交该表单的用户的id
     */
    Integer userId;

    /**
     * 审核该表单的管理员的id
     */
    Integer adminId;

    /**
     * 目前展会计划的审核状态（审核中[0]、已通过[1]、未通过，重新提交[2]）
     */
    Integer checkState;

    /**
     * 展会名称
     */
    String name;

    /**
     * 主办单位
     */
    String host;

    /**
     * 举办地点
     */
    String place;

    /**
     * 备注
     */
    String ps;

    /**
     * 举办时间
     */
    LocalDateTime time;

    /**
     * 记录的创建时间
     */
    LocalDateTime createTime;

    /**
     * 记录的更新时间
     */
    LocalDateTime updateTime;

    /**
     * 记录是否被删除
     */
    Boolean delete;

}

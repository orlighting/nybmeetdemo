package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;


/**
 * 简易申报类
 */
@Data
public class EasyMeet {

    /**
     * 本详细申报的id
     */
    private Integer id;

    /**
     * 展会简称
     */
    private String meetAddr;

    /**
     * 审核该表单的管理员的id
     */
    private Integer adminId;

    /**
     * 展会名称
     */
    private String name;

    /**
     * 主办单位
     */
    private String hostComp;

    /**
     * 承办单位
     */
    private String fundComp;

    /**
     * 协办单位
     */
    private String supportComp;

    /**
     * 批准单位
     */
    private String authObj;

    /**
     * 批准文案
     */
    private String authNum;

    /**
     * 举办地点
     */
    private String place;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 展览面积
     */
    private Integer area;

    /**
     * 展会内容
     */
    private String meetState;

    /**
     * 是否邀请境外参展商或有关机构
     */
    private Boolean foreign;

    /**
     * 是否有采购商参加
     */
    private Boolean view1;

    /**
     * 是否有消费者参加
     */
    private Boolean view2;

    /**
     * 经费来源（财政拨款[0], 个人筹款[1], 财政拨款+个人筹款[2]）
     */
    private Integer finanFrom;

    /**
     * 经费数额（单位：万元）
     */
    private Integer finanFund;

    /**
     * 出席领导情况
     */
    private Integer leaderState;

    /**
     * 展会内容简述
     */
    private String activityBrief;

    /**
     * 招展招商方案文档id
     */
    private String investmentPlanFileId;

    /**
     * 展会工作方案文档id
     */
    private String meetPlanFileId;

    /**
     * 上级单位审核意见文件id
     */
    private String authFileId;

    /**
     * 审核状态（“审核中[0]”、“已通过，展会计划待过会[1]”、“已通过，展会计划已印发[2]”、“未通过，返回修改[3]”）
     */
    private Integer checkState;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 该记录是否被删除
     */
    private Boolean delete;

}

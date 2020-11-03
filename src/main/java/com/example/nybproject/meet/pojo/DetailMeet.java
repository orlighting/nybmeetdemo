package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailMeet {

    /**
     * 本详细申报的id
     */
    private Integer id;

    /**
     * 提交该表单的用户的id
     */
    private Integer userId;

    /**
     * 审核该表单的管理员的id
     */
    private Integer adminId;

    /**
     * 财政资金的拨款金额
     */
    private Integer finanFund;

    /**
     * 其他来源的拨款金额
     */
    private Integer otherFund;

    /**
     * 目前展会计划的审核状态（审核中[0]、“已通过，展会计划待过会”[1]、“已通过，展会计划已印发”[2]、"未通过，重新提交"[3]）
     */
    private Integer checkState;

    /**
     * 展会面积
     */
    private Integer area;

    /**
     * 国内参展商所占比例（单位：%）
     */
    private Integer domestic;

    /**
     * 国外参展商所占比例（单位：%）
     */
    private Integer foreign;

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
     * 举办周期
     */
    private String cycle;

    /**
     * 展会内容
     */
    private String content;

    /**
     * 财政资金的拨款单位
     */
    private String finanFrom;

    /**
     * 其他资金的资金来源
     */
    private String otherFrom;

    /**
     * 展会内容简述
     */
    private String declare;

    /**
     * 往届展会情况文档id
     */
    private String preExpoFileId;

    /**
     * 招商方案文档id
     */
    private String investmentPlanFileId;

    /**
     * 举办时间
     */
    private LocalDateTime time;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否有采购商参加
     */
    private Boolean view1;

    /**
     * 是否有消费者参加
     */
    private Boolean view2;

    /**
     * 是否有党和国家领导人出席
     */
    private Boolean leaderD;

    /**
     * 是否邀请境外部级以上政要出席
     */
    private Boolean leaderF;


    /**
     * 该记录是否被删除
     */
    private Boolean delete;

}

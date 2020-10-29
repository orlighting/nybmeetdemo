package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DetailMeet {

    /**
     * 本详细申报的id
     */
    Integer id;

    /**
     * 提交该表单的用户的id
     */
    Integer userId;

    /**
     * 审核该表单的管理员的id
     */
    Integer adminId;

    /**
     * 财政资金的拨款金额
     */
    Integer finanFund;

    /**
     * 其他来源的拨款金额
     */
    Integer otherFund;

    /**
     * 目前展会计划的审核状态（审核中[0]、“已通过，展会计划待过会”[1]、“已通过，展会计划已印发”[2]、"未通过，重新提交"[3]）
     */
    Integer checkState;

    /**
     * 展会面积
     */
    Integer area;

    /**
     * 国内参展商所占比例（单位：%）
     */
    Integer domestic;

    /**
     * 国外参展商所占比例（单位：%）
     */
    Integer foreign;

    /**
     * 展会名称
     */
    String name;

    /**
     * 主办单位
     */
    String hostComp;

    /**
     * 承办单位
     */
    String fundComp;

    /**
     * 批准单位
     */
    String authObj;

    /**
     * 批准文案
     */
    String authNum;

    /**
     * 举办地点
     */
    String place;

    /**
     * 举办周期
     */
    String cycle;

    /**
     * 展会内容
     */
    String content;

    /**
     * 财政资金的拨款单位
     */
    String finanFrom;

    /**
     * 其他资金的资金来源
     */
    String otherFrom;

    /**
     * 展会内容简述
     */
    String declare;

    /**
     * 举办时间
     */
    LocalDateTime time;

    /**
     * 记录创建时间
     */
    LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    LocalDateTime updateTime;

    /**
     * 是否有采购商参加
     */
    Boolean view1;

    /**
     * 是否有消费者参加
     */
    Boolean view2;

    /**
     * 是否有党和国家领导人出席
     */
    Boolean leaderD;

    /**
     * 是否邀请境外部级以上政要出席
     */
    Boolean leaderF;


    /**
     * 该记录是否被删除
     */
    Boolean delete;

}

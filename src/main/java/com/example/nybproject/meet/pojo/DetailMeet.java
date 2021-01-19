package com.example.nybproject.meet.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailMeet {

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
     * 指导单位
     */
    private String orderComp;

    /**
     * 批准单位
     */
    private String authObj;

    /**
     * 批准文案
     */
    private String authNum;

    /**
     * 举办城市
     */
    private String chooseCity;

    /**
     * 举办地点
     */
    private String place;

    /**
     * 举办周期（单位：次/年）
     */
    private String cycle;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

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
     * 经费来源（财政拨款[0], 个人筹款[1], 财政拨款+个人筹款[2]）已无效
     */
    private Integer finanFrom;

    /**
     * 财政资金经费数额（单位：万元）
     */
    private Integer finanFund;

    /**
     * 自筹资金经费数额（单位：万元）
     */
    private Integer selfFund;

    /**
     * 出席领导情况
     */
    private Integer leaderState;

    /**
     * 展会内容简述
     */
    private String activityBrief;

    /**
     * 填写单位
     */
    private String writeObject;

    /**
     * 负责处室
     */
    private String department;

    /**
     * 负责人
     */
    private String charger;

    /**
     * 电话号码
     */
    private String teleNum;

    /**
     * 招展招商方案文档id
     */
    private String investmentPlanFileId;

    /**
     * 可行性报告文档id
     */
    private String feasibilityFileId;

    /**
     * 展会工作方案文档id
     */
    private String meetPlanFileId;

    /**
     * 承办单位办展条件说明文档id
     */
    private String conditionStateFileId;

    /**
     * 上级单位审核意见文件id
     */
    private String authFileId;

    /**
     * 是否完成总结提交
     */
    private Boolean summaryDone;

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

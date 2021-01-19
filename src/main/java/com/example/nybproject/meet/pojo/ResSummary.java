package com.example.nybproject.meet.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResSummary {

    /**
     * 本总结的id
     */
    private Integer id;

    /**
     * 本总结对应展会申报的id
     */
    private Integer meetId;

    /**
     * 审核本总结管理员的id（目前不需要审核，先放着）
     */
    private Integer adminId;

    /**
     * 展会简称
     */
    private String meetAddr;

    /**
     * 参展国家地区数量
     */
    private Integer countryNum;

    /**
     * 参展省市自治区情况
     */
    private String provinceState;

    /**
     * 参展商数量
     */
    private Integer companyNum;

    /**
     * 展会面积
     */
    private Integer area;

    /**
     * 参展产品
     */
    private String displayObj;

    /**
     * 展会商数量
     */
    private Integer buyerNum;

    /**
     * 参展媒体数
     */
    private Integer mediaNum;

    /**
     * 最终成交额（含意向）
     */
    private Integer turnover;

    /**
     * 线上成交额
     */
    private Integer onlineTurnover;

    /**
     * 线上观展人数
     */
    private Integer onlineViewer;

    /**
     * 观展总人数
     */
    private Integer viewerNum;

    /**
     * 同期活动数量
     */
    private Integer activityNum;

    /**
     * 展会亮点
     */
    private String meetHighlight;

    /**
     * 下一步工作计划
     */
    private String nextWorkPlan;

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
     * 总结报告id
     */
    private String summaryFileId;

    /**
     * 单位主要负责同志签发页id
     */
    private String hosterSignFileId;

    /**
     * 总结类型（事业单位提交[0]，省部级提交[1]，涉外展会负责单位提交[2]）
     */
    private Integer kind;

    /**
     * 记录是否被删除
     */
    private Boolean delete;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 总结报告
     */
    MultipartFile summaryFile;

    /**
     * 单位主要负责同志签发页
     */
    MultipartFile hosterSignFile;

}

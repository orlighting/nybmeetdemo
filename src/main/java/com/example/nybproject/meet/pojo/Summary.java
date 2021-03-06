package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 总结报告类
 */
@Data
public class Summary {

    /**
     * 本总结的id
     */
    private Integer id;

    /**
     * 总结申请用户的id
     */
    private Integer userId;

    /**
     * 审核本总结管理员的id（目前不需要审核，先放着）
     */
    private Integer adminId;

    /**
     * 总结类型（事业单位提交[0]，省部级提交[1]，涉外展会负责单位提交[2]）
     */
    private Integer kind;

    /**
     * 参展国家地区数量
     */
    private Integer countryNum;

    /**
     * 参展商数量
     */
    private Integer companyNum;

    /**
     * 展会面积
     */
    private Integer area;

    /**
     * 展会商数量
     */
    private Integer buyerNum;

    /**
     * 参展媒体数
     */
    private Integer mediaNum;

    /**
     * 最终成交额
     */
    private Integer turnover;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 记录是否被删除
     */
    private Boolean delete;

}

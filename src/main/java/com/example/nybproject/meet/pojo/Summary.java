package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data

//总结报告类
public class Summary {

    /**
     * 本总结的id
     */
    Integer id;

    /**
     * 总结申请用户的id
     */
    Integer userId;

    /**
     * 审核本总结管理员的id（目前不需要审核，先放着）
     */
    Integer adminId;

    /**
     * 总结类型（事业单位提交[0]，省部级提交[1]，涉外展会负责单位提交[2]）
     */
    Integer kind;

    /**
     * 参展国家地区数量
     */
    Integer countryNum;

    /**
     * 参展商数量
     */
    Integer conpanyNum;

    /**
     * 展会面积
     */
    Integer area;

    /**
     * 展会商数量
     */
    Integer buyerNum;

    /**
     * 参展媒体数
     */
    Integer mediaNum;

    /**
     * 最终成交额
     */
    Integer turnover;

    /**
     * 记录创建时间
     */
    LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    LocalDateTime updateTime;

    /**
     * 记录是否被删除
     */
    Boolean delete;

}

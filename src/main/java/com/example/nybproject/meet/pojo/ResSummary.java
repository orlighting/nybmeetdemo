package com.example.nybproject.meet.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class ResSummary {

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
     * 总结报告id
     */
    private String summaryFileId;

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

    /**
     * 总结报告
     */
    MultipartFile summaryFile;

}

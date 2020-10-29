package com.example.nybproject.meet.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DetailMeet {

    //userid 对应提交该表单的用户的id，adminid 对应审核该表单的管理员的id
    //checkstate 对应目前展会计划的审核状态（审核中[0]、“已通过，展会计划待过会”[1]、“已通过，展会计划已印发”[2]、"未通过，重新提交"[3]）
    Integer id, userid, adminid, finanfond, otherfond, checkstate, area;
    String name, hostcomp, fondcomp, authobj, authnum, place, cycle, content, finanfrom, otherfrom, declare;
    Date time;
    LocalDateTime createtime, updatetime;
    boolean delete, view1, view2, leaderN, leaderF;

}

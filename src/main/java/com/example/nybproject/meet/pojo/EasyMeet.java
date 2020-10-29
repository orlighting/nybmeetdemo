package com.example.nybproject.meet.pojo;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


//简易申报类
@Data
public class EasyMeet {

    //dmeetid 为对应展会计划的详细展会表单id，userid 对应提交该表单的用户的id，adminid 对应审核该表单的管理员的id
    //checkstate 对应目前展会计划的审核状态（审核中[0]、已通过[1]、未通过，重新提交[2]）
    Integer id, dmeetid, userid, adminid, checkstate;
    String name, host, place, ps;
    Date time;
    LocalDateTime createtime, updatetime;
    boolean delete;

}

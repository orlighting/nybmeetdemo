package com.example.nybproject.meet.service;

import com.example.nybproject.meet.mapper.*;
import com.example.nybproject.meet.pojo.DetailMeet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IdGenerater {

    /**
     * 当前最新的简易申报id
     */
    private Integer easyMeetIdNow;

    /**
     * 当前最新的详细申报id
     */
    private Integer detailMeetIdNow;

    /**
     * 当前最新的用户id
     */
    private Integer userIdNow;

    /**
     * 当前最新的信息id
     */
    private Integer messageIdNow;

    /**
     * 当前最新的总结报告id
     */
    private Integer summaryIdNow;

    @Resource
    EasyMapper easyMapper;
    @Resource
    DetailMapper detailMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    MessageMapper messageMapper;
    @Resource
    SummaryMapper summaryMapper;


    public Integer getEasyMeetIdNow(){

        if(easyMeetIdNow == null){
            easyMeetIdNow = easyMapper.findNewId();
        }

        easyMeetIdNow++;

        return easyMeetIdNow;
    }

    Integer getDetailMeetIdNow(){
        if(detailMeetIdNow == null){
            detailMeetIdNow = detailMapper.findNewId();
        }

        detailMeetIdNow++;

        return detailMeetIdNow;
    }

    Integer getUserIdNow(){
        if(userIdNow == null){
            userIdNow = userMapper.findNewId();
        }

        userIdNow++;

        return userIdNow;
    }

    Integer getMessageIdNow(){
        if(messageIdNow == null){
            messageIdNow = messageMapper.findNewId();
        }

        messageIdNow++;

        return messageIdNow;
    }

    Integer getSummaryIdNow(){
        if(summaryIdNow == null){
            summaryIdNow = summaryMapper.findNewId();
        }

        summaryIdNow++;

        return summaryIdNow;
    }


}

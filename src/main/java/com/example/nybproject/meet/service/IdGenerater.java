package com.example.nybproject.meet.service;

import com.example.nybproject.meet.mapper.UserMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Data
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
    UserMapper userMapper;

    Integer getNewEasyMeetId(){

        if(userIdNow == null){
            userIdNow = userMapper.findNewId();
        }

        userIdNow++;

        return userIdNow;
    }

}

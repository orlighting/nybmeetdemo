package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.EasyMeet;

import java.time.LocalDateTime;
import java.util.List;

public interface EasyMapper {

    int add(EasyMeet easyMeet);
    Integer findNewId();
    List<EasyMeet> findAllNotCheckEasy();
    int checkEasyMeet(Integer id, Integer checkState, Integer adminId, LocalDateTime updateTime);
    EasyMeet findById(Integer id);

}


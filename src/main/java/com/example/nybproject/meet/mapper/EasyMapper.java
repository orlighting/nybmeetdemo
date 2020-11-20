package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.EasyMeet;

import java.time.LocalDateTime;
import java.util.List;

public interface EasyMapper {

    int add(EasyMeet easyMeet);

    int checkEasyMeet(Integer id, Integer checkState, Integer adminId, LocalDateTime updateTime);

    EasyMeet findsById(Integer id);

    List<EasyMeet> findAllNotCheckEasy();

    List<EasyMeet> findsByUserId(Integer userId);

    List<EasyMeet> findsAll();

    Integer findNewId();


}


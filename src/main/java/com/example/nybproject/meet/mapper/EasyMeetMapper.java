package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.EasyMeet;

import java.util.List;

public interface EasyMeetMapper {


    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param easymeet easymeet
     * @return count
     */
    int saveSelective(EasyMeet easymeet);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param easymeet easymeet
     * @return count
     */
    int updateByPrimaryKeySelective(EasyMeet easymeet);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    EasyMeet getByPrimaryKey(Integer id);

    EasyMeet findsLatest(String meetAddr);

    int checkEasyMeet(Integer id, Integer checkState, Integer adminId);

    List<EasyMeet> findAllNotCheckEasy();

    List<EasyMeet> findsByUserId(Integer userId);

    List<EasyMeet> findsAll();

}


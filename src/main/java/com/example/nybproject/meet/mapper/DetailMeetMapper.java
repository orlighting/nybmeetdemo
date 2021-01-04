package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.DetailMeet;

import java.util.List;

public interface DetailMeetMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param detailmeet detailmeet
     * @return count
     */
    int saveSelective(DetailMeet detailmeet);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param detailmeet detailmeet
     * @return count
     */
    int updateByPrimaryKeySelective(DetailMeet detailmeet);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    DetailMeet getByPrimaryKey(Integer id);

    DetailMeet findsLatest(String meetAddr);

    List<DetailMeet> findsByMeetAddr(String meetAddr);

    List<DetailMeet> findAllNotCheck();

    List<DetailMeet> findsAll();

    int checkDetailMeet(Integer id, Integer checkState, Integer adminId);

    List<DetailMeet> selectByKeyValue(DetailMeet detailMeet);
}

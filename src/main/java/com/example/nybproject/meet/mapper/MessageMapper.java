package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.Message;

import java.util.List;

public interface MessageMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param message message
     * @return count
     */
    int saveSelective(Message message);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param message message
     * @return count
     */
    int updateByPrimaryKeySelective(Message message);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    Message getByPrimaryKey(Integer id);

    List<Message> findsLookedMessage(Integer userId);

    List<Message> findsNotLookMessage(Integer userId);

    int updateNotLookMessageLooked(List<Integer> ids);

    int deleteMessageById(Integer id);
}

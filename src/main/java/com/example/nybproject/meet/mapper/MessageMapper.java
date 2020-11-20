package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.Message;

import java.util.List;

public interface MessageMapper {

    int add(Message message);

    Message findsById(Integer id);

    List<Message> findsLookedMessage(Integer userId);

    List<Message> findsNotLookMessage(Integer userId);

    int updateNotLookMessageLooked(List<Integer> ids);

    Integer findNewId();

    int deleteMessageById(Integer id);
}

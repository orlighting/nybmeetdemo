package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.Message;

import java.util.List;

public interface MessageMapper {

    Message findById(Integer id);
    List<Message> findByUserId(Integer userId);
}

package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.User;

import java.util.List;

public interface UserMapper {

    User findsById(Integer id);
    Integer findNewId();
    List<User> findAll();

    int add(User user);

}

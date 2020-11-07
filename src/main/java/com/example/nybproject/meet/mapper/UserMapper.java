package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.User;

import java.util.List;

public interface UserMapper {

    int add(User user);

    User findsById(Integer id);

    List<User> findAll();

    Integer findsByIdentityCard(String identityCard);

    Integer findsByTeleNum(String teleNum);

    Integer findNewId();


}

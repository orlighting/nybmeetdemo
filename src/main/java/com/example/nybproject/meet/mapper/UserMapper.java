package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserMapper {

    User findsById(Integer id);
    Integer findNewId();
    List<User> findAll();
    Integer findsByIdentityCard(String identityCard);
    Integer findsByTeleNum(String teleNum);

    int add(User user);

}

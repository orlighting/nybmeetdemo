package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param user user
     * @return count
     */
    int saveSelective(User user);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param user user
     * @return count
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    User getByPrimaryKey(Integer id);

    List<User> findAll();

    Integer findsByIdentityCard(String identityCard);

    Integer findsByTeleNum(String teleNum);

}

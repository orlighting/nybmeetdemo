package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.DetailMeet;

import java.util.List;

public interface DetailMapper {

    int add(DetailMeet detailMeet);

    DetailMeet findsById(Integer id);
    List<DetailMeet> findsByUserId(Integer userId);

    Integer findNewId();
}

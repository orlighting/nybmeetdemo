package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.DetailMeet;

public interface DetailMapper {

    int add(DetailMeet detailMeet);

    Integer findNewId();
}

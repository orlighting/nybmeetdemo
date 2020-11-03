package com.example.nybproject.meet.mapper;


import com.example.nybproject.meet.pojo.Summary;

public interface SummaryMapper {

    Summary findById(Integer id);
    Integer findNewId();
}

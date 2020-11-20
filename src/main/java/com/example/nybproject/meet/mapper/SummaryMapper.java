package com.example.nybproject.meet.mapper;


import com.example.nybproject.meet.pojo.Summary;

import java.util.List;

public interface SummaryMapper {

    Summary findById(Integer id);

    int add(Summary summary);

    Integer findNewId();

    List<Summary> findsAll();
}

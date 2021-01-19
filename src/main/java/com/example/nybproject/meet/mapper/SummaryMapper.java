package com.example.nybproject.meet.mapper;


import com.example.nybproject.meet.pojo.Summary;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;

import java.util.List;

public interface SummaryMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param summary summary
     * @return count
     */
    int saveSelective(Summary summary);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param summary summary
     * @return count
     */
    int updateByPrimaryKeySelective(Summary summary);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    Summary getByPrimaryKey(Long id);

    List<Summary> findsAll();

    List<Summary> selectByKeyValue();

}

package com.example.nybproject.meet.mapper;

import com.example.nybproject.meet.pojo.DetailMeet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ZhaoDesong
 * @date 2020/11/7 9:25
 */
@SpringBootTest
class DetailMeetMapperTest {
    @Resource
    private DetailMeetMapper detailMeetMapper;

    @Test
    void add() {

    }

    @Test
    void findsById() {
        DetailMeet detailMeet = detailMeetMapper.getByPrimaryKey(102000000);
        System.out.println(detailMeet);
    }

    @Test
    void findsByUserId() {
    }

    @Test
    void findNewId() {
    }
}
package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
//10.29 完成第一版，id暂时用123123代替

//用户上报简易申报表单的接口
@Controller
public class EasyController {

    @Resource
    private EasyMapper easyMapper;

    @CrossOrigin
    @PostMapping("api/easy")
    @ResponseBody
    public HttpResult easy(@RequestBody EasyMeet easyMeet) {

        EasyMeet tempeasy = easyMeet;

        easyMeet.setId(123123123);
        easyMeet.setDelete(false);
        easyMeet.setCreateTime(LocalDateTime.now());
        easyMeet.setUpdateTime(LocalDateTime.now());
        easyMeet.setCheckState(0);

        if (easyMapper.add(tempeasy) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(400);

    }

}

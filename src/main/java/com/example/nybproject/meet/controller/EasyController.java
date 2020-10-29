package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.PostResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class EasyController {

    @Resource
    private EasyMapper easyMapper;

    @CrossOrigin
    @PostMapping("api/easy")
    @ResponseBody
    public PostResult easy(@RequestBody EasyMeet easyMeet){

        EasyMeet tempeasy = easyMeet;

        easyMeet.setId(123123123);

        if(easyMapper.add(tempeasy)==1){
            return new PostResult(200);
        }

        return new PostResult(400);

    }

}

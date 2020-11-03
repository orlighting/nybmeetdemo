package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 *
 * 用户上报功能控制
 * 10.29 完成第一版，id暂时用123123代替
 * 11.3 完成简易申报的部分
 */
@Controller
@RequestMapping("api/handin")
public class HandinController {

    @Resource
    private EasyMapper easyMapper;

    @Resource
    private IdGenerater idGenerater;

    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody EasyMeet easyMeet) {

        easyMeet.setId(idGenerater.getEasyMeetIdNow());
        easyMeet.setAdminId(0);
        easyMeet.setDelete(false);
        easyMeet.setCreateTime(LocalDateTime.now());
        easyMeet.setUpdateTime(LocalDateTime.now());
        easyMeet.setCheckState(0);

        if (easyMapper.add(easyMeet) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

}

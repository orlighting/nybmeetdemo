package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理员审核控制
 * 11.4 完成简易审核拉取部分的内容，完成简易申报审核加结果入库的内容
 */

@Controller
@RequestMapping("api/check")
public class CheckController {

    @Resource
    EasyMapper easyMapper;


    /**
     * 向前端返回所有待审核的简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easylist")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyList(){

        List<EasyMeet> reqEasyMeet = easyMapper.findAllNotCheckEasy();

        return HttpResult.of(0, null, reqEasyMeet);
    }

    /**
     * 从前端获取申报审核结果
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easycheck(@RequestBody EasyMeet easyMeet){


        easyMeet.setUpdateTime(LocalDateTime.now());

        if(easyMapper.checkEasyMeet(easyMeet.getId(), easyMeet.getCheckState(), easyMeet.getAdminId(), easyMeet.getUpdateTime())==1){
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
    }



}

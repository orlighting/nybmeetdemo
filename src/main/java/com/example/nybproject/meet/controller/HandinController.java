package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.ResDetailMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 用户上报功能控制
 * 10.29 完成第一版，id暂时用123123代替
 */
@Controller
@RequestMapping("api/handin")
public class HandinController {

    @Resource
    private EasyMapper easyMapper;

    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody EasyMeet easyMeet) {

        easyMeet.setId(123123123);
        easyMeet.setDelete(false);
        easyMeet.setCreateTime(LocalDateTime.now());
        easyMeet.setUpdateTime(LocalDateTime.now());
        easyMeet.setCheckState(0);

        if (easyMapper.add(easyMeet) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(400);

    }

    @CrossOrigin
    @PostMapping("/detail")
    @ResponseBody
    public HttpResult<Void> easy(ResDetailMeet resDetailMeet) {
        MultipartFile preExpoFile = resDetailMeet.getPreExpoFile();
        MultipartFile investmentPlanFile = resDetailMeet.getInvestmentPlanFile();
        if (preExpoFile.isEmpty() || investmentPlanFile.isEmpty()) {
            // TODO 返回码待补充
            return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
        }
        // 先保存两个文件到mongo,获得对应的ID后，将其他数据保存到mysql
        return HttpResult.of();
    }

}

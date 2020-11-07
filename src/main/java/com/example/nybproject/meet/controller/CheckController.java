package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMapper;
import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理员审核控制
 * 11.4 完成简易审核拉取部分的内容，完成简易申报审核加结果入库的内容
 * 11.7 完成详细审核拉取部分的内容，完成详细申报审核加结果入库的内容
 */

@Controller
@RequestMapping("api/check")
public class CheckController {

    @Resource
    private EasyMapper easyMapper;
    @Resource
    private DetailMapper detailMapper;


    /**
     * 向前端返回所有待审核的简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easylist")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyList() {

        List<EasyMeet> reqEasyMeet = easyMapper.findAllNotCheckEasy();

        return HttpResult.of(reqEasyMeet);
    }

    /**
     * 从前端获取简易申报审核结果
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easyCheck(@RequestBody EasyMeet easyMeet) {


        easyMeet.setUpdateTime(LocalDateTime.now());

        if (easyMapper.checkEasyMeet(easyMeet.getId(), easyMeet.getCheckState(), easyMeet.getAdminId(), easyMeet.getUpdateTime()) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 向前端返回所有待审核的详细申报信息
     */
    @CrossOrigin
    @RequestMapping("/detailList")
    @ResponseBody
    public HttpResult<List<DetailMeet>> detailList() {
        List<DetailMeet> reqEasyMeet = detailMapper.findAllNotCheck();
        return HttpResult.of(reqEasyMeet);
    }

    /**
     * 从前端获取详细申报审核结果
     */
    @CrossOrigin
    @PostMapping("/detail")
    @ResponseBody
    public HttpResult<Void> detailCheck(@RequestBody DetailMeet detailMeet) {
        detailMeet.setUpdateTime(LocalDateTime.now());

        int result = detailMapper.checkDetailMeet(detailMeet.getId(), detailMeet.getCheckState(), detailMeet.getAdminId(), detailMeet.getUpdateTime());
        if (result == 1) {
            return HttpResult.of();
        }
        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
    }


}

package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMapper;
import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.ResDetailMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
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
    private DetailMapper detailMapper;

    @Resource
    private IdGenerater idGenerater;

    /**
     * @param easyMeet
     * @return
     * 用户提交简易申报的接口，先判断其详细申报id是否正确，是否对应正确的详细申报，之后入库
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody EasyMeet easyMeet) {

        DetailMeet detailMeet = detailMapper.findsById(easyMeet.getDmeetId());
        if(detailMeet == null){
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }
        if(detailMeet.getUserId() != easyMeet.getUserId()){
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

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

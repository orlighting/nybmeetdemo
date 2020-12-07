package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMeetMapper;
import com.example.nybproject.meet.mapper.EasyMeetMapper;
import com.example.nybproject.meet.mapper.SummaryMapper;
import com.example.nybproject.meet.pojo.*;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.util.JsonUtil;
import com.sun.org.apache.xpath.internal.operations.Mult;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 用户上报功能控制
 * 10.29 完成第一版，id暂时用123123代替
 * 11.3 完成简易申报的部分
 * 11.5 完成详细申报的部分
 */
@Slf4j
@Controller
@RequestMapping("api/handin")
public class HandinController {

    @Resource
    private EasyMeetMapper easyMeetMapper;
    @Resource
    private DetailMeetMapper detailMeetMapper;
    @Resource
    private GridFsTemplate gridFsTemplate;
    @Resource
    private SummaryMapper summaryMapper;

    /**
     * @param resEasyMeet
     * @return
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody ResEasyMeet resEasyMeet) {
        try{
            MultipartFile investmentPlanFile = resEasyMeet.getInvestmentPlanFile();
            MultipartFile meetPlanFile = resEasyMeet.getMeetPlanFile();
            MultipartFile authFile = resEasyMeet.getAuthFile();

            resEasyMeet.setInvestmentPlanFileId(saveFileToMongo(investmentPlanFile));
            resEasyMeet.setMeetPlanFileId(saveFileToMongo(meetPlanFile));
            resEasyMeet.setAuthFileId(saveFileToMongo(authFile));

            easyMeetMapper.saveSelective(JsonUtil.convertObject(resEasyMeet, EasyMeet.class));
            return HttpResult.of();
        } catch (Exception e){
            log.error("HandinController中easy方法出错", e);
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

    /**
     * @param resDetailMeet
     * @return
     */
    @CrossOrigin
    @PostMapping("/detail")
    @ResponseBody
    public HttpResult<Void> detail(ResDetailMeet resDetailMeet) {
        try {
            MultipartFile investmentPlanFile = resDetailMeet.getInvestmentPlanFile();
            MultipartFile feasibilityFile = resDetailMeet.getFeasibilityFile();
            MultipartFile meetPlanFile = resDetailMeet.getMeetPlanFile();
            MultipartFile conditionStateFile = resDetailMeet.getConditionStateFile();
            MultipartFile authFile = resDetailMeet.getAuthFile();
            // 先保存五个文件到mongo,获得对应的ID后，将其他数据保存到mysql

            resDetailMeet.setInvestmentPlanFileId(saveFileToMongo(investmentPlanFile));
            resDetailMeet.setFeasibilityFileId(saveFileToMongo(feasibilityFile));
            resDetailMeet.setMeetPlanFileId(saveFileToMongo(meetPlanFile));
            resDetailMeet.setConditionStateFileId(saveFileToMongo(conditionStateFile));
            resDetailMeet.setAuthFileId(saveFileToMongo(authFile));

            detailMeetMapper.saveSelective(JsonUtil.convertObject(resDetailMeet, DetailMeet.class));
            return HttpResult.of();
        } catch (Exception e) {
            log.error("HandinController中detail方法出错", e);
            return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
        }
    }

    /**
     * @param resSummary
     * @return
     */
    @CrossOrigin
    @RequestMapping("/summary")
    @ResponseBody
    public HttpResult<Void> summary(ResSummary resSummary) {

        try {
            if (resSummary.getKind() != 2) {
                MultipartFile summaryFile = resSummary.getSummaryFile();
                MultipartFile hosterSign = resSummary.getHosterSignFile();
                // 先保存两个文件到mongo,获得对应的ID后，将其他数据保存到mysql
                resSummary.setSummaryFileId(saveFileToMongo(summaryFile));
                resSummary.setHosterSignFileId(saveFileToMongo(hosterSign));
            }

            summaryMapper.saveSelective(JsonUtil.convertObject(resSummary, Summary.class));
            return HttpResult.of();
        } catch (Exception e) {
            log.error("HandinController中summary方法出错", e);
            return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
        }

    }


    /**
     * 将前端传来的文件保存到mongo
     *
     * @param file
     * @return mongo中保存记录的id
     */
    private String saveFileToMongo(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        ObjectId objectId = gridFsTemplate.store(inputStream, fileName);
        return objectId.toHexString();
    }

}

package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMeetMapper;
import com.example.nybproject.meet.mapper.EasyMeetMapper;
import com.example.nybproject.meet.mapper.SummaryMapper;
import com.example.nybproject.meet.pojo.*;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.util.JsonUtil;
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
     * @param easyMeet
     * @return 用户提交简易申报的接口，先判断其详细申报id是否正确，是否对应正确的详细申报，之后入库
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody EasyMeet easyMeet) {

        DetailMeet detailMeet = detailMeetMapper.getByPrimaryKey(easyMeet.getDmeetId());
        if (detailMeet == null) {
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

        if (!Objects.equals(detailMeet.getUserId(), easyMeet.getUserId()) || detailMeet.getCheckState() != 2) {
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

        easyMeet.setAdminId(0);
        easyMeet.setCheckState(0);

        if (easyMeetMapper.saveSelective(easyMeet) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

    @CrossOrigin
    @PostMapping("/detail")
    @ResponseBody
    public HttpResult<Void> detail(ResDetailMeet resDetailMeet) {
        try {
            MultipartFile preExpoFile = resDetailMeet.getPreExpoFile();
            MultipartFile investmentPlanFile = resDetailMeet.getInvestmentPlanFile();
            // 先保存两个文件到mongo,获得对应的ID后，将其他数据保存到mysql
            resDetailMeet.setPreExpoFileId(saveFileToMongo(preExpoFile));
            resDetailMeet.setInvestmentPlanFileId(saveFileToMongo(investmentPlanFile));
            resDetailMeet.setCreateTime(LocalDateTime.now());
            resDetailMeet.setUpdateTime(LocalDateTime.now());
            resDetailMeet.setCheckState(0);

            detailMeetMapper.saveSelective(JsonUtil.convertObject(resDetailMeet, DetailMeet.class));
            return HttpResult.of();
        } catch (Exception e) {
            log.error("HandinController中detail方法出错", e);
            return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping("/summary")
    @ResponseBody
    public HttpResult<Void> summary(ResSummary resSummary) {

        DetailMeet detailMeet = detailMeetMapper.getByPrimaryKey(resSummary.getDetailId());

        if (detailMeet == null) {
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

        System.out.println(detailMeet.getUserId());
        System.out.println(detailMeet.getId());
        System.out.println(detailMeet.getCheckState());

        if (!Objects.equals(detailMeet.getUserId(), resSummary.getUserId()) || detailMeet.getCheckState() != 2) {
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

        try {
            if (resSummary.getKind() != 2) {
                MultipartFile summaryFile = resSummary.getSummaryFile();
                // 先保存两个文件到mongo,获得对应的ID后，将其他数据保存到mysql
                resSummary.setSummaryFileId(saveFileToMongo(summaryFile));
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

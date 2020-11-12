package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMapper;
import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.ResDetailMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private EasyMapper easyMapper;
    @Resource
    private DetailMapper detailMapper;
    @Resource
    private IdGenerater idGenerater;
    @Resource
    private GridFsTemplate gridFsTemplate;

    /**
     * @param easyMeet
     * @return 用户提交简易申报的接口，先判断其详细申报id是否正确，是否对应正确的详细申报，之后入库
     */
    @CrossOrigin
    @PostMapping("/easy")
    @ResponseBody
    public HttpResult<Void> easy(@RequestBody EasyMeet easyMeet) {

        DetailMeet detailMeet = detailMapper.findsById(easyMeet.getDmeetId());
        if (detailMeet == null) {
            return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_ACCESS);
        }

        System.out.println(detailMeet.getUserId());
        System.out.println(detailMeet.getCheckState());
        System.out.println(easyMeet.getUserId());

        if (!Objects.equals(detailMeet.getUserId(),easyMeet.getUserId()) || detailMeet.getCheckState() != 2) {
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
    public HttpResult<Void> detail(ResDetailMeet resDetailMeet) {
        try {
            MultipartFile preExpoFile = resDetailMeet.getPreExpoFile();
            MultipartFile investmentPlanFile = resDetailMeet.getInvestmentPlanFile();
            // 先保存两个文件到mongo,获得对应的ID后，将其他数据保存到mysql
            resDetailMeet.setId(idGenerater.getDetailMeetIdNow());
            resDetailMeet.setPreExpoFileId(saveFileToMongo(preExpoFile));
            resDetailMeet.setInvestmentPlanFileId(saveFileToMongo(investmentPlanFile));
            resDetailMeet.setCreateTime(LocalDateTime.now());
            resDetailMeet.setUpdateTime(LocalDateTime.now());
            resDetailMeet.setCheckState(0);
            resDetailMeet.setDelete(false);

            detailMapper.add(convertResDetailMeetToDetailMeet(resDetailMeet));
            return HttpResult.of();
        } catch (Exception e) {
            log.error("HandinController中detail方法出错", e);
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

    private DetailMeet convertResDetailMeetToDetailMeet(ResDetailMeet resDetailMeet) {
        LocalDate date = LocalDate.parse(resDetailMeet.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return DetailMeet.builder()
                .id(resDetailMeet.getId())
                .userId(resDetailMeet.getUserId())
                .adminId(resDetailMeet.getAdminId())
                .finanFund(resDetailMeet.getFinanFund())
                .otherFund(resDetailMeet.getOtherFund())
                .checkState(resDetailMeet.getCheckState())
                .area(resDetailMeet.getArea())
                .domestic(resDetailMeet.getDomestic())
                .foreign(resDetailMeet.getForeign())
                .name(resDetailMeet.getName())
                .hostComp(resDetailMeet.getHostComp())
                .fundComp(resDetailMeet.getFundComp())
                .authObj(resDetailMeet.getAuthObj())
                .authNum(resDetailMeet.getAuthNum())
                .place(resDetailMeet.getPlace())
                .cycle(resDetailMeet.getCycle())
                .content(resDetailMeet.getContent())
                .finanFrom(resDetailMeet.getFinanFrom())
                .otherFrom(resDetailMeet.getOtherFrom())
                .declare(resDetailMeet.getDeclare())
                .preExpoFileId(resDetailMeet.getPreExpoFileId())
                .investmentPlanFileId(resDetailMeet.getInvestmentPlanFileId())
                .time(date)
                .createTime(resDetailMeet.getCreateTime())
                .updateTime(resDetailMeet.getUpdateTime())
                .view1(resDetailMeet.getView1())
                .view2(resDetailMeet.getView2())
                .leaderD(resDetailMeet.getLeaderD())
                .leaderF(resDetailMeet.getLeaderF())
                .delete(resDetailMeet.getDelete())
                .build();
    }

}

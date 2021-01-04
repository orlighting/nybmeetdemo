package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMeetMapper;
import com.example.nybproject.meet.mapper.EasyMeetMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 管理员审核控制
 * 11.4 完成简易审核拉取部分的内容，完成简易申报审核加结果入库的内容
 * 11.7 完成详细审核拉取部分的内容，完成详细申报审核加结果入库的内容
 */
@Slf4j
@Controller
@RequestMapping("api/check")
public class CheckController {

    @Resource
    private EasyMeetMapper easyMeetMapper;
    @Resource
    private DetailMeetMapper detailMeetMapper;
    @Resource
    private GridFsTemplate gridFsTemplate;


    /**
     * 向前端返回所有待审核的简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easylist")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyList() {

        List<EasyMeet> reqEasyMeet = easyMeetMapper.findAllNotCheckEasy();

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

        int result = easyMeetMapper.checkEasyMeet(easyMeet.getId(), easyMeet.getCheckState(), easyMeet.getAdminId());
        if (result == 1) {
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
        List<DetailMeet> reqEasyMeet = detailMeetMapper.findAllNotCheck();



        return HttpResult.of(reqEasyMeet);
    }

    /**
     * 获取详细申报的文件
     */
    @CrossOrigin
    @RequestMapping("/detailFile")
    public ResponseEntity<FileSystemResource> detailList(@RequestBody JSONObject fileId) {
        System.out.println(fileId);

        try {
            GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId.get("fileId"))));
            GridFsResource gridFsResource = gridFsTemplate.getResource(gridFSFile);
            File file = new File("tmp");
            FileUtils.copyInputStreamToFile(gridFsResource.getInputStream(), file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(gridFSFile.getFilename(), "utf-8"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(System.currentTimeMillis()));

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            log.error("获取文件出错，e=", e);

            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * 从前端获取详细申报审核结果
     */
    @CrossOrigin
    @PostMapping("/detail")
    @ResponseBody
    public HttpResult<Void> detailCheck(@RequestBody DetailMeet detailMeet) {

        int result = detailMeetMapper.checkDetailMeet(detailMeet.getId(), detailMeet.getCheckState(), detailMeet.getAdminId());
        if (result == 1) {
            return HttpResult.of();
        }
        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
    }

}

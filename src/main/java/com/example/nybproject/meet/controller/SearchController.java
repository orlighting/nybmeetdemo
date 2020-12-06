package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.DetailMeetMapper;
import com.example.nybproject.meet.mapper.EasyMeetMapper;
import com.example.nybproject.meet.mapper.SummaryMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.Summary;
import com.example.nybproject.meet.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/search")
public class SearchController {

    @Resource
    DetailMeetMapper detailMeetMapper;
    @Resource
    EasyMeetMapper easyMeetMapper;
    @Resource
    SummaryMapper summaryMapper;

    /**
     * 查出所有的详细申报表单返回前端
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/allDetailMeet")
    @ResponseBody
    public HttpResult<List<DetailMeet>> allDetailMeet() {

        List<DetailMeet> resDetailMeet = detailMeetMapper.findsAll();

        return HttpResult.of(resDetailMeet);
    }

    /**
     * 查出所有简易申报表单返回前端
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/allEasyMeet")
    @ResponseBody
    public HttpResult<List<EasyMeet>> allEasyMeet() {

        List<EasyMeet> resEasyMeet = easyMeetMapper.findsAll();

        return HttpResult.of(resEasyMeet);
    }

    /**
     * 查出所有总结表单返回前端
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/allSummary")
    @ResponseBody
    public HttpResult<List<Summary>> allSummary() {

        List<Summary> resSummary = summaryMapper.findsAll();

        return HttpResult.of(resSummary);
    }

}

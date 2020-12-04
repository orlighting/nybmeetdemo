package com.example.nybproject.meet.controller;


import com.example.nybproject.meet.mapper.DetailMapper;
import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.mapper.MeetInfoMapper;
import com.example.nybproject.meet.mapper.MessageMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.MeetInfo;
import com.example.nybproject.meet.pojo.Message;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息系统控制
 */

@Controller
@RequestMapping("api/message")
public class MessageController {

    @Resource
    private IdGenerater idGenerater;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private EasyMapper easyMapper;
    @Resource
    private DetailMapper detailMapper;
    @Resource
    private MeetInfoMapper meetInfoMapper;

    /**
     * @param message
     * @return 接收前端发来的推送消息，并入库
     */
    @CrossOrigin
    @PostMapping("/send")
    @ResponseBody
    public HttpResult<Void> sendMessage(@RequestBody Message message) {

        message.setId(idGenerater.getMessageIdNow());
        message.setCreateTime(LocalDateTime.now());
        message.setUpdateTime(LocalDateTime.now());
        message.setDelete(false);
        message.setLooked(false);

        if (messageMapper.add(message) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

    /**
     * @param userId
     * @return 向前端返回所有已读邮件
     */
    @CrossOrigin
    @RequestMapping("/looked")
    @ResponseBody
    public HttpResult<List<Message>> lookedMessage(@RequestBody JSONObject userId) {

        System.out.println(userId);

        List<Message> resMessage = messageMapper.findsLookedMessage(Integer.parseInt(userId.get("userId").toString()));

        if (resMessage != null) {
            return HttpResult.of(resMessage);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_LOOKED_MESSAGE);

    }

    /**
     * @param userId
     * @return 向前端返回所有未读邮件
     */
    @CrossOrigin
    @RequestMapping("/notLook")
    @ResponseBody
    public HttpResult<List<Message>> notLookMessage(@RequestBody JSONObject userId) {

        List<Message> resMessage = messageMapper.findsNotLookMessage(Integer.parseInt(userId.get("userId").toString()));

        if (!resMessage.isEmpty()) {
            List<Integer> ids = resMessage.stream()
                    .map(Message::getId)
                    .collect(Collectors.toList());
            messageMapper.updateNotLookMessageLooked(ids);
            return HttpResult.of(resMessage);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_NOT_LOOK_MESSAGE);

    }

    /**
     * @param userId
     * @return 向前端返回所有未读邮件的数量
     */
    @CrossOrigin
    @RequestMapping("/notLookCount")
    @ResponseBody
    public HttpResult<Integer> notLookMessageCount(@RequestBody JSONObject userId) {

        List<Message> resMessage = messageMapper.findsNotLookMessage(Integer.parseInt(userId.get("userId").toString()));
        Integer count = resMessage == null ? 0 : resMessage.size();

        return HttpResult.of(count);
    }

    /**
     * @param userId
     * @return 向前端返回本账户下的所有简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easyState")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyState(@RequestBody JSONObject userId) {

        List<EasyMeet> resEasyMeet = easyMapper.findsByUserId(Integer.parseInt(userId.get("userId").toString()));

        if (resEasyMeet != null) {
            return HttpResult.of(resEasyMeet);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_EASY_MEET_MESSAGE);

    }


    /**
     * @param userId
     * @return 向前端返回本账户下的所有详细申报信息
     */
    @CrossOrigin
    @RequestMapping("/detailState")
    @ResponseBody
    public HttpResult<List<DetailMeet>> detailState(@RequestBody JSONObject userId) {

        List<DetailMeet> resDetailMeet = detailMapper.findsByUserId(Integer.parseInt(userId.get("userId").toString()));

        if (resDetailMeet != null) {
            return HttpResult.of(resDetailMeet);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_MESSAGE);
    }

    /**
     * @param
     * @return 向前端返回未审核的简易申报的数量
     */
    @CrossOrigin
    @RequestMapping("/easyNum")
    @ResponseBody
    public HttpResult<Integer> easyNum() {

        List<EasyMeet> resEasyMeet = easyMapper.findAllNotCheckEasy();
        Integer count = resEasyMeet == null ? 0 : resEasyMeet.size();
        return HttpResult.of(count);

    }

    /**
     * @param
     * @return 向前端返回未审核的详细申报的数量
     */
    @CrossOrigin
    @RequestMapping("/detailNum")
    @ResponseBody
    public HttpResult<Integer> detailNum() {

        List<DetailMeet> resDetailMeet = detailMapper.findAllNotCheck();
        Integer count = resDetailMeet == null ? 0 : resDetailMeet.size();
        return HttpResult.of(count);

    }


    @CrossOrigin
    @RequestMapping("/meetInfo")
    @ResponseBody
    public HttpResult<List<MeetInfo>> meetInfo(){

        return HttpResult.of(meetInfoMapper.findsAll());

    }

}

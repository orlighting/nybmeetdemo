package com.example.nybproject.meet.controller;


import com.example.nybproject.meet.mapper.DetailMapper;
import com.example.nybproject.meet.mapper.EasyMapper;
import com.example.nybproject.meet.mapper.MessageMapper;
import com.example.nybproject.meet.pojo.DetailMeet;
import com.example.nybproject.meet.pojo.EasyMeet;
import com.example.nybproject.meet.pojo.Message;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 消息系统控制
 */

@Controller
@RequestMapping("api/message")
public class MessageController {

    @Resource
    IdGenerater idGenerater;

    @Resource
    MessageMapper messageMapper;
    @Resource
    EasyMapper easyMapper;
    @Resource
    DetailMapper detailMapper;

    /**
     * @param message
     * @return
     *
     * 接收前端发来的推送消息，并入库
     */
    @CrossOrigin
    @PostMapping("/send")
    @ResponseBody
    public HttpResult<Void> sendMessage(@RequestBody Message message){

        message.setId(idGenerater.getMessageIdNow());
        message.setCreateTime(LocalDateTime.now());
        message.setUpdateTime(LocalDateTime.now());
        message.setDelete(false);
        message.setLooked(false);

        if(messageMapper.add(message)==1){
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

    /**
     * @param userId
     * @return
     *
     * 向前端返回所有已读邮件
     */
    @CrossOrigin
    @RequestMapping("/looked")
    @ResponseBody
    public HttpResult<List<Message>> lookedMessage(@RequestBody Integer userId){

        System.out.println(userId);

        List<Message> resMessage = messageMapper.findsLookedMessage(userId);

        if(resMessage != null){
            return HttpResult.of(0, null, resMessage);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_LOOKED_MESSAGE);

    }

    /**
     * @param userId
     * @return
     *
     * 向前端返回所有未读邮件
     */
    @CrossOrigin
    @RequestMapping("/notlook")
    @ResponseBody
    public HttpResult<List<Message>> notLookMessage(@RequestBody Integer userId){

        System.out.println(userId);

        List<Message> resMessage = messageMapper.findsNotLookMessage(userId);

        if(resMessage != null){
            return HttpResult.of(0, null, resMessage);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_NOT_LOOK_MESSAGE);

    }

    /**
     * @param userId
     * @return
     *
     * 向前端返回本账户下的所有简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easystate")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyState(@RequestBody Integer userId){
        System.out.println(userId);

        List<EasyMeet> resEasyMeet = easyMapper.findsByUserId(userId);

        if(resEasyMeet != null){
            return HttpResult.of(0, null, resEasyMeet);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_EASY_MEET_MESSAGE);

    }


    /**
     * @param userId
     * @return
     *
     * 向前端返回本账户下的所有详细申报信息
     */
    @CrossOrigin
    @RequestMapping("/detailstate")
    @ResponseBody
    public HttpResult<List<DetailMeet>> detailState(@RequestBody Integer userId){
        System.out.println(userId);

        List<DetailMeet> resDetailMeet = detailMapper.findsByUserId(userId);

        if(resDetailMeet != null){
            return HttpResult.of(0, null, resDetailMeet);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_DETAIL_MEET_MESSAGE);
    }

}

package com.example.nybproject.meet.controller;


import com.example.nybproject.meet.mapper.*;
import com.example.nybproject.meet.pojo.*;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息系统控制
 */

@Controller
@RequestMapping("api/message")
public class MessageController {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private EasyMeetMapper easyMeetMapper;
    @Resource
    private DetailMeetMapper detailMeetMapper;
    @Resource
    private MeetInfoMapper meetInfoMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * @param message
     * @return 接收前端发来的推送消息，并入库
     */
    @CrossOrigin
    @PostMapping("/send")
    @ResponseBody
    public HttpResult<Void> sendMessage(@RequestBody Message message) {

        message.setLooked(false);

        if (messageMapper.saveSelective(message) == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }

    /**
     * @param user
     * @return 向前端返回userId
     */
    @CrossOrigin
    @RequestMapping("/getUserId")
    @ResponseBody
    public HttpResult<Integer> getUserId(@RequestBody User user){

        User resUser = userMapper.getByMeetAddr(user.getMeetAddr());

        return HttpResult.of(resUser.getId());

    }


    /**
     * @param user
     * @return 向前端返回所有已读邮件
     */
    @CrossOrigin
    @RequestMapping("/looked")
    @ResponseBody
    public HttpResult<List<Message>> lookedMessage(@RequestBody User user) {

        Integer userId = userMapper.getByMeetAddr(user.getMeetAddr()).getId();

        List<Message> resMessage = messageMapper.findsLookedMessage(userId);

        if (resMessage != null) {
            return HttpResult.of(resMessage);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_LOOKED_MESSAGE);

    }

    /**
     * @param user
     * @return 向前端返回所有未读邮件
     */
    @CrossOrigin
    @RequestMapping("/notLook")
    @ResponseBody
    public HttpResult<List<Message>> notLookMessage(@RequestBody User user) {

        Integer userId = userMapper.getByMeetAddr(user.getMeetAddr()).getId();

        List<Message> resMessage = messageMapper.findsNotLookMessage(userId);

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
     * @param user
     * @return 向前端返回所有未读邮件的数量
     */
    @CrossOrigin
    @RequestMapping("/notLookCount")
    @ResponseBody
    public HttpResult<Integer> notLookMessageCount(@RequestBody User user) {

        System.out.println(user.getMeetAddr()+123);

        Integer userId = userMapper.getByMeetAddr(user.getMeetAddr()).getId();

        List<Message> resMessage = messageMapper.findsNotLookMessage(userId);
        Integer count = resMessage == null ? 0 : resMessage.size();

        return HttpResult.of(count);
    }

    /**
     * @param user
     * @return 向前端返回本账户下的所有简易申报信息
     */
    @CrossOrigin
    @RequestMapping("/easyState")
    @ResponseBody
    public HttpResult<List<EasyMeet>> easyState(@RequestBody User user) {

        Integer userId = userMapper.getByMeetAddr(user.getMeetAddr()).getId();

        List<EasyMeet> resEasyMeet = easyMeetMapper.findsByUserId(userId);

        if (resEasyMeet != null) {
            return HttpResult.of(resEasyMeet);
        }

        return HttpResult.of(HttpResultCodeEnum.NONE_EASY_MEET_MESSAGE);

    }


    /**
     * @param user
     * @return 向前端返回本账户下的所有详细申报信息
     */
    @CrossOrigin
    @RequestMapping("/detailState")
    @ResponseBody
    public HttpResult<List<DetailMeet>> detailState(@RequestBody User user) {

        Integer userId = userMapper.getByMeetAddr(user.getMeetAddr()).getId();

        List<DetailMeet> resDetailMeet = detailMeetMapper.findsByUserId(userId);

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

        List<EasyMeet> resEasyMeet = easyMeetMapper.findAllNotCheckEasy();
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

        List<DetailMeet> resDetailMeet = detailMeetMapper.findAllNotCheck();
        Integer count = resDetailMeet == null ? 0 : resDetailMeet.size();
        return HttpResult.of(count);

    }


    @CrossOrigin
    @RequestMapping("/meetInfo")
    @ResponseBody
    public HttpResult<List<MeetInfo>> meetInfo() {

        return HttpResult.of(meetInfoMapper.findsAll());

    }

}

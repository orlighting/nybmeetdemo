package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.MessageMapper;
import com.example.nybproject.meet.pojo.Message;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 删除数据相关控制
 * <p>
 * 为之后需求备用
 */
@Controller
@RequestMapping("/api/delete")
public class DeleteController {

    @Resource
    MessageMapper messageMapper;

    @CrossOrigin
    @RequestMapping("/message")
    @ResponseBody
    public HttpResult<Void> deleteMessage(@RequestBody Message message) {

        int res = messageMapper.deleteMessageById(message.getId());

        if (res == 1) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);

    }


}

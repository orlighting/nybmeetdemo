package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import com.example.nybproject.meet.service.IdGenerater;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 用户账号相关控制
 */

@Controller
@RequestMapping("api/account")
public class AccountController {

    @Resource
    UserMapper userMapper;

    @Resource
    IdGenerater idGenerater;

    /**
     * 用户注册接口
     */
    @CrossOrigin
    @PostMapping("/register")
    @ResponseBody
    public HttpResult<Void> userRegister(@RequestBody User user){

        System.out.println(user.getId());
        System.out.println(user.getPassword());
        if(userMapper.findsByIdentityCard(user.getIdentityCard())!=null){
            return HttpResult.of(HttpResultCodeEnum.ACCOUNT_REGISTER_ID_CARD_REPEAT);
        }

        if(userMapper.findsByTeleNum(user.getTeleNum())!=null){
            return HttpResult.of(HttpResultCodeEnum.ACCOUNT_REGISTER_MOBILE_REPEAT);
        }

        user.setCheckState(1);
        user.setDelete(false);
        user.setId(idGenerater.getUserIdNow());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        if(userMapper.add(user)==1){
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.SYSTEM_ERROR);
    }

}

package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 登录控制
 * 10.29 完成了用户部分的登录开发
 */
@Controller
public class LoginController {

    @Resource
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public HttpResult<Void> login(@RequestBody User user) {
        Integer id = user.getId();

        User resUser = userMapper.findsById(id);
        if (resUser == null) {
            return HttpResult.of(400);
        } else if (Objects.equals(resUser.getPassword(), user.getPassword())) {
            return HttpResult.of();
        } else {
            return HttpResult.of(400);
        }
    }


}

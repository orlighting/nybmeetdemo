package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.PostResult;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.Objects;

//10.29 完成了用户部分的登录开发


//登录控制
@Controller
public class LoginController {

    @Resource
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public PostResult login(@RequestBody User user){
        Integer id = user.getId();

        User resUser = userMapper.findsById(id);
        if(resUser == null) {
            return new PostResult(400);
        }
        else if(Objects.equals(resUser.getPassword(),user.getPassword())){
            return new PostResult(200);
        }
        else{
            return new PostResult(400);
        }
    }


}

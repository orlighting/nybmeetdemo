package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.AdminMapper;
import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.Admin;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 登录控制
 * 10.29 完成了用户部分的登录开发
 * 10.30 完成了管理员部分的登录开发
 */
@Controller
@RequestMapping("api/login")
public class LoginController {

    @Resource
    UserMapper userMapper;
    @Resource
    AdminMapper adminMapper;

    @CrossOrigin
    @PostMapping("/user")
    @ResponseBody
    public HttpResult<Void> userLogin(@RequestBody User user) {
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

    @CrossOrigin
    @PostMapping("/admin")
    @ResponseBody
    public HttpResult<Void> adminLogin(@RequestBody Admin admin) {

        Integer id = admin.getId();

        Admin resAdmin = adminMapper.findById(id);

        if (resAdmin == null) {
            return HttpResult.of(400);
        } else if (Objects.equals(resAdmin.getPassword(), admin.getPassword())) {
            return HttpResult.of();
        } else {
            return HttpResult.of(400);
        }
    }


}

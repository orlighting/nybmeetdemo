package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.AdminMapper;
import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.Admin;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
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
    private UserMapper userMapper;
    @Resource
    private AdminMapper adminMapper;

    @CrossOrigin
    @PostMapping("/user")
    @ResponseBody
    public HttpResult<User> userLogin(@RequestBody User user) {
        Integer id = user.getId();

        User resUser = userMapper.getByPrimaryKey(id);
        if (resUser == null) {
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        } else if (Objects.equals(resUser.getPassword(), user.getPassword())) {
            return HttpResult.of(resUser);
        } else {
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        }
    }

    @CrossOrigin
    @PostMapping("/admin")
    @ResponseBody
    public HttpResult<Void> adminLogin(@RequestBody Admin admin) {

        Integer id = admin.getId();

        Admin resAdmin = adminMapper.getByPrimaryKey(id);

        if (resAdmin == null) {
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        } else if (Objects.equals(resAdmin.getPassword(), admin.getPassword())) {
            return HttpResult.of();
        } else {
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        }
    }


}

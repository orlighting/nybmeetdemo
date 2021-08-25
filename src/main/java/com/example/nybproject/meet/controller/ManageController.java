package com.example.nybproject.meet.controller;

import com.example.nybproject.meet.mapper.UserMapper;
import com.example.nybproject.meet.pojo.User;
import com.example.nybproject.meet.result.HttpResult;
import com.example.nybproject.meet.result.HttpResultCodeEnum;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("api/manage")
public class ManageController {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户修改密码
     * @param user
     * @return
     */
    @RequestMapping("/changePassword")
    public HttpResult<Void> changePassword(@RequestBody User user){

        String oldPassWord = user.getName();

        User changeUser = userMapper.getByMeetAddr(user.getMeetAddr());

        if(Objects.equals(oldPassWord, changeUser.getPassword())){
            user.setName(null);
            user.setId(changeUser.getId());
            userMapper.updateByPrimaryKeySelective(user);
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.OLD_PASSWORD_FALSE);

    }

    /**
     * 管理员添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public HttpResult<Void> addUser(@RequestBody User user){

        user.setPassword("123456");

        userMapper.saveSelective(user);

        return HttpResult.of();
    }

    /**
     * 管理员重置用户密码
     * @param user
     * @return
     */
    @RequestMapping("/resetPassword")
    public HttpResult<Void> resetPassword(@RequestBody User user){

        User resUser = userMapper.getByMeetAddr(user.getMeetAddr());

        BeanDefinitionReader beanDefinitionReader ;

        TreeMap tm = new TreeMap();
        Deque<Integer> dq = new LinkedList();
        HashSet<Integer> hs = new HashSet<>();

        if(resUser != null){

            user.setPassword("123456");
            userMapper.updateByPrimaryKeySelective(user);

        }

        return HttpResult.of(HttpResultCodeEnum.NONE_REQUEST_ACCOUNT);
    }

    /**
     * 管理员冻结账户
     * @param user
     * @return
     */
    @RequestMapping("/freeze")
    public HttpResult<Void> freezeUser(@RequestBody User user){

        User resUser = userMapper.getByMeetAddr(user.getMeetAddr());

        if(resUser != null){

            user.setIsFreeze(true);
            userMapper.updateByPrimaryKeySelective(user);

        }

        return HttpResult.of();
    }

}

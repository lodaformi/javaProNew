package com.loda.controller;

import com.loda.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/15 20:18
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class JsonConvertController {
    @RequestMapping("user/queryUser")
    @ResponseBody
    public User queryUser() {
        User user = new User();
        user.setId(20);
        user.setName("tom");
        user.setSal(1234.5);
        return user;
    }

    @RequestMapping("user/queryUser02")
    public @ResponseBody User queryUser02() {
        User user = new User();
        user.setId(20);
        user.setName("tom");
        user.setSal(1234.5);
        return user;
    }

    @RequestMapping("user/queryUsers03")
    public @ResponseBody List<User> queryUsers03() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(20);
        user.setName("tom");
        user.setSal(1234.5);

        User user2 = new User();
        user2.setId(30);
        user2.setName("scott");
        user2.setSal(3234.5);
        users.add(user);
        users.add(user2);
        return users;
    }

    @RequestMapping("user/queryUser04")
    @ResponseBody
    public User queryUser04(@RequestBody User user) {
        return user;
    }
}

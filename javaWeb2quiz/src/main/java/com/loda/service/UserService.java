package com.loda.service;

import com.loda.base.BaseService;
import com.loda.dao.UserMapper;
import com.loda.entity.po.User;
import com.loda.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author loda
 * @Date 2022/12/6 15:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService extends BaseService<User, Integer> {
    @Resource
    private UserMapper userMapper;

    public User login(User user) {
        //参数校验
        String username = user.getUsername();
        AssertUtil.isTrue(StringUtils.isBlank(username) || StringUtils.isBlank(user.gettPwd()), "用户名或密码不能为空！");

        //根据用户名查询对象
        User tmp = userMapper.queryUserByName(username);
//        AssertUtil.isTrue(tmp == null, "用户名或密码不正确！");
        AssertUtil.isTrue(tmp == null, "用户名不存在！");

        //用户存在，则比对密码
        //如果密码不相等，则抛出异常
//        AssertUtil.isTrue(!tmp.gettPwd().equals(user.gettPwd()), "用户名或密码不正确！");
        AssertUtil.isTrue(!tmp.gettPwd().equals(user.gettPwd()), "密码不正确！");

        //如果用户存在，且密码正确，则登陆成功
        return tmp;
    }

    public User checkName(String username) {
        AssertUtil.isTrue(StringUtils.isBlank(username), "用户名不能为空");
        User user = userMapper.queryUserByName(username);
        AssertUtil.isTrue(user != null, "用户名已存在");
        return user;
    }

    public void register(User user) {
        //参数校验
        String username = user.getUsername();
        String userPwd = user.gettPwd();
        AssertUtil.isTrue(StringUtils.isBlank(username) || StringUtils.isBlank(userPwd), "用户名、密码、日期不能为空！");

        AssertUtil.isTrue(userMapper.queryUserByName(username)!=null, "用户已存在！");

        user.settBirthday(user.gettBirthday());
        AssertUtil.isTrue(userMapper.insertSelective(user) != 1, "注册失败！");
    }
}

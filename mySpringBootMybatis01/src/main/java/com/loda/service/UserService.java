package com.loda.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loda.dao.UserMapper;
import com.loda.entity.po.User;
import com.loda.exceptions.ParamsException;
import com.loda.query.UserQuery;
import com.loda.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/19 16:52
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Cacheable(value = "users", key = "#name")
    public User queryUserByUserName(String name) {
        return userMapper.queryUserByUserName(name);
    }

    @Cacheable(value = "users", key = "#id")
    public User queryUserById(Integer id) throws ParamsException {
        AssertUtil.isTrue(true, "异常测试...");
        return userMapper.queryUserById(id);
    }

    public void addUser(User user) throws ParamsException {
        //非空判断
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "用户密码不能为空");
        //还可能存在用户名相同的用户
        AssertUtil.isTrue(userMapper.queryUserByUserName(user.getUserName()) != null, "用户已存在");
        AssertUtil.isTrue((userMapper.addUser(user)<1), "用户添加失败");
    }

    public void updateUser(User user) throws ParamsException {
        //非空判断
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "用户密码不能为空");
        //用户不存在，不用更新
        AssertUtil.isTrue(userMapper.queryUserById(user.getId()) == null, "用户不存在");
        //要更新的值在别的条目中已经存在
        User tmp = userMapper.queryUserByUserName(user.getUserName());
        AssertUtil.isTrue( tmp != null && tmp.getId() != user.getId(), "用户名已存在");
        //自己跟自己一样可以更新
        AssertUtil.isTrue(userMapper.updateUser(user)<1, "更新失败");

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer id) throws ParamsException {
        //id为空或者根据id查找不到用户，表示用户不存在，不用删除
        AssertUtil.isTrue(id == null || userMapper.queryUserById(id) == null, "用户不存在");
        AssertUtil.isTrue(userMapper.delete(id)<1, "用户删除失败");
        int a=1/0;
    }

    public PageInfo<User> queryUsersByParams(UserQuery userQuery){
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        List<User> users=userMapper.selectUsersByParams(userQuery);
        return new PageInfo<User>(users);
    }
}

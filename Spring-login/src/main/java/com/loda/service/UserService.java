package com.loda.service;

import cn.hutool.core.util.StrUtil;
import com.loda.dao.UserDao;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author loda
 * @Date 2022/11/13 23:00
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public ResultInfo<User> userLogin(String name, String pwd) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        //判断参数是否为空
        if (StrUtil.isBlank(name) || StrUtil.isBlank(pwd)) {
            resultInfo.setCode(0);
            resultInfo.setMsg("用户名或密码为空");
            return  resultInfo;
        }

        //调用dao层方法，得到用户对象
        User user = userDao.getUserByname(name);

        if (user == null) {
            resultInfo.setCode(0);
            resultInfo.setMsg("用户不存在");
            return  resultInfo;
        }
        //如果存在判断密码是否正确
        if (!pwd.equals(user.getPwd())) {
            resultInfo.setCode(0);
            resultInfo.setMsg("密码不正确");
            return  resultInfo;
        }
        //如果用户名存在，且密码正确，则登陆成功
        resultInfo.setCode(1);
        resultInfo.setRsObj(user);
        return  resultInfo;
    }
}

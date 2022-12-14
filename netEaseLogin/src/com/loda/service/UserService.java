package com.loda.service;

import com.loda.entity.mo.MessageModel;
import com.loda.entity.po.User;
import com.loda.mapper.UserMapper;
import com.loda.util.GetSqlSession;
import com.loda.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author loda
 * @Date 2022/11/3 16:58
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            messageModel.setStatus(0);
            messageModel.setMsg("用户名和密码不能为空");
            setMsgObj(messageModel, uname, upwd);
            return  messageModel;
        }

        //2．调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByName(uname);

        if (user == null) {
            messageModel.setStatus(0);
            messageModel.setMsg("用户不存在");
            setMsgObj(messageModel, uname, upwd);
            return  messageModel;
        }

        if (!upwd.equals(user.getUserPwd())){
            messageModel.setStatus(0);
            messageModel.setMsg("密码错误");
            setMsgObj(messageModel, uname, upwd);
            return  messageModel;
        }

        //通过上面判断，则表示登录成功
        messageModel.setStatus(1);
        messageModel.setMsg("登录成功");
        setMsgObj(messageModel, uname, upwd);
        return messageModel;
    }

    public void setMsgObj(MessageModel messageModel, String uname, String upwd) {
        User user = new User();
        user.setUserName(uname);
        user.setUserPwd(upwd);
        messageModel.setObject(user);
    }
}

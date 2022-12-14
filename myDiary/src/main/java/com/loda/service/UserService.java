package com.loda.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.loda.dao.UserDao;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/4 17:25
 * @Description 业务逻辑代码，
 * @Version 1.0
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public ResultInfo<User> userLogin(String name, String pwd) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        User u = new User();
        u.setUname(name);
        u.setUpwd(pwd);
        resultInfo.setRsObj(u);
        //name和pwd非空判断，设置状态0，返回
        if (name == null || "".equals(name.trim()) || pwd == null || "".equals(pwd.trim())) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("用户名或密码不能为空");
            return resultInfo;
        }
        //若用户名和密码不为空，查询数据库
        User user = userDao.queryByName(name);

        //如果数据库中不存在该用户，设置状态0，返回
        if (user == null) {
            User user1 = new User();
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("用户名不存在");
            return resultInfo;
        }
        //如果用户存在，但是密码不对，设置状态0，返回
//        System.out.println("123456 SecureUtil.md5: "+SecureUtil.md5("123456"));
//        System.out.println("123456 DigestUtil.md5Hex: "+DigestUtil.md5Hex("123456"));
        if(!user.getUpwd().equals(DigestUtil.md5Hex(pwd))) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("密码错误");
            return resultInfo;
        }
        //如果用户名和密码都匹配，设置状态1
        resultInfo.setStatusCode(1);
//        resultInfo.setMsg("用户名和密码均正确");
        resultInfo.setRsObj(user);

        return resultInfo;
    }

    public Integer checkNick(String nick, Integer userId) {
//        1. 判断昵称是否为空
        if (StrUtil.isBlank(nick)) {
//        如果为空，返回"0"
            return 0;
        }

//        2. 调用Dao层，通过用户ID和昵称查询用户对象
        User user = userDao.queryUserByNickAndUserId(nick, userId);
//        3. 判断用户对象存在
        if (user == null){
//        不存在，返回"1"，表示可用
            return 1;
        }
//        存在，返回"0"，表示不可用
        return 0;
    }

    public ResultInfo<User> updateUser(HttpServletRequest req, HttpServletResponse resp) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
//        1. 获取参数（昵称、心情）
        String nick = req.getParameter("nick");
        String mood = req.getParameter("mood");
//        2. 参数的非空校验（判断必填参数非空）
        if (StrUtil.isBlank(nick)) {
//        如果昵称为空，将状态码和错误信息设置resultInfo对象中，返回resultInfo对象
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("昵称为空");
            return  resultInfo;
        }
//        3. 从session作用域中获取用户对象（获取用户对象中默认的头像）
        User user = (User) req.getSession().getAttribute("user");
        // 设置修改的昵称和头像
        user.setNick(nick);
        user.setMood(mood);
//        4. 实现上传文件
        try {
            //1. 获取Part对象 request.getPart("name"); name代表的是file文件域的name属性值
            Part part = req.getPart("img");
//        2. 通过Part对象获取上传文件的文件名
            String header = part.getHeader("Content-Disposition");
            // 获取具体的请求头对应的值
            String str = header.substring(header.lastIndexOf("=") + 2);
            // 获取上传的文件名
            String fileName = str.substring(0, str.length() - 1);
//        3. 判断文件名是否为空，如果不为空，表示上传了文件，更新，
            //如果文件名为空，则什么都不做
            if(!StrUtil.isBlank(fileName)) {
                //如果用户上传了头像，则更新用户对象中的头像
                user.setHead(fileName);
                //4. 获取文件存放的路径  WEB-INF/upload/目录中
                String filePath = req.getServletContext().getRealPath("/WEb-INF/upload/");
                // 5. 上传文件到指定目录
                part.write(filePath + "/" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
//        5. 更新用户头像 （将原本用户对象中的默认头像设置为上传的文件名）
//        6. 调用Dao层的更新方法，返回受影响的行数
        int row = userDao.updateUser(user);
//        7. 判断受影响的行数
        //        如果大于0，则修改成功；否则修改失败
        if (row > 0) {
            resultInfo.setStatusCode(1);
            // 更新session中用户对象
            req.getSession().setAttribute("user", user);
        } else {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("更新失败！");
        }
//        8. 返回resultInfo对象
            return resultInfo;
    }
}

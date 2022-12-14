package com.loda.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.loda.dao.UserDao;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/17 10:40
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User queryUserByIdTest(Integer userId){
         User user = userDao.queryUserByIdTest(userId);
        return user;
    }

    public ResultInfo<User> queryUserByName(String userName, String userPwd){
        //定义消息对象，用于向前端返回封装的消息，用于回显数据
        ResultInfo<User> resultInfo = new ResultInfo<>();
        User u = new User();
        u.setUname(userName);
        u.setUpwd(userPwd);
        //判断参数是否为空
        if (StrUtil.isBlank(userName) || StrUtil.isBlank(userPwd)) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("userName or userPwd cannot empty!");
            resultInfo.setRsObj(u);
            return resultInfo;
        }
        //参数不为空调用dao层方法，查询用户
        User user = userDao.queryUserByName(userName);
        //用户为空，表示没有查到，
        if (user == null) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("userName doesn't exist! or userPwd is wrong!");
            resultInfo.setRsObj(u);
            return resultInfo;
        }
        // 用户密码不正确
        if (!DigestUtil.md5Hex(userPwd).equals(user.getUpwd())) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("userName doesn't exist! or userPwd is wrong!");
            resultInfo.setRsObj(u);
            return resultInfo;
        }
        //用户存在，且密码正确
        resultInfo.setStatusCode(1);
        resultInfo.setMsg("login success!");
        resultInfo.setRsObj(user);
        return resultInfo;
    }

    /**
             1. 获取参数（昵称、心情）
             2. 参数的非空校验（判断必填参数非空）
             如果昵称为空，将状态码和错误信息设置resultInfo对象中，返回resultInfo对象
             3. 从session作用域中获取用户对象（获取用户对象中默认的头像）
             4. 实现上上传文件
             1. 获取Part对象 request.getPart("name"); name代表的是file文件域的name属性值
             2. 通过Part对象获取上传文件的文件名
             3. 判断文件名是否为空
             4. 获取文件存放的路径  WEB-INF/upload/目录中
             5. 上传文件到指定目录
             5. 更新用户头像 （将原本用户对象中的默认头像设置为上传的文件名）
             6. 调用Dao层的更新方法，返回受影响的行数
             7. 判断受影响的行数
             如果大于0，则修改成功；否则修改失败
             8. 返回resultInfo对象
     * @param request
     * @param response
     * @return
     */
    public ResultInfo<User> updateUser(HttpServletRequest request, HttpServletResponse response) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        String nick = request.getParameter("nick");
        String mood = request.getParameter("mood");
        if (StrUtil.isBlank(nick)){
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("昵称为空!");
            return resultInfo;
        }
        User user = (User) request.getSession().getAttribute("user");
        String img = user.getHead();
        // 设置修改的昵称和头像
        user.setNick(nick);
        user.setMood(mood);
        //头像文件上传
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile mf = mhsr.getFile("img");

        if (mf != null && mf.getSize() >0 ) {

            //5. 更新用户头像 （将原本用户对象中的默认头像设置为上传的文件名）
            user.setHead(mf.getOriginalFilename());

            //得到webapp项目根目录在系统中的真实路径
            String basePath = request.getSession().getServletContext().getRealPath("/WEB-INF");
            System.out.println("basePath: "+ basePath);
            File upload = new File(basePath+"/upload");
            //在根目录下创建upload文件夹
            if (!upload.exists()) {
                upload.mkdir();
            }
            try {
                //将文件写入到upload文件夹下
                mf.transferTo(new File(upload, mf.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置域对象给前端
//            request.setAttribute("msg", "文件上传成功");
        }
        //6. 调用Dao层的更新方法，返回受影响的行数
        int row = userDao.updateUser(user);
//        7. 判断受影响的行数
        //如果大于0，则修改成功；否则修改失败
        if (row > 0) {
            resultInfo.setStatusCode(1);
            // 更新session中用户对象
            request.getSession().setAttribute("user", user);
        } else {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("更新失败！");
        }
//        8. 返回resultInfo对象
        return resultInfo;
    }
}

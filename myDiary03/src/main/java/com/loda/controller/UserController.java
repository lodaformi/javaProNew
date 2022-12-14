package com.loda.controller;

import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("queryUser")
    public String queryUserById(Integer userId, Model model) {
        //接收参数
        //调用service的方法
        User user = userService.queryUserByIdTest(userId);
        System.out.println("UserController user: " + user);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("user")
    public void user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置页面高亮
        request.getSession().setAttribute("nav_tab", "userCenter");
        //获取动作
        String acName = request.getParameter("actionName");
        System.out.println("acName: " + acName);
        if ("login".equals(acName)) {
            userLogin(request, response);
        } else if ("userCenter".equals(acName)) {
            userCenter(request, response);
        } else if ("logout".equals(acName)) {
            userLogout(request, response);
        }  else if ("userHead".equals(acName)) {
            userHead(request, response);
        }else if ("updateUser".equals(acName)) {
            userUpdate(request, response);
        }
    }

    //加载用户头像
    private void userHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1. 获取参数 （图片名称）
        String imgName = request.getParameter("imageName");
//        2. 得到图片的存放路径 （request.getServletContext().getealPathR("/")）
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println("realPath: "+ realPath);
//        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
//        3. 通过图片的完整路径，得到file对象
        File file = new File(realPath + "/" + imgName);
//        4. 通过截取，得到图片的后缀
        String suffix = imgName.substring(imgName.lastIndexOf(".") + 1);
//        5. 通过不同的图片后缀，设置不同的响应的类型
        if ("png".equalsIgnoreCase(suffix)) {
            response.setContentType("image/png");
        } else if ("jpg".equalsIgnoreCase(suffix) || "jpeg".equalsIgnoreCase(suffix)) {
            response.setContentType("image/jpg");
        } else if ("gif".equalsIgnoreCase(suffix)) {
            response.setContentType("image/gif");
        }
//        6. 利用FileUtils的copyFile()方法，将图片拷贝给浏览器
        FileUtils.copyFile(file, response.getOutputStream());
    }

    //更新用户信息（昵称、心情、头像）
    private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 调用Service层的方法，传递request对象作为参数，返回resultInfo对象
        ResultInfo<User> resultInfo = userService.updateUser(request, response);
//        2. 将resultInfo对象存到request作用域中
        request.setAttribute("resultInfo", resultInfo);
//        3. 请求转发跳转到个人中心页面 （user?actionName=userCenter）
        request.getRequestDispatcher("user.do?actionName=userCenter").forward(request, response);

    }

    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //删除cookie
        Cookie cookie = new Cookie("userName", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        //使当前session失效
        request.getSession().invalidate();
        //重定向到登陆页面
        response.sendRedirect("/login.jsp");
    }

    private void userCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置首页动态包含的页面值
        request.setAttribute("changePage", "user/info.jsp");
        // 2. 请求转发跳转到index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //接收前端发送过来的参数 （姓名、密码）
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //调用service层的方法，返回ResultInfo对象
        ResultInfo<User> resultInfo = userService.queryUserByName(userName, userPwd);

        //判断状态码是否为0，为0表示登陆失败
        if (resultInfo.getStatusCode() == 0) {
            request.setAttribute("resultInfo", resultInfo);
            //跳转转发到登陆页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (resultInfo.getStatusCode() == 1) {
            //获取是否勾选了“记住我”
            String remCheck = request.getParameter("rem");
            //如果勾选了“记住我”，rem的值为1
            if ("1".equals(remCheck)) {
                //创建cookie
                //不能存储从数据库中获取的密码，因为这个密码已经加密，在后面还要加密的话就不对了，
//                Cookie cookie = new Cookie("userName", resultInfo.getRsObj().getUname() + "-" + resultInfo.getRsObj().getUpwd());
                //存储的是用户输入的原始密码
                Cookie cookie = new Cookie("userName", userName + "-" + userPwd);
                //设置3天的失效时间，以秒为单位，
                cookie.setMaxAge(3 * 24 * 60 * 60);
                response.addCookie(cookie);
            } else {//如果没有勾选“记住我”
                //删除cookie
                Cookie cookie = new Cookie("userName", null);
                //时间为0，表示删除cookie
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            //设置域对象，用于登录成功后的后续操作
            request.getSession().setAttribute("user", resultInfo.getRsObj());
            //设置动态包含的页面
            request.getSession().setAttribute("changePage", "user/info.jsp");
            //登陆成功，跳转到首页
            response.sendRedirect("index.jsp");
        }
    }
}

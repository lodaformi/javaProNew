package com.loda.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.UserService;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/4 17:20
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/user")
@MultipartConfig
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置首页导航高亮
        req.setAttribute("nav_tab", "userCenter");

        String acName = req.getParameter("actionName");
        System.out.println("acName: " + acName);
        if ("login".equals(acName)) {
            loginMethod(req, resp);
        } else if ("logout".equals(acName)) {
            loginOutMethod(req, resp);
        } else if ("userCenter".equals(acName)) {
            userCenterMethod(req, resp);
        } else if ("userHead".equals(acName)) {
            userHeadMethod(req, resp);
        } else if("checkNick".equals(acName)) {
            checkNick(req, resp);
        } else if("updateUser".equals(acName)) {
            updateUser(req, resp);
        }
    }

//    注：文件上传必须在Servlet类上加上 @MultipartConfig注解！！！
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 调用Service层的方法，传递request对象作为参数，返回resultInfo对象
        ResultInfo<User> resultInfo = userService.updateUser(req, resp);
//        2. 将resultInfo对象存到request作用域中
        req.setAttribute("resultInfo", resultInfo);
//        3. 请求转发跳转到个人中心页面 （user?actionName=userCenter）
        req.getRequestDispatcher("user?actionName=userCenter").forward(req, resp);
    }

    private void checkNick(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        1. 获取参数（昵称）
        String nick = req.getParameter("nick");
//        2. 从session作用域获取用户对象，得到用户ID
        User user = (User) req.getSession().getAttribute("user");
//        3. 调用Service层的方法，得到返回的结果
        Integer code = userService.checkNick(nick, user.getUserId());
//        4. 通过字符输出流将结果响应给前台的ajax的回调函数
        resp.getWriter().write(code+"");
//        5. 关闭资源
        resp.getWriter().close();
    }

    private void userHeadMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        1. 获取参数 （图片名称）
        String imgName = req.getParameter("imageName");
//        2. 得到图片的存放路径 （request.getServletContext().getealPathR("/")）
        String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");
//        3. 通过图片的完整路径，得到file对象
        File file = new File(realPath + "/" + imgName);
//        4. 通过截取，得到图片的后缀
        String suffix = imgName.substring(imgName.lastIndexOf(".") + 1);
//        5. 通过不同的图片后缀，设置不同的响应的类型
        if ("png".equalsIgnoreCase(suffix)) {
            resp.setContentType("image/png");
        } else if ("jpg".equalsIgnoreCase(suffix) || "jpeg".equalsIgnoreCase(suffix)) {
            resp.setContentType("image/jpg");
        } else if ("gif".equalsIgnoreCase(suffix)) {
            resp.setContentType("image/gif");
        }
//        6. 利用FileUtils的copyFile()方法，将图片拷贝给浏览器
        FileUtils.copyFile(file, resp.getOutputStream());
    }

    private void userCenterMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置首页动态包含的页面值
        req.setAttribute("changePage", "user/info.jsp");
        // 2. 请求转发跳转到index
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void loginOutMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除cookie
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        //销毁session
        req.getSession().invalidate();
        //跳转到登陆页面
        resp.sendRedirect("login.jsp");
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    private void loginMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 1. 获取参数 （姓名、密码）
        String name = req.getParameter("userName");
        String pwd = req.getParameter("userPwd");
        System.out.println("name: " + name + ", pwd, " + pwd);

        // 2. 调用Service层的方法，返回ResultInfo对象
        ResultInfo resultInfo = userService.userLogin(name, pwd);

        // 3. 判断是否登录成功
        //状态码为0，表示登陆失败
        if (resultInfo.getStatusCode() == 0) {
            System.out.println("login failed");
            //  将用户信息设置到session作用域中
            req.setAttribute("resultInfo", resultInfo);
            //跳转转发到登陆页面
            req.getRequestDispatcher("login.jsp").forward(req, resp);

//            req.getSession().setAttribute("resultInfo", resultInfo);
//            resp.sendRedirect("login.jsp");

        } else {
            System.out.println("login success");
            //状态码为1，表示登陆成功
            req.getSession().setAttribute("user", resultInfo.getRsObj());
            // 判断用户是否选择记住密码（rem的值是1），如果为1，则表示勾选了记住我，能拿到标签的value=1
            if ("1".equals(req.getParameter("rem"))) {
                // 如果是，将用户姓名与密码存到cookie中，设置失效时间，并响应给客户端
                Cookie cookie = new Cookie("user", name + "-" + pwd);
                //3天有效期
                cookie.setMaxAge(3 * 24 * 60 * 60);
                // 响应给客户端
                resp.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("user", null);
                //如果以前存在cookie，将其删除
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
            //重定向到个人主页的servlet
            resp.sendRedirect("index");
        }
    }
}

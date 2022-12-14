package com.loda.servelet;

import com.loda.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @Author loda
 * @Date 2022/11/2 20:21
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/fm02")
public class FreeMarker02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置boolean数据 （给模板设置数据）
        req.setAttribute("flag", true);
        //设置日期类型数据
        req.setAttribute("date", new Date());
//        设置数值类型数据
        req.setAttribute("age", 18);
        req.setAttribute("salary", 10000);
        req.setAttribute("avg", 0.545);

//        设置字符串类型数据
        req.setAttribute("msg", "HellO");
        req.setAttribute("msg2", " freeMarker");

//        设置空值
        req.setAttribute("emp", null);
        req.setAttribute("emp2", "");

        // 序列类型 （数组、List、Set）
        // 数组操作
        String[] stars = new String[]{"周杰伦", "林俊杰", "陈奕迅", "五月天"};
        req.setAttribute("stars", stars);
        // List操作
        List<String> citys = Arrays.asList("上海", "北京", "杭州", "深圳");
        req.setAttribute("cityList", citys);

        // JavaBean集合
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"zhangsan",22));
        userList.add(new User(2,"lisi",18));
        userList.add(new User(3,"wangwu",20));
        req.setAttribute("userList",userList);


        // Map操作
        Map<String,String> cityMap = new HashMap<>();
        cityMap.put("sh","上海");
        cityMap.put("bj","北京");
        cityMap.put("sz","深圳");
        req.setAttribute("cityMap",cityMap);
        // 请求转发跳转到指定的模板页面   template/f02.ftl
        req.getRequestDispatcher("template/f02.ftl").forward(req, resp);
    }
}

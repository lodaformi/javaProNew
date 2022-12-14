package com.loda.controller;

import com.loda.entity.po.Note;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.NoteService;
import com.loda.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/10 22:40
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    private NoteService noteService = new NoteService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置高亮显示
        req.setAttribute("nav_tab", "dataReport");
        //获取动作
        String acName = req.getParameter("actionName");

        if ("dataReport".equals(acName)) {
            dataReport(req, resp);
        } else if ("month".equals(acName)) {
            // 通过月份查询对应的云记数量
            queryNoteCountByMonth(req, resp);
        } else if ("location".equals(acName)) {
            // 查询用户发布云记时的坐标
            queryNoteLonAndLat(req, resp);

        }

    }

    private void queryNoteLonAndLat(HttpServletRequest req, HttpServletResponse resp) {
        // 从Session作用域中获取用户对象
        User user = (User) req.getSession().getAttribute("user");
        // 调用Service层的查询方法，返回ResultInfo对象
        ResultInfo<List<Note>> resultInfo = noteService.queryNoteLonAndLat(user.getUserId());
        // 将ResultInfo对象转换成JSON格式的字符串，响应给AJAX的回调函数
        JsonUtil.toJson(resp, resultInfo);
    }

    private void queryNoteCountByMonth(HttpServletRequest req, HttpServletResponse resp) {
        // 从Session作用域中获取用户对象
        User user = (User) req.getSession().getAttribute("user");
        // 调用Service层的查询方法，返回ResultInfo对象
        ResultInfo<Map<String, Object>> resultInfo = noteService.queryNoteCountByMonth(user.getUserId());
        // 将ResultInfo对象转换成JSON格式的字符串，响应给ajax的回调函数
        JsonUtil.toJson(resp, resultInfo);
    }

    private void dataReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置动态包含页面
        req.setAttribute("changePage", "report/info.jsp");
        // 请求转发跳转到index.jsp
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

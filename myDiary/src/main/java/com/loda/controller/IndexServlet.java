package com.loda.controller;

import com.loda.entity.po.Note;
import com.loda.entity.po.User;
import com.loda.entity.vo.NoteInfo;
import com.loda.service.NoteService;
import com.loda.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/6 20:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private NoteService noteService = new NoteService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置首页导航高亮
        req.setAttribute("nav_tab", "index");

        String acName = req.getParameter("actionName");
        //将动作设置到域对象中，前端获取后用于分页查询，
        req.setAttribute("action", acName);

        if ("searchTitle".equals(acName)){
            // 得到查询条件：标题
            String title = req.getParameter("title");
            // 将查询条件设置到request请求域中（查询条件的回显）
            req.setAttribute("title", title);
            noteList(req, resp, title, null, null);
        }else if("searchDate".equals(acName)) {
            // 得到查询条件：日期
            String date = req.getParameter("date");
            // 将查询条件设置到request请求域中（查询条件的回显）
            req.setAttribute("date", date);

            noteList(req, resp, null, date, null);
        } else if("searchType".equals(acName)) {
            // 得到查询条件：类型ID
            String typeId = req.getParameter("typeId");
            // 将查询条件设置到request请求域中（查询条件的回显）
            req.setAttribute("typeId", typeId);
            // 日期搜索
            noteList(req, resp, null, null, typeId);
        }else  {
            noteList(req, resp, null, null, null);
        }

        // 设置首页动态包含的页面
        req.setAttribute("changePage","note/list.jsp");
        // 请求转发到index.jsp
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void searchTitle(HttpServletRequest req, HttpServletResponse resp) {
        //获取参数
        String title = req.getParameter("title");
        //接收参数 （当前页、每页显示的数量）
        String pageCurNum = req.getParameter("pageCurNum");
        String pageSize = req.getParameter("pageSize");

        // 获取Session作用域中的user对象
        User user = (User) req.getSession().getAttribute("user");

    }


    private void noteList(HttpServletRequest req, HttpServletResponse resp,
                          String title, String date, String typeId) {
        // 1. 接收参数 （当前页、每页显示的数量）
        String pageCurNum = req.getParameter("pageCurNum");
        String pageSize = req.getParameter("pageSize");

        // 2. 获取Session作用域中的user对象
        User user = (User) req.getSession().getAttribute("user");
        // 3. 调用Service层查询方法，返回Page对象
        Page<Note> page = noteService.findNoteListByPage(pageCurNum, pageSize, user.getUserId(), title, date, typeId);

        // 4. 将page对象设置到request作用域中
        req.setAttribute("page", page);

        // 通过日期分组查询当前登录用户下的云记数量
        List<NoteInfo> dateInfo = noteService.findNoteCountByDate(user.getUserId());
        // 设置集合存放在request作用域中
        req.getSession().setAttribute("dateInfo", dateInfo);

        // 通过类型分组查询当前登录用户下的云记数量
        List<NoteInfo> typeInfo = noteService.findNoteCountByType(user.getUserId());
        // 设置集合存放在request作用域中
        req.getSession().setAttribute("typeInfo", typeInfo);
    }
}

package com.loda.controller;

import com.loda.dao.NoteDao;
import com.loda.entity.po.Note;
import com.loda.entity.po.NoteType;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.NoteService;
import com.loda.service.NoteTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/8 20:43
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    private NoteService noteService = new NoteService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置高亮
        req.setAttribute("nav_tab", "note");
        String acName = req.getParameter("actionName");
        System.out.println("note servlet: "+ acName);
        if ("viewNote".equals(acName)) {
            viewNote(req, resp);
        } else if ("addOrUpdateNote".equals(acName)) {
            addOrUpdateNote(req, resp);
        } else if ("detail".equals(acName)) {
            detail(req, resp);
        } else if ("delete".equals(acName)) {
            deleteNote(req, resp);
        }
    }

    private void deleteNote(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String noteId = req.getParameter("noteId");
        //调用service方法
        Integer res = noteService.deleteNoteByNoteId(noteId);
        //删除失败返回null
        if (res == null) {
            resp.getWriter().write(0 + "");
        }
        //返回结果
        resp.getWriter().write(res + "");
        resp.getWriter().close();
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String noteId = req.getParameter("noteId");
        //调用service方法，拿到note对象
        Note note =  noteService.findNoteByNoteId(noteId);
        //如果对象为空，什么也不做
        if (note == null){
            return;
        }
        //将note对象设置到域对象中
        req.setAttribute("note", note);
        //设置动态包含的页面note/view.sjp
        req.setAttribute("changePage", "note/detail.jsp");
        //跳转到index.jsp
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void viewNote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*修改操作*/
        String noteId = req.getParameter("noteId");
        Note note = noteService.findNoteByNoteId(noteId);
        req.setAttribute("noteInfo", note);
        /*修改操作*/

        User user = (User) req.getSession().getAttribute("user");
        List<NoteType> noteTypeList = new NoteTypeService().noteTypeList(user.getUserId());

        req.setAttribute("noteTypeList", noteTypeList);

        req.setAttribute("changePage", "note/view.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     *             1. 接收参数 （类型ID、标题、内容）
     *             2. 调用Service层方法，返回resultInfo对象
     *             3. 判断resultInfo的code值
     *                 如果code=1，表示成功
     *                     重定向跳转到首页 index
     *                 如果code=0，表示失败
     *                     将resultInfo对象设置到request作用域
     *                     请求转发跳转到note?actionName=view
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addOrUpdateNote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数 （类型ID、标题、内容）
        String typeId = req.getParameter("typeId");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        // 如果是修改操作，需要接收noteId
        String noteId = req.getParameter("noteId");

        // 2. 调用Service层方法，返回resultInfo对
        ResultInfo<Note> resultInfo = noteService.addOrUpdateNote(typeId, title, content, noteId);

        if (resultInfo.getStatusCode() == 1) {//发布成功
            resp.sendRedirect("index");
        } else { //发布失败
            req.setAttribute("resultInfo", resultInfo); //设置域对象，用于数据回显
            req.getRequestDispatcher("note?actionName=viewNote").forward(req, resp);
        }
    }
}

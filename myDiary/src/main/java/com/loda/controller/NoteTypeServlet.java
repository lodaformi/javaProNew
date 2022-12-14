package com.loda.controller;

import com.loda.entity.po.NoteType;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.NoteTypeService;
import com.loda.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/7 15:56
 * @Description 类型处理类
 * @Version 1.0
 */
@WebServlet("/noteType")
public class NoteTypeServlet extends HttpServlet {
    private NoteTypeService noteTypeService = new NoteTypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置高亮显示
        req.setAttribute("nav_tab", "noteType");
        //获取用户行为
        String acName = req.getParameter("actionName");
        if ("noteType".equals(acName)) {
            noteType(req, resp);
        } else if ("delType".equals(acName)){
            delType(req, resp);
        } else if ("addOrUpdateType".equals(acName)) {
            addOrUpdateType(req, resp);
        }
    }

    /**
     * 1. 接收参数 （类型名称、类型ID）
     * 2. 获取Session作用域中的user对象，得到用户ID
     * 3. 调用Service层的更新方法，返回ResultInfo对象
     * 4. 将ResultInfo转换成JSON格式的字符串，响应给ajax的回调函数
     * @param req
     * @param resp
     */
    private void addOrUpdateType(HttpServletRequest req, HttpServletResponse resp) {
        //1. 接收参数 （类型名称、类型ID）
        String typeName = req.getParameter("typeName");
        String typeId = req.getParameter("typeId");
        // 2. 获取Session作用域中的user对象，得到用户ID
        User user = (User) req.getSession().getAttribute("user");
        //3. 调用Service层的更新方法，返回ResultInfo对象
        ResultInfo<Integer> resultInfo = noteTypeService.addOrUpdateType(typeId,typeName, user.getUserId());
        // 4. 将ResultInfo转换成JSON格式的字符串，响应给ajax的回调函数
        JsonUtil.toJson(resp, resultInfo);
    }

    /**
     * 1. 接收参数（类型ID）
     * 2. 调用Service的更新操作，返回ResultInfo对象
     * 3. 将ResultInfo对象转换成JSON格式的字符串，响应给ajax的回调函数
     * @param req
     * @param resp
     */
    private void delType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        actionName:"delType",
//        typeId:typeId
        String typeId = req.getParameter("typeId");
        ResultInfo<NoteType> resultInfo =  noteTypeService.delType(typeId);
        JsonUtil.toJson(resp, resultInfo);
    }

    /**
     *      * 查询类型列表
     *          1. 获取Session作用域设置的user对象
     *          2. 调用Service层的查询方法，查询当前登录用户的类型集合，返回集合
     *          3. 将类型列表设置到request请求域中
     *          4. 设置首页动态包含的页面值
     *          5. 请求转发跳转到index.jsp页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void noteType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 获取Session作用域设置的user对象
        User user = (User) req.getSession().getAttribute("user");
//        2. 调用Service层的查询方法，查询当前登录用户的类型集合，返回集合
        List<NoteType> typeList = noteTypeService.noteTypeList(user.getUserId());
//        3. 将类型列表设置到request请求域中
        req.setAttribute("typeList", typeList);
//         4. 设置首页动态包含的页面值
        req.setAttribute("changePage", "type/list.jsp");
//         5. 请求转发跳转到index.jsp页面
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

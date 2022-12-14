package com.loda;

import com.alibaba.fastjson.JSON;
import com.loda.entity.vo.ResultInfo;
import com.loda.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author loda
 * @Date 2022/12/6 15:24
 * @Description 全局异常处理
 * @Version 1.0
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        //默认异常处理
        mv.setViewName("error");
        mv.addObject("code", 400);
        mv.addObject("msg", "系统默认异常...");

        //判断HandlerMethod
        if (handler instanceof HandlerMethod) {
            //类型转换
            HandlerMethod mh = (HandlerMethod) handler;
            //获取方法上的ResponseBody注解
            ResponseBody annotation = mh.getMethod().getDeclaredAnnotation(ResponseBody.class);
            //判断注解是否存在
            if (annotation == null) { //如果是null，则返回的是视图，视图异常处理
                if (ex instanceof ParamsException) {
                    ParamsException pe = (ParamsException) ex;
                    mv.addObject("msg", pe.getMsg());
                    mv.addObject("code", pe.getCode());
                }
                return mv;
            } else { //如果不是null，则返回的是json，json异常处理
                ResultInfo resultInfo = new ResultInfo();
                //默认的异常处理
                resultInfo.setCode(300);
                resultInfo.setMsg("系统错误json,请稍后再试...");
                //自定义异常处理
                if (ex instanceof ParamsException) {
                    ParamsException pe = (ParamsException) ex;
                    resultInfo.setCode(pe.getCode());
                    resultInfo.setMsg(pe.getMsg());
                }
                //设置响应json方式的响应类型及编码格式
                response.setContentType("application/json;charset=utf-8");
//                response.setCharacterEncoding("utf-8");
                PrintWriter pw = null;
                try {
                    //得到输出流
                    pw = response.getWriter();
                    //将对象转化为json输出到流，返回给前台ajax的回调函数
                    pw.write(JSON.toJSONString(resultInfo));
                    pw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (pw != null) {
                        pw.close();
                    }
                }
                return null;
            }
        }
        return mv;
    }
}

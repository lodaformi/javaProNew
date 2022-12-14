package com.loda;

import com.loda.exceptions.BusinessException;
import com.loda.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/16 22:30
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("ex", "默认错误信息");

        if (ex instanceof ParamsException) {
            ParamsException pe = (ParamsException) ex;
            mv.setViewName("params_error");
            mv.addObject("ex",pe.getMsg());
        }
        if (ex instanceof BusinessException) {
            BusinessException be = (BusinessException) ex;
            mv.setViewName("busi_error");
            mv.addObject("ex", be.getMsg());
        }
//            response.getWriter().write("json");
        return mv;
    }
}

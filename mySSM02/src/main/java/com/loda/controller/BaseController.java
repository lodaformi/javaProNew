package com.loda.controller;

import com.loda.exceptions.BusinessException;
import com.loda.exceptions.ParamsException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author loda
 * @Date 2022/11/16 22:36
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class BaseController {
    public String exc(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);
        if (ex instanceof ParamsException) {
            return "params_error";
        }
        if (ex instanceof BusinessException) {
            return "busi_error";
        }
        return "error";
    }
}

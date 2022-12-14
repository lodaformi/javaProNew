package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.query.LoginInfoQuery;
import com.loda.service.LoginInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/12/6 16:37
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("loginInfo")
public class LoginInfoController extends BaseController {
    @Resource
    private LoginInfoService loginInfoService;

    @RequestMapping("info")
    public String info() {
        return "login/info";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectSaleChanceByParams(LoginInfoQuery loginInfoQuery) {
        Map<String, Object> map = loginInfoService.queryByParamsForTable(loginInfoQuery);
        return map;
    }
}

package com.loda.controller;

import com.loda.entity.po.Stu;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.RoundService;
import com.loda.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/21 23:09
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class StuController {
    @Resource
    private StuService stuService;

    @Resource
    private RoundService roundService;

    @RequestMapping("/demo2/{name}")
    @ResponseBody
    public String demo(String name, HttpServletRequest request){
        System.out.println("获取到的name:"+name);
        return "demo";
    }

    @RequestMapping("/demo/{id}")
    @ResponseBody
    public String demo(@PathVariable String name) {
        System.out.println(name);
        return "demo";
    }

    @RequestMapping("updateCall")
    @ResponseBody
    public ResultInfo<Stu> updateCall(String selectedName) {
        ResultInfo<Stu> resultInfo = new ResultInfo<>();
        Stu stu = stuService.queryUserByUserName(selectedName);
        System.out.println("stu round1: " + stu.getRound());
//        Integer userRound = stuService.queryUserRound(selectedName);
//        Stu stu = new Stu();
//        stu.setName(selectedName);
//        stu.setRound(userRound);
        //将本次学员的点评轮数+1
        stu.setRound(stu.getRound() + 1);
        //更新学员的点评轮数（+1）
        Integer row = stuService.updateCall(stu);
        resultInfo.setObj(stu);

        if (row < 1) {
            resultInfo.setCode(200);
            resultInfo.setMsg("更新失败");
        } else {
            stu = stuService.queryUserByUserName(selectedName);
            resultInfo.setCode(100);
            resultInfo.setMsg("更新成功");
        }
        return resultInfo;
    }

    @RequestMapping("index")
    public String show(HttpServletRequest request) {
        getData(null, request, "index");
//        List<String> list = stuService.queryUserNotCall();
//        //如果学员的轮数与轮数表都相等，说明都点评了，轮数表更新（+1），并重新查询queryUserNotCall
//
//        if (list.size() == 0) {
//            list = newRound();
//        }
//        StringBuilder sb = new StringBuilder();
//        //使用fori循环，便于对最后一个值进行判断
//        for (int i = 0; i < list.size(); i++) {
//            if (i == list.size() - 1) {
//                sb.append(list.get(i));
//            } else {
//                sb.append(list.get(i) + ",");
//            }
//        }
//        //设置域对象
//        request.getSession().setAttribute("list", sb.toString());
        //request.getSession().setAttribute("list", list.toString());
        //list直接返回，前端拿到的数据是这样？？['[来**', ... ' 孙**]']

        //返回index视图
        return "index";
    }

    @RequestMapping("flushData")
    @ResponseBody
    public ResultInfo<List<String>> flushData() {
        ResultInfo<List<String>> resultInfo = new ResultInfo<>();
        getData(resultInfo, null, "flushData");
//        List<String> list = stuService.queryUserNotCall();
//        //如果学员的轮数与轮数表都相等，说明都点评了，轮数表更新（+1），并重新查询queryUserNotCall
//        if (list.size() == 0) {
//            list = newRound();
//        }
//        StringBuilder sb = new StringBuilder();
//        //使用fori循环，便于对最后一个值进行判断
//        for (int i = 0; i < list.size(); i++) {
//            if (i == list.size() - 1) {
//                sb.append(list.get(i));
//            } else {
//                sb.append(list.get(i) + ",");
//            }
//        }
//        resultInfo.setObj(list);
        return resultInfo;
    }

    public void getData(ResultInfo<List<String>> resultInfo, HttpServletRequest request, String type) {
        List<String> list = stuService.queryUserNotCall();
        //如果学员的轮数与轮数表都相等，说明都点评了，
        // 轮数表更新（+1），并重新查询queryUserNotCall
        if (list.size() == 0) {
            list = newRound();
        }
        StringBuilder sb = new StringBuilder();
        //使用fori循环，便于对最后一个值进行判断
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i) + ",");
            }
        }
        if ("index".equals(type)){
            //设置域对象
            request.getSession().setAttribute("list", sb.toString());
        }else if("flushData".equals(type)){
            resultInfo.setObj(list);
        }
    }


    public List<String> newRound() {
        //得到当前轮数
        Integer curRound = roundService.getCurRound();
        //更新轮数表
        Integer row = roundService.updateRound(curRound + 1);
        //查询没有点过名的学生
        List<String> list = stuService.queryUserNotCall();
        return list;
    }
}

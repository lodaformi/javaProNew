package com.loda.controller;

import com.loda.entity.po.Account;
import com.loda.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/16 20:22
 * @Description
 * Restful  url 地址配置
 *   1.请求类型  GET POST  PUT  DELETE
 *   2.URL 设置  不体现动作成份(没有动词)  account/1   account/2 account
 *   3.参数格式
 *      路径参数
 *      json 格式| 普通表单参数
 *   4.响应内容:json
 * @Version 1.0
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * restful-->get 请求 执行查询操作
     * @param id
     * @return
     */
//    @RequestMapping("account/getAccount")
    @GetMapping("account/{id}")
    @ResponseBody
    public Account selectById(@PathVariable Integer id) {
        System.out.println("in AccountController selectById method...");
        return accountService.selectById(id);
    }


    @DeleteMapping("account/{id}")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        if(accountService.delete(id)>0){
            map.put("code", 200);
            map.put("msg", "删除账户成功");
        }else {
            map.put("code", 500);
            map.put("msg", "删除账户失败");
        }
        return map;
    }

    /**
     * restful-->post请求执行添加操作
     * @param account
     * @return
     */
    @PostMapping("account")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Account account) {
        Map<String, Object> map = new HashMap<>();
         if(accountService.add(account)>0){
             map.put("code", 200);
             map.put("msg", "添加账户成功");
         }else {
             map.put("code", 500);
             map.put("msg", "添加账户失败");
         }
         return map;
    }

    @PutMapping("account")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Account account) {
        Map<String, Object> map = new HashMap<>();
        if(accountService.update(account)>0){
            map.put("code", 200);
            map.put("msg", "更新账户成功");
        }else {
            map.put("code", 500);
            map.put("msg", "更新账户失败");
        }

        return map;
    }


}

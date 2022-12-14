package com.loda.controller;

import com.loda.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author loda
 * @Date 2022/11/15 17:03
 * @Description
 *  * 参数绑定（重点掌握前4种）
 *  *    基本类型（包装类型）
 *  *    String | Date
 *  *    数组
 *  *    JavaBean
 *  *    List|Set|Map(了解)
 * @Version 1.0
 */
@Controller
public class ParamsController {
    /**
     * 基本类型
     *    参数值必须存在  如果没有指定参数值 也没有配置默认值  此时方法 500错误!!!
     *  age is present but cannot be translated into a null value
     *  due to being declared as a primitive type.
     * @param age
     * @param s
     */
    @RequestMapping("p01")
    public void p01(int age, double s) {
        System.out.println("age: "+age+" s: " + s);
    }

    /**
     * 防止500参数错误 可以使用@RequestParam 配置参数默认值
     * @param age
     * @param s
     */
    @RequestMapping("p02")
    public void p02(@RequestParam(defaultValue = "18") int age, @RequestParam(defaultValue = "3.1415") double s) {
        System.out.println("age: "+age+" s: " + s);
    }

    /**
     * 取别名，使用别名后，原来的名字不能再使用了
     * @param age
     * @param s
     */
    @RequestMapping("p03")
    public void p03(@RequestParam(defaultValue = "18", name = "a") int age, @RequestParam(defaultValue = "3.1415") double s) {
        System.out.println("age: "+age+" s: " + s);
    }

    /**
     * 字符串参数绑定
     * 传入的参数必须和形参一样，区分大小写
     * 客户端请求参数名与方法形参名一致  默认参数值为null
     *    @RequestParam  可以设置形参的别名  参数默认值
     * @param uName
     * @param uPwd
     * @return
     */
    @RequestMapping("p04")
    public void p04(String uName, String uPwd) {
        System.out.println("uname: "+uName+", upwd: "+ uPwd);
    }

    /**
     * 包装参数绑定(推荐使用包装类型!!!)
     *     客户端请求参数名与方法形参名一致  默认参数值为null
     *      @RequestParam  可以设置形参的别名  参数默认值
     * @param age
     * @param s
     */
    @RequestMapping("p05")
    public void p05(Integer age, Double s) {
        System.out.println("age: "+age+" s: " + s);
    }

    /**
     * 传入参数为数组
     * arr=18&arr=8020&arr=33
     * @param arr
     */
    @RequestMapping("p06")
    public void p06(Integer[] arr) {
        for (Integer a : arr) {
            System.out.println(a);
        }
    }

    /**
     * 传入参数必须和类中的属性字段一一对应
     * @param user
     */
    @RequestMapping("p07")
    public void p07(User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSal());
    }

    /**
     * 列表需和javaBean对象一起使用
     * @param user
     */
    @RequestMapping("p08")
    public  void p08(User user) {
        user.getIds().forEach(System.out::println);
    }

    /**
     * 可以配合表单提交
     * map需和javaBean对象一起使用
     * @param user
     */
    @RequestMapping("p09")
    public void p09(User user) {
        user.getMap().forEach((k,v)->{
            System.out.println(k+" : "+v);
        });
    }
}

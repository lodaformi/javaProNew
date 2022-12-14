package com.loda.controller;

/**
 * @Author loda
 * @Date 2022/11/12 8:45
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class AccountServlet {
    private RoleServlet roleServlet;

//    public AccountServlet(RoleServlet roleServlet) {
//        this.roleServlet = roleServlet;
//    }

    public void setRoleServlet(RoleServlet roleServlet) {
        this.roleServlet = roleServlet;
    }

    public void test() {
        System.out.println("AccountServlet test...");
        roleServlet.test();
    }
}

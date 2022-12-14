package com.loda.controller;

/**
 * @Author loda
 * @Date 2022/11/12 8:45
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class RoleServlet {
    private AccountServlet accountServlet;
    private String name;

//    public RoleServlet(AccountServlet accountServlet) {
//        this.accountServlet = accountServlet;
//    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAccountServlet(AccountServlet accountServlet) {
        this.accountServlet = accountServlet;
    }

    public void test() {
        System.out.println("RoleServlet test...");
//        accountServlet.test();
        System.out.println("name "+ name);
    }
}

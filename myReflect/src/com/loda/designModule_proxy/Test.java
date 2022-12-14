package com.loda.designModule_proxy;

public class Test {
    public static void main(String[] args) {
        ProxyMid proxyMid = new ProxyMid();

        UserOp proxyInstance = proxyMid.getProxyInstance();

        System.out.println("main1 "+ proxyInstance.getClass());
        System.out.println("main2 "+ proxyInstance);
        System.out.println("main3 "+ proxyInstance.toString());
////        proxyInstance.addUser();
        System.out.println(proxyInstance.updateUser());
    }
}

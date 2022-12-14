package com.loda.designModule_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMid {
    private UserOp userOp = new UserImple();

    public UserOp getProxyInstance1() {
        return (UserOp) Proxy.newProxyInstance(ProxyMid.class.getClassLoader(),
                userOp.getClass().getInterfaces(),

                (proxy, method, args) -> {
                    Object obj = null;
                    long start = System.currentTimeMillis();
                    obj = method.invoke(userOp, args);
                    long end = System.currentTimeMillis();
                    System.out.println("proxyMid " + method.getName() + ", time:" + (end - start));
                    return null;
                });
    }

    public UserOp getProxyInstance() {
        return (UserOp) Proxy.newProxyInstance(ProxyMid.class.getClassLoader(),
                userOp.getClass().getInterfaces(),
                new InvocationHandler() {
                    Object obj = null;
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        obj = method.invoke(userOp, args);
                        long end = System.currentTimeMillis();
                        System.out.println(method.getName() + ", time: " + (end - start));
//                        return Integer.valueOf(123).toString();
                        return obj;
                    }
                }
        );
    }
}

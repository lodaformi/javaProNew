package com.loda.fiboDynimacProxy;

import java.lang.reflect.Proxy;

/**
 * @Author loda
 * @Date 2022/10/17 18:54
 * @Description 获取动态代理对象的中间类
 * @Version 1.0
 */
public class MiddleProxy {
    private IFibo iFibo = new FiboMethod();

    public IFibo getProxyInstance() {
        return (IFibo) Proxy.newProxyInstance(this.getClass().getClassLoader(), iFibo.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    long start = System.nanoTime();
                    System.out.println("rabbit: " + method.invoke(iFibo, args));
                    long end = System.nanoTime();
                    System.out.println("dynamicProxy time: " + (end - start) / 1000 + " us");
                    return 1L;
                });
    }
}

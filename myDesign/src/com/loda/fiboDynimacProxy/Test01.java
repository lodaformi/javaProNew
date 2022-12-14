package com.loda.fiboDynimacProxy;

/**
 * @Author loda
 * @Date 2022/10/17 20:18
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        int month = 30;
        MiddleProxy dp = new MiddleProxy();
        IFibo instance = dp.getProxyInstance();

//        System.out.println(instance.getClass());
        instance.fiboDG(month);
        instance.fiboDGOpt(month);
        instance.fiboDD(month);
    }
}

package com.loda.fiboStaticProxy;

/**
 * @Author loda
 * @Date 2022/10/17 18:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        int month = 30;
        StaticProxy sp = new StaticProxy();
        sp.fiboDG(month);
        sp.fiboDGOpt(month);
        sp.fiboDD(month);
    }
}

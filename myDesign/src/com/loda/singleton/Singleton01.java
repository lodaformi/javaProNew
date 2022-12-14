package com.loda.singleton;

/**
 * 单例模式：懒汉版
 *      1：构造函数私有化
 *      2：提供公有的访问方法
 */

public class Singleton01 {
    private static Singleton01 singleton01;

    private Singleton01(){}

    //线程不安全
    public static Singleton01 getInstance() {
        if (singleton01 == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton01 = new Singleton01();
        }
        return singleton01;
    }
}

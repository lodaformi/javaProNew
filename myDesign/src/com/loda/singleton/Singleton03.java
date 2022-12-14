package com.loda.singleton;

/**
 * @Author loda
 * @Date 2022/10/18 22:48
 * @Description 单例模式：懒汉版，解决线程不安全问题
 * @Version 1.0
 */
public class Singleton03 {
    private static volatile Singleton03 singleton;

    //构造方法私有化
    private Singleton03() {}

    //提供公有静态方法访问这个单例
    public static Singleton03 getInstance() {
        //双检
        if (singleton == null) {
            synchronized (Singleton03.class) {
                if (singleton == null) {
                    singleton = new Singleton03();
                }
            }
        }
        return singleton;
    }
}

package com.loda.singleton;

/**
 * 单例模式：饿汉版
 * 在类加载的时候就创建对象
 */
public class SingletonHungry {
//    private static SingletonHungry singletonHungry = new SingletonHungry();
    private static SingletonHungry singletonHungry;

    static {
        singletonHungry = new SingletonHungry();
    }

    //构造方法私有化
    private SingletonHungry(){}

    //公有的获取对象方法
    public static SingletonHungry getInstance() {
        return singletonHungry;
    }
}

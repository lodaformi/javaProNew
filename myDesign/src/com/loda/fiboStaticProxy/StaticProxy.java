package com.loda.fiboStaticProxy;

/**
 * @Author loda
 * @Date 2022/10/17 18:49
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class StaticProxy implements IFibo {
    private IFibo iFibo = new FiboMethod();

    @Override
    public long fiboDG(int month) {
        long start = System.nanoTime();
        System.out.println("rabbit: " + iFibo.fiboDG(month));
        long end = System.nanoTime();
        System.out.println("time: " + (end - start) / 1000 + " us");
        return 0;
    }

    @Override
    public long fiboDGOpt(int month) {
        long start = System.nanoTime();
        System.out.println("rabbit: " + iFibo.fiboDGOpt(month));
        long end = System.nanoTime();
        System.out.println("time: " + (end - start) / 1000 + " us");
        return 0;
    }

    @Override
    public long fiboDD(int month) {
        long start = System.nanoTime();
        System.out.println("rabbit: " + iFibo.fiboDD(month));
        long end = System.nanoTime();
        System.out.println("time: " + (end - start) / 1000 + " us");
        return 0;
    }
}

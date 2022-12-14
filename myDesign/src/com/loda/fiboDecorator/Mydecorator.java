package com.loda.fiboDecorator;

/**
 * @Author loda
 * @Date 2022/10/16 23:30
 * @Description Fibo装饰类
 * @Version 1.0
 */
public class Mydecorator implements IFibo {
    private IFibo iFibo;

    public Mydecorator(IFibo iFibo){
        this.iFibo = iFibo;
    }

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

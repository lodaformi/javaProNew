package com.loda.singleton;

public class Singleton02 {
    private static volatile Singleton02 singleton02;

    private Singleton02(){}

    private static class Inner{
        private static Singleton02 getInstance() {
            if (singleton02 == null) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(Singleton02.class) {
                    if (singleton02 == null) {
                        singleton02 = new Singleton02();
                    }
                }
            }
            return singleton02;
        }
    }

    public static Singleton02 getInstance() {
        return Inner.getInstance();
    }
}

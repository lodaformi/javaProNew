package com.loda.demo;

public class Methods {
    public int add(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    public int multiply(int f1, int f2) {
        return f1 * f2;
    }
}

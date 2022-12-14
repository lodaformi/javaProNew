package com.loda.quiz;

/**
 * @Author loda
 * @Date 2022/10/20 14:26
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

class A {

}

public class swap {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        A a = new A();
        A b = new A();

        System.out.println("main before: " + i + "\t" + j);
        exchange(i, j);
        System.out.println("main after: " + i + "\t" + j);

        System.out.println("main before: " + a + "\t" + b);
        exchange(a, b);
        System.out.println("main after: " + a + "\t" + b);
    }

    public static void exchange(int i, int j) {
        int k = i;
        i = j;
        j = k;
        System.out.println("exchange   : " + i + "\t" + j);
    }

    public static void exchange(A a, A b) {
        A c = a;
        a = b;
        b = c;
        System.out.println("exchange   : " + a + "\t" + b);
    }
}
package com.loda.quiz;

/**
 * @Author loda
 * @Date 2022/10/20 14:39
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
class Example1{
    public Example1(){
        System.out.print(1);
    }
}
class Example2 extends Example1{
    public Example2(){
        System.out.print(2);
    }
}
class Example3 extends Example2 {
    public Example3() {
        System.out.print(3);
    }
}
public class MySuper {
    public static void main(String[] args) {
        new Example3();
    }
}

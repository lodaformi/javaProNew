package com.loda.singleton;

public class Test01 {
    public static void main(String[] args) {
//        new Thread(()-> System.out.println(Singleton01.getInstance())).start();
//        new Thread(()-> System.out.println(Singleton01.getInstance())).start();


        new Thread(()-> System.out.println(Singleton02.getInstance())).start();
        new Thread(()-> System.out.println(Singleton02.getInstance())).start();
    }
}

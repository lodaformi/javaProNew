package com.loda.singleton;

public class TestHungry {
    public static void main(String[] args) {

        new Thread(()-> System.out.println(SingletonHungry.getInstance())).start();
        new Thread(()-> System.out.println(SingletonHungry.getInstance())).start();
        new Thread(()-> System.out.println(SingletonHungry.getInstance())).start();

    }
}

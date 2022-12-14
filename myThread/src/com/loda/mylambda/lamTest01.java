package com.loda.mylambda;

public class lamTest01 {
    public static void main(String[] args) {
        Animal a1 = (String name) -> System.out.println(name);
        a1.eat("something");
    }

}


interface Animal {
    public abstract void eat(String name);

    default void sleep() {
    }
}
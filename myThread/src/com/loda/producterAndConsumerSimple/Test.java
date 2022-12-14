package com.loda.producterAndConsumerSimple;

public class Test {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Consumer consumer = new Consumer(fruit);
        Producter producter = new Producter(fruit);

        consumer.start();
        producter.start();
    }
}

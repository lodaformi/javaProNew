package com.loda.producterAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(new ArrayList<Fruit>());
        Consumer consumer = new Consumer(warehouse);
        Producter producter = new Producter(warehouse);

        consumer.start();
        producter.start();
    }
}

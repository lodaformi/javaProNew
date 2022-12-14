package com.loda.producterAndConsumer;

public class Producter extends Thread {
    private Warehouse warehouse;
    private int cnt;

    public Producter(){}

    public Producter(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    private void newFruit(String n, Double p) {
        Fruit fruit =  new Fruit(n, p);
        warehouse.addFruit(fruit);
        System.out.println("生产者生成了："+ fruit.getName()+"，价格为："+ fruit.getPrice());
        ++cnt;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (warehouse) {
                //如果仓库中没有水果，即库存为0，则生产水果，生成几个水果呢？？
                // 只要有水果，即可通知消费者消费
                if (warehouse.getCnt() == 0) {
                    System.out.println("仓库中没有水果了，生产者马上生产，通知消费者消费");
                    if (cnt % 2 == 0) {
                        newFruit("苹果", 9.5);
                    } else {
                        newFruit("菠萝", 11.11);
                    }
                    warehouse.notify();
                } else if (warehouse.getCnt() == 10) {//如果仓库满仓，即库存为10，则等待消费者消费水果
                    System.out.println("仓库满仓，生成者等待");
                    try {
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else { //如果不为空，如果没满仓，就继续生产
                    System.out.println("仓库不满，生成者慢慢生产");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if (cnt % 2 == 0) {
                        newFruit("苹果", 9.5);
                    } else {
                        newFruit("菠萝", 11.11);
                    }
                }
            }
        }
    }
}

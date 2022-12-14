package com.loda.producterAndConsumer;

public class Consumer extends Thread {
    private Warehouse warehouse;

    public Consumer(){}

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void consumeFruit() {
        Fruit fruit = warehouse.getWarehouse().get(0);
        System.out.println("消费者消费了："+ fruit.getName()+"，价格为："+ fruit.getPrice());
        //删除水果
        warehouse.getWarehouse().remove(fruit);
        //计数减一
        int oldCnt = warehouse.getCnt();
        warehouse.setCnt(oldCnt-1);
    }

    //如果仓库没有水果，消费者等待
    //如果仓库只剩一个水果，消费者消费后，通知生产者生成水果
    //其他情况，消费者消费水果
    @Override
    public void run() {
        while (true) {
            synchronized (warehouse) {
                if (warehouse.getCnt() == 0) {
                    System.out.println("仓库中没有水果了，消费者等待");
                    try {
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if(warehouse.getCnt() == 1) {
                    System.out.println("仓库中只有1个水果了，消费者消费完，通知生产者生产");
                    consumeFruit();
                    warehouse.notify();
                } else {
                    System.out.println("仓库中水果充足，消费者慢慢消费");
                    consumeFruit();
                }
            }
        }

    }
}

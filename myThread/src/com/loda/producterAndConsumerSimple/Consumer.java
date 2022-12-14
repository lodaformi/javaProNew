package com.loda.producterAndConsumerSimple;

public class Consumer extends Thread {
    private Fruit fruit;

    public Consumer(){}

    public Consumer(Fruit fruit) {
        this.fruit = fruit;
    }

    public Consumer(String name, Fruit fruit) {
        super(name);
        this.fruit = fruit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fruit) {
                //如果仓库中有水果，消费者消费，消费完，通知生产者生产水果
                if (fruit.getHasFruit()) {
                    System.out.println("消费者消费了："+fruit.getName()+",价格为："+ fruit.getPrice());
                    fruit.setHasFruit(false);
                    fruit.notify();
                } else { //如果仓库中没有水果，等待生产，
                    try {
                        fruit.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

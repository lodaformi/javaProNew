package com.loda.producterAndConsumerSimple;

public class Producter extends Thread {
    private Fruit fruit;
    private Integer cnt;

    public Producter() {}

    public Producter(Fruit fruit) {
        this.fruit = fruit;
        cnt = 0;
    }

    public Producter(String name, Fruit fruit) {
        super(name);
        this.fruit = fruit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fruit) {
                //如果仓库中有水果，等待消费者消费，释放锁资源
                if (fruit.getHasFruit()) {
                    try {
                        fruit.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else { //如果仓库中没有水果则生产水果，生产完，通知消费者可以消费
                    if (cnt % 2 == 0) {
                        fruit.setName("apple");
                        fruit.setPrice(8.5);
                    }else {
                        fruit.setName("bananan");
                        fruit.setPrice(7.7);
                    }
                    fruit.setHasFruit(true);
                    System.out.println("生产者生产了："+fruit.getName()+",价格为："+ fruit.getPrice());
                    ++cnt;
                    fruit.notify();
                }
            }
        }
    }
}

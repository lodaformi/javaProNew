package com.loda.quiz;

import java.util.Collection;
import java.util.Random;

/**
 * @Author loda
 * @Date 2022/10/20 14:54
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class MyRandom {
    public static void main(String[] args) {
        System.out.println(Math.random());
        Random random = new Random();
        random.setSeed(100);
        System.out.println("--------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt());
        }
    }
}



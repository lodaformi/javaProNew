package com.loda.mylambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class mySupplier {
    public static void main(String[] args) {
        //获取10个 89-120的随机数集合
        int start = 89;
        int end = 120;
        List<Integer> list = getRand(10, () -> (int) (Math.random() * (120 - 89 + 1)) + 89 );
        System.out.println(list);
        start = 87;
        end = 96;
        List<Integer> list2 = getRand(15, () -> (int) (Math.random() * (87 - 96 + 1)) + 87 );
        System.out.println(list2);
    }

    public static List<Integer> getRand(int len, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(supplier.get());
        }

        return list;
    }
}

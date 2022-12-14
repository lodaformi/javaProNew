package com.loda.fiboDecorator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FiboMethod implements IFibo {
    @Override
    public long fiboDG(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        return fiboDG(month - 1) + fiboDG(month - 2);
    }

    @Override
    public long fiboDGOpt(int month) {
        long[] memo = new long[month + 1];

        return helper(memo, month);
    }


    private long helper(long[] memo, int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        if (memo[month] != 0) {
            return memo[month];
        }
        memo[month] = helper(memo, month - 1) + helper(memo, month - 2);
        return memo[month];
    }

    @Override
    public long fiboDD(int month) {
        long f_2 = 1, f_1 = 1, f = 0;
        for (int i = 3; i <= month; i++) {
            f = f_1 + f_2;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }


    public void calcTime2(Method method, int month) {
        long start = System.nanoTime();
        try {
            System.out.println("rabbit: " + method.invoke(this, month));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("time: " + (end - start) / 1000 + " us");

    }

    public void calcTime1(Method m, int month) throws InvocationTargetException, IllegalAccessException {
        long stTime1 = System.nanoTime();
        System.out.println("rabbit " + m.invoke(this, month));
        long enTime1 = System.nanoTime();
        System.out.println((enTime1 - stTime1) / 1000 + " us");
    }
}

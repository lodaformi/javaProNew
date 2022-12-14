package com.loda.FiboOpt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FiboMethod {
    public long fiboDG(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fiboDG(n - 1) + fiboDG(n - 2);
    }

    public long fiboDGOpt(int n) {
        long[] memo = new long[n + 1];

        return helper(memo, n);
    }

    private long helper(long[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public long fiboDD(int n) {
        long f_2 = 1, f_1 = 1, f = 0;
        for (int i = 3; i <= n; i++) {
            f = f_1 + f_2;
            f_2 = f_1;
            f_1 = f;
        }
        return f;
    }

    public void calcTime(Method m, int month) throws InvocationTargetException, IllegalAccessException {
        long stTime1 = System.nanoTime();
        System.out.println("rabbit " + m.invoke(this, month));
        long enTime1 = System.nanoTime();
        System.out.println((enTime1 - stTime1) / 1000 + " us");
    }
}

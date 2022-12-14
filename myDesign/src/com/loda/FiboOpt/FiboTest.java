package com.loda.FiboOpt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FiboTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int month = 42;
        FiboMethod fm = new FiboMethod();
        Class c = fm.getClass();
        Method m1 = c.getMethod("fiboDG", int.class);
        Method m2 = c.getMethod("fiboDGOpt", int.class);
        Method m3 = c.getMethod("fiboDD", int.class);

        fm.calcTime(m1, month);
        fm.calcTime(m2, month);
        fm.calcTime(m3, month);
    }
}

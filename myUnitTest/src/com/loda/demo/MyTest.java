package com.loda.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    long start;
    long end;
    @Test
    public void testInt() {
        Methods methods = new Methods();
        int res = methods.add(4, 5);
        System.out.println(res);
        Assert.assertEquals(res, 9);
    }

    @Test
    public void testMulti() {
        Methods methods = new Methods();
        int res = methods.multiply(3, 55);
        System.out.println(res);
        Assert.assertEquals(res,165);
    }

    @Before
    public void beforeTest() {
        start = System.currentTimeMillis();
        System.out.println("before------------");
    }

    @After
    public void afterTest() {
        end = System.currentTimeMillis();

        System.out.println("after---------------time:"+(end-start));
    }
}

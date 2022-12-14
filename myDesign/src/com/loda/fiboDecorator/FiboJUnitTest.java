package com.loda.fiboDecorator;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author loda
 * @Date 2022/10/17 17:56
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class FiboJUnitTest extends TestCase {
    static int month = 30;
    static  FiboMethod fm = new FiboMethod();
    long start, end;

    @Before
    public void beforeCalcTime() {
        start = System.nanoTime();
    }

    @Test
    public void calcTimeDG() {
        System.out.println("rabbit: " + fm.fiboDG(month));
    }

    @Test
    public void calcTimeDGOpt() {
        System.out.println("rabbit: " + fm.fiboDGOpt(month));
    }

    @Test
    public void calcTimeDD() {
        System.out.println("rabbit: " + fm.fiboDD(month));
    }

    @After
    public void afterCalcTime() {
        end = System.nanoTime();
        System.out.println("time: " + (end - start) / 1000 + " us");
    }
}

package com.loda.fiboDecorator;

/**
 * @Author loda
 * @Date 2022/10/16 23:04
 * @Description 测试类
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) throws NoSuchMethodException {
        int month = 30;
        FiboMethod fm = new FiboMethod();
//        long start = 0, end = 0;
//        //统计时间，方法一
//        start = System.nanoTime();
//        System.out.println("rabbit: " + fm.fiboDG(month));
//        end = System.nanoTime();
//        System.out.println("time: " + (end - start) / 1000 + " us");
//
//
//        start = System.nanoTime();
//        System.out.println("rabbit: " + fm.fiboDGOpt(month));
//        end = System.nanoTime();
//        System.out.println("time: " + (end - start) / 1000 + " us");
//
//        start = System.nanoTime();
//        System.out.println("rabbit: " + fm.fiboDD(month));
//        end = System.nanoTime();
//        System.out.println("time: " + (end - start) / 1000 + " us");

        //方法二：
//        Class cla = fm.getClass();

//        //方法二：反射1
//        calcTime(cla.getMethod("fiboDG", int.class), fm, month);
//        calcTime(cla.getMethod("fiboDGOpt", int.class), fm, month);
//        calcTime(cla.getMethod("fiboDD", int.class), fm, month);

        //方法三：反射2
//        fm.calcTime2(cla.getMethod("fiboDG", int.class), month);
//        fm.calcTime2(cla.getMethod("fiboDGOpt", int.class),month);
//        fm.calcTime2(cla.getMethod("fiboDD", int.class), month);


        //方法五：装饰者模式
        IFibo ifb = new FiboMethod();
        Mydecorator md = new Mydecorator(ifb);
        md.fiboDG(month);
        md.fiboDGOpt(month);
        md.fiboDD(month);

        //方法六：代理模式
    }



//    public static void calcTime(Method method, Object obj, int month) {
//        long start = System.nanoTime();
//        try {
//            System.out.println("rabbit: " + method.invoke(obj, month));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        long end = System.nanoTime();
//        System.out.println("time: " + (end - start) / 1000 + " us");
//    }
}


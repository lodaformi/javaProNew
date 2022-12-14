package com.loda.protocol;

/**
 * @Author loda
 * @Date 2022/10/13 21:29
 * @Description 测试类
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        SogouInput sogouInput = new SogouInput();

        DefaultSkin skin = new DefaultSkin();
//
//        MySkin skin = new MySkin();

        sogouInput.setSkin(skin);
        sogouInput.display();

        double[][] doubles = new double[3][];
        for (double[] aDouble : doubles) {
            aDouble = new double[5];
            for (double v : aDouble) {

                System.out.print(v+"\t");
            }
            System.out.println();
        }

    }
}

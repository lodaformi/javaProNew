package com.loda.quiz;

/**
 * @Author loda
 * @Date 2022/10/20 14:41
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
class Super {
    public float getNum() {
        return 3.0f;
    }
}
class Sub extends Super {
//    public float getNum(){return 4.0f;}
//    public void getNum(){}
    public void getNum(double d) {}
}

public class MyOverload {
}

package com.loda.protocol;

/**
 * @Author loda
 * @Date 2022/10/13 21:27
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class SogouInput {
    private AbstractSkin abstractSkin;

    public void setSkin(AbstractSkin abstractSkin) {
        this.abstractSkin =  abstractSkin;
    }

    public void display() {
        abstractSkin.display();

    }
}

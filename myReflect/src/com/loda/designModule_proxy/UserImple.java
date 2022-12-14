package com.loda.designModule_proxy;

public class UserImple implements UserOp{

    @Override
    public void addUser() {
        System.out.println("-----add user-----");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateUser() {
        System.out.println("-----update user-----");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "haha";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

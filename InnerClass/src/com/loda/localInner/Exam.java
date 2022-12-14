package com.loda.localInner;


public class Exam {
    public static void main(String[] args) {
        Person p = new Person();
        p.method();
    }
}

class Person {
    String name;
    int i = 20;

    public void method() {
        //在局部内部类中访问局部变量，该变量须是常量，最好把final修饰符加上去
        final int b = 10;
        i = 30;
        class Emp {
            public void show() {
                System.out.println(i);
                System.out.println(b);
            }
        }

        Emp emp = new Emp();
        emp.show();
    }
}

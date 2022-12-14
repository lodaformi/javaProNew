package com.loda.refConstructor;

import java.lang.reflect.Constructor;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Student student = new Student();
//        System.out.println(student.getClass());
//        System.out.println(Student.class);
//        System.out.println(Class.forName("com.loda.refConstructor.Student"));

        Constructor<? extends Student> constructor = student.getClass().getConstructor();
        System.out.println(constructor);
        System.out.println("-----------");
        for (Constructor<?> constructor1 : Student.class.getConstructors()) {
            System.out.println(constructor1);
        }

        Constructor<? extends Student> constructor1 = student.getClass().getConstructor(String.class, double.class, Float.class, Double.class);
        System.out.println(constructor1);
    }
}

package com.loda.refMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();

//        Method[] methods = student.getClass().getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        System.out.println(student.getClass().getMethod("showPersonPub"));
        student.getClass().getMethod("showPersonPub").invoke(student);
    }
}

package com.loda.refField;

import java.lang.reflect.Field;

public class Test01 {
    public static void main(String[] args) throws NoSuchFieldException {
        Student student = new Student();

        Field[] fields = student.getClass().getFields();
        for (Field field : student.getClass().getFields()) {
            System.out.println(field);
        }
        System.out.println("-------------");
        System.out.println(Student.class.getField("phoneNum"));
        Field add = Student.class.getField("add");
    }
}

package com.loda.refField;

import java.lang.reflect.Field;

public class Test02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field[] declaredFields = student.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("-------------");
        Field enScore = Student.class.getDeclaredField("enScore");
        enScore.set(student, 67.5);
        System.out.println(student.getEnScore());
        System.out.println("-------------");

        Field mathScore = Student.class.getDeclaredField("mathScore");
        mathScore.setAccessible(true);
        System.out.println(mathScore.get(student));
//        mathScore.set(student, 89.5);
//        System.out.println(student.getMathScore());
    }
}

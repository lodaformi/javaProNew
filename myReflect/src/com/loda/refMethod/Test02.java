package com.loda.refMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args)  {
        Student student = new Student();
        Method[] declaredMethods = Student.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        try {
            Student.class.getDeclaredMethod("showPro").invoke(student);
            Method showPri = student.getClass().getDeclaredMethod("showPri", String.class, int.class);
            showPri.setAccessible(true);
            showPri.invoke(student, "tom", 22);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

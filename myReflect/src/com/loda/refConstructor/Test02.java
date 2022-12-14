package com.loda.refConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test02 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Student student = new Student();

        Constructor<?>[] declaredConstructors = Student.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("---------");
        Constructor<? extends Student> declaredConstructor = student.getClass().getDeclaredConstructor(String.class, Integer.class,
                String.class, double.class, Float.class, Double.class);
        declaredConstructor.setAccessible(true);
        Student student1 = declaredConstructor.newInstance("abc", 123, "hh", 2.3, 55.67f, 12.34);
        System.out.println(student1);


        Constructor<? extends Student> declaredConstructor1 = student.getClass().getDeclaredConstructor(String.class, double.class);
        System.out.println(declaredConstructor1.newInstance("abc", 1.1314));

    }
}

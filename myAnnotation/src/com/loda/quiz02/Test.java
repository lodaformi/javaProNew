package com.loda.quiz02;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MyAnno(className = "com.loda.quiz02.Student", methodName = "printScore")
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Class<?> aClass = Class.forName("com.loda.quiz02.Test");
        Class<?> aClass = Test.class;

//        Class testClass = Test.class;
//        Annotation annotation1 = testClass.getAnnotation(MyAnno.class);

        MyAnno annotation = aClass.getAnnotation(MyAnno.class);

        String className = annotation.className();
        String methodName = annotation.methodName();

        Class<?> aClass1 = Class.forName(className);
        Student stu = (Student) aClass1.newInstance();
        Method method = aClass1.getMethod(methodName, Double.class);

        method.invoke(stu, 89.5);

    }
}

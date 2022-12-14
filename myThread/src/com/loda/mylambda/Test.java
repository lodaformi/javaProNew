package com.loda.mylambda;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>(
                (o1, o2) -> {
                    if (o1.getAge() == o2.getAge()) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return o1.getAge() - o2.getAge();
                    }
                }
        );

        Student stu1 = new Student("tom", 22);
        Student stu2 = new Student("tom", 18);
        Student stu3 = new Student("abc", 22);

        set.add(stu1);
        set.add(stu2);
        set.add(stu3);

        for (Student student : set) {
            System.out.println(student);
        }
    }
}

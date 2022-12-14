package com.loda.refMethod;

public class Person {
    private String name;
    private Integer age;
    protected String id;
    public Long phoneNum;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + "}";
    }

    public void showPersonPub() {
        System.out.println("showPersonPub");
    }

    protected void showPersonPro() {
        System.out.println("showPersonPro");
    }

    void showPersonDef() {
        System.out.println("showPersonDef");
    }

    private void showPersonPri() {
        System.out.println("showPersonPri ");
    }
}

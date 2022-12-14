package com.loda.myredis02.pojo;

import java.io.Serializable;

/**
 * @Author loda
 * @Date 2022/12/9 19:39
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

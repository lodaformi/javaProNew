package com.loda.entity.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/15 17:24
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String name;
    private Double sal;

    public User() {
    }

    public User(Integer id, String name, Double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return sal
     */
    public Double getSal() {
        return sal;
    }

    /**
     * 设置
     * @param sal
     */
    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String toString() {
        return "User{id = " + id + ", name = " + name + ", sal = " + sal + "}";
    }
}

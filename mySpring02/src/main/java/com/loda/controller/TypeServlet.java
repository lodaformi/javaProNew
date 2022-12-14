package com.loda.controller;

import com.loda.service.TypeService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author loda
 * @Date 2022/11/11 20:38
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class TypeServlet {
    private TypeService typeService;
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    private String host;
    public void setHost(String host) {
        this.host = host;
    }

    private int port;
    public void setPort(Integer port) {
        this.port = port;
    }

    public List<String> list;
    public void setList(List<String> list) {
        this.list = list;
    }
    public void printList() {
        list.forEach(System.out::println);
    }

    public Set<String> set;
    public void setSet(Set<String> set) {
        this.set = set;
    }
    public void printSet() {
        set.forEach(System.out::println);
    }


    private Map<String, Object> map;
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public void printMap() {
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    private Properties properties;
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void printProperties() {
        properties.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    public void test() {
        System.out.println("TypeServlet test...");
        typeService.test();
        System.out.println(host + ":" + port);

        printList();
        printSet();
        printMap();
        printProperties();

    }
}

package com.loda.quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author loda
 * @Date 2022/10/20 9:53
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class MyList {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("Hello");
        System.out.println(list.size());
        Set<String> set = new HashSet<String>();
        set.addAll(list);
        System.out.println(set.size());
    }
}

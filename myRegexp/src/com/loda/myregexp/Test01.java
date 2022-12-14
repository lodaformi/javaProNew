package com.loda.myregexp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
    public static void main(String[] args) {
//        System.out.println("ab".matches(".?\\w"));

        String str = "^(\\d+)shsxt";
        Pattern p = Pattern.compile(str);

        Matcher m = p.matcher("abcshsxt11shsxt22shsxt");

        System.out.println(m.find());
        m= p.matcher("1shsxt22shsxt");
        System.out.println(m.find());

        str= "((\\d+)(shsxt))";
        p = Pattern.compile(str);
        m = p.matcher("abcshsxt11shsxt22shsxt");
        while (m.find()) {
//            System.out.println(m.groupCount()+"-->"+m.group());
            System.out.println(m.groupCount()+"-->"+m.group()+"-->"+m.group(0));
//            System.out.println(m.group(0)+"-->"+m.group(1));
        }

    }
}

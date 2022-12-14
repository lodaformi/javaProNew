package com.loda.myregexp;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        String name = "jav124adhbf星asa1234jerry期javamikejav四a自习";
        String regx = "\\w+";
        //注意*和+号的区别，概念上+号表示字符出现一次及以上，*号表示字符出现0次及以上
        //在使用split进行切分效果上，使用*号，“自习”两字会被切开，不太符合要求
        String regx2 = "\\w*";
        String[] split = name.split(regx);
        System.out.println(split.length);
        System.out.println(Arrays.toString(split));

        //replace
        String regx3 = "干|fuck|充钱|直播间|傻B|sb";
        String state = "我要在直播间给你充钱？傻B吗";
        System.out.println(state.replaceAll(regx3, "**"));
    }
}

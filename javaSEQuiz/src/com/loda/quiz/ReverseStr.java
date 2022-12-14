package com.loda.quiz;

/**
 * @Author loda
 * @Date 2022/10/19 17:10
 * @Description 反转字符串
 * @Version 1.0
 */
public class ReverseStr {
    public static void main(String[] args) {
        String str = "hello world!";
        reverseStr1(str);
        reverseStr2(str);
    }

    public static void reverseStr1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }

    public static void reverseStr2(String str) {
        char[] cha = str.toCharArray();
        int start = 0, end = cha.length - 1;
        char tmp = '\u0000';
        while (start < end) {
            tmp = cha[start];
            cha[start] = cha[end];
            cha[end] = tmp;
            ++start;
            --end;
        }
        System.out.println(cha);
    }
}

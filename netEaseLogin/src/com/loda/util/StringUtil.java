package com.loda.util;

/**
 * @Author loda
 * @Date 2022/11/3 17:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return  str == null || "".equals(str.trim());
    }
}

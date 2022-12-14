package com.loda.utils;

import com.loda.exceptions.ParamsException;

/**
 * @Author loda
 * @Date 2022/11/19 17:09
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class AssertUtil {
    public static void isTrue(Boolean flag, String msg) throws ParamsException {
        if (flag) {
            throw new ParamsException(msg);
        }
    }
}

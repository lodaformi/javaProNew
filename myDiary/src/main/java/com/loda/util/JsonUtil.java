package com.loda.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author loda
 * @Date 2022/11/7 20:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class JsonUtil {
    public static void toJson(HttpServletResponse response, Object res) {
        PrintWriter out = null;
        try {
            // 设置响应类型及编码格式 （json类型）
            response.setContentType("application/json; charset=UTF-8");
            // 得到字符输出流
            out = response.getWriter();
            // 通过fastjson的方法，将ResultInfo对象转换成JSON格式的字符串
            String s = JSON.toJSONString(res);
            System.out.println("toJson: " + s);
            // 通过输出流输出JSON格式的字符串
            out.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            out.close();
        }
    }
}

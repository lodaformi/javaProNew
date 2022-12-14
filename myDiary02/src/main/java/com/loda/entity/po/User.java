package com.loda.entity.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/4 16:46
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class User {
    private Integer userId;
    private String uname;
    private String upwd;
    private String nick;
    private String head;
    private String mood;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", nick='" + nick + '\'' +
                ", head='" + head + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}

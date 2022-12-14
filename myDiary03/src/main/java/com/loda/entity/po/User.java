package com.loda.entity.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/4 16:46
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
//@Getter
//@Setter
public class User {
    private Integer userId;
    private String uname;
    private String upwd;
    private String nick;
    private String head;
    private String mood;


    public User() {
    }

    public User(Integer userId, String uname, String upwd, String nick, String head, String mood) {
        this.userId = userId;
        this.uname = uname;
        this.upwd = upwd;
        this.nick = nick;
        this.head = head;
        this.mood = mood;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取
     * @return upwd
     */
    public String getUpwd() {
        return upwd;
    }

    /**
     * 设置
     * @param upwd
     */
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    /**
     * 获取
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取
     * @return head
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置
     * @param head
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取
     * @return mood
     */
    public String getMood() {
        return mood;
    }

    /**
     * 设置
     * @param mood
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    public String toString() {
        return "User{userId = " + userId + ", uname = " + uname + ", upwd = " + upwd + ", nick = " + nick + ", head = " + head + ", mood = " + mood + "}";
    }
}

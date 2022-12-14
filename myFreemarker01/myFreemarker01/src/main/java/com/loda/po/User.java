package com.loda.po;

/**
 * @Author loda
 * @Date 2022/11/3 9:35
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class User {
    private Integer userId;
    private String uname;
    private Integer uage;

    public User() {
    }

    public User(Integer userId, String uname, Integer uage) {
        this.userId = userId;
        this.uname = uname;
        this.uage = uage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }
}

package com.loda.entity.po;

/**
 * @Author loda
 * @Date 2022/11/3 16:14
 * @Description 用户实体类
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String userName;
    private String userPwd;
    private String userAge;

    public User() {
    }

    public User(Integer id, String userName, String userPwd, String userAge) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return userPwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取
     * @return userAge
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * 设置
     * @param userAge
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String toString() {
        return "User{id = " + id + ", userName = " + userName + ", userPwd = " + userPwd + ", userAge = " + userAge + "}";
    }
}

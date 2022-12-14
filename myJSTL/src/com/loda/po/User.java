package com.loda.po;

/**
 * @Author loda
 * @Date 2022/11/1 10:33
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String uname;
    private String pwd;


    public User() {
    }

    public User(Integer id, String uname, String pwd) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
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
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString() {
        return "User{id = " + id + ", uname = " + uname + ", pwd = " + pwd + "}";
    }
}

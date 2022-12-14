package com.loda.entity.po;

import java.util.Date;

/**
 * @Author loda
 * @Date 2022/11/16 17:45
 * @Description 用户类
 * @Version 1.0
 */
public class User {
    private Integer id;

    private String user_name;

    private String user_pwd;

    private String true_name;

    private String email;

    private String phone;

    private Integer is_valid;

    private Date create_date;

    private Date update_date;


    public User() {
    }

    public User(Integer id, String user_name, String user_pwd, String true_name, String email, String phone, Integer is_valid, Date create_date, Date update_date) {
        this.id = id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.true_name = true_name;
        this.email = email;
        this.phone = phone;
        this.is_valid = is_valid;
        this.create_date = create_date;
        this.update_date = update_date;
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
     * @return user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 获取
     * @return user_pwd
     */
    public String getUser_pwd() {
        return user_pwd;
    }

    /**
     * 设置
     * @param user_pwd
     */
    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    /**
     * 获取
     * @return true_name
     */
    public String getTrue_name() {
        return true_name;
    }

    /**
     * 设置
     * @param true_name
     */
    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return is_valid
     */
    public Integer getIs_valid() {
        return is_valid;
    }

    /**
     * 设置
     * @param is_valid
     */
    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }

    /**
     * 获取
     * @return create_date
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * 设置
     * @param create_date
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * 获取
     * @return update_date
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * 设置
     * @param update_date
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String toString() {
        return "User{id = " + id + ", user_name = " + user_name + ", user_pwd = " + user_pwd + ", true_name = " + true_name + ", email = " + email + ", phone = " + phone + ", is_valid = " + is_valid + ", create_date = " + create_date + ", update_date = " + update_date + "}";
    }
}

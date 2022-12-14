package com.loda.entity.po;

import java.util.Date;

/**
 * @Author loda
 * @Date 2022/11/16 20:18
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Account {
    private Integer id;
    private String aname;
    private Integer type;
    private Double money;
    private Integer user_id;
    private Date create_time;
    private Date update_time;
    private String remark;

    public Account() {
    }

    public Account(Integer id, String aname, Integer type, Double money, Integer user_id, Date create_time, Date update_time, String remark) {
        this.id = id;
        this.aname = aname;
        this.type = type;
        this.money = money;
        this.user_id = user_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.remark = remark;
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
     * @return aname
     */
    public String getAname() {
        return aname;
    }

    /**
     * 设置
     * @param aname
     */
    public void setAname(String aname) {
        this.aname = aname;
    }

    /**
     * 获取
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取
     * @return money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取
     * @return user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * 设置
     * @param create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取
     * @return update_time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 设置
     * @param update_time
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "Account{id = " + id + ", aname = " + aname + ", type = " + type + ", money = " + money + ", user_id = " + user_id + ", create_time = " + create_time + ", update_time = " + update_time + ", remark = " + remark + "}";
    }
}

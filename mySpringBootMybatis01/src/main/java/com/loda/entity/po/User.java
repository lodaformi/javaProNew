package com.loda.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author loda
 * @Date 2022/11/19 16:38
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@ApiModel(description = "用户实体对象")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id主键")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "userName cannot be empty!")
    private String userName;

    @NotBlank(message = "userPwdcannotbeempty")
    @Length(min = 6, max = 15, message = "pwd length must between 6 and 15")
    @ApiModelProperty(value = "用户密码")
    private String userPwd;

    public User() {
    }

    public User(Integer id, String userName, String userPwd) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
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

    public String toString() {
        return "User{id = " + id + ", userName = " + userName + ", userPwd = " + userPwd + "}";
    }
}

package com.loda.entity.po;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * @Author loda
 * @Date 2022/11/14 20:48
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class Account {
    private Integer accountId;
    private String  accountName;
    private String accountType;
    private Double  money;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private Integer userId;

    public Account() {
    }

    public Account(String accountName, String accountType, Double money, String remark, Integer userId) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.money = money;
        this.remark = remark;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", money=" + money +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                '}';
    }
}

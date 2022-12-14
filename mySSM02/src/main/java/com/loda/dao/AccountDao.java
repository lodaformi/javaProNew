package com.loda.dao;

import com.loda.entity.po.Account;
import com.loda.entity.po.User;

/**
 * @Author loda
 * @Date 2022/11/16 17:48
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface AccountDao {
    public Account selectById(Integer id);

    public int add(Account account);

    public int update(Account account);

    public int delete(Integer id);
}

package com.loda.service;

import com.loda.dao.AccountDao;
import com.loda.entity.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author loda
 * @Date 2022/11/16 20:22
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public Account selectById(Integer id){
        return accountDao.selectById(id);
    }

    public int add(Account account){
        return accountDao.add(account);
    }

    public int update(Account account){
        return accountDao.update(account);
    }

    public int delete(Integer id) {
        return accountDao.delete(id);
    }
}

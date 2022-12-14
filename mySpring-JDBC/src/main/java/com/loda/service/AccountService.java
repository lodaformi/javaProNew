package com.loda.service;

import com.loda.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author loda
 * @Date 2022/11/14 23:40
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class AccountService {
    @Autowired
    private IAccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public int toupdateAccountByTranfer(Integer outId, Integer inId, Double money){
        int code = 0; // 成功或失败  1=成功，0=失败

        /**
         * 账户A向账户B转账100元
         *  账户A：金额-100
         *  账户B：金额+100
         */
        // 账户A 支出，修改账户金额，返回受影响的行数
        int outRow = accountDao.outAccount(outId,money);

        int i = 1/0;

        // 账户B 收入，修改账户金额，返回受影响的行数
        int inRow = accountDao.inAccount(inId, money);

        // 如果支出和收入两个操作都执行成功，表示转账成功
        if (outRow == 1 && inRow == 1) {
            code = 1; // 成功
        }

        return code;
    }

}

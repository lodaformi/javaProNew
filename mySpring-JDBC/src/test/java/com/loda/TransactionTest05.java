package com.loda;

import com.loda.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author loda
 * @Date 2022/11/14 20:55
 * @Description 测试类
 * @Version 1.0
 */

public class TransactionTest05 extends BaseDBEnv {
    @Autowired
    private AccountService accountService;

    @Test
    public void testDBEnv() {
        int i = accountService.toupdateAccountByTranfer(2, 3, 200.0);

        System.out.println("i: "+ i);
    }


}

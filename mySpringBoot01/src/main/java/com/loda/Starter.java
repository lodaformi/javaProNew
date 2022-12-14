package com.loda;

import com.loda.config.IocConfig;
import com.loda.config.IocConfig02;
import com.loda.dao.AccountDao;
import com.loda.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author loda
 * @Date 2022/11/18 15:54
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Starter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(IocConfig.class);
//        UserService userService01 = ac.getBean(UserService.class);
//        UserService userService02 = ac.getBean(UserService.class);
//        System.out.println(userService01+"---"+userService02);
//        userService.test();
//        IocConfig iocConfig = ac.getBean(IocConfig.class);
//        iocConfig.getAccountDao().test();
//        System.out.println(ac.isSingleton("iocConfig"));
//        AccountDao accountDao01 = iocConfig.getAccountDao();
//        AccountDao accountDao02 = iocConfig.getAccountDao();
//        System.out.println(accountDao01+"---"+accountDao02);
//        iocConfig.printInfo();
//        accountDao01.printInfo();
        AnnotationConfigApplicationContext ac02 = new AnnotationConfigApplicationContext(IocConfig02.class);
        IocConfig02 iocConfig02 = ac02.getBean(IocConfig02.class);
        iocConfig02.printInfo();
        iocConfig02.getAccountDao().test();
    }
}

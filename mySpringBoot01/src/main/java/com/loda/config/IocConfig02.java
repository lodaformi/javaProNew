package com.loda.config;

import com.loda.annotations.MyAnno;
import com.loda.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author loda
 * @Date 2022/11/18 15:53
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@MyAnno("com.loda")
@PropertySource(value = {"classpath:jdbc.properties", "classpath:user.properties"})
public class IocConfig02 {
    // @Bean 注解  通常用于整合第三方Bean对象  数据源 第三方组件
    @Bean
    public AccountDao getAccountDao() {
        return new AccountDao();
    }

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String pwd;

    public void printInfo() {
        System.out.println("IocConfig02 "+ driver + "--" + url + "--" + name + "--" + pwd);
    }
}

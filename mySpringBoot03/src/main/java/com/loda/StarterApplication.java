package com.loda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author loda
 * @Date 2022/11/18 18:54
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@SpringBootApplication
public class StarterApplication extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(StarterApplication.class);

    public static void main(String[] args) {
        logger.info("SpringBoot 应用开始启动。。。");
        SpringApplication springApplication = new SpringApplication(StarterApplication.class);
        // 设置banner 图标关闭
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StarterApplication.class);
    }
}

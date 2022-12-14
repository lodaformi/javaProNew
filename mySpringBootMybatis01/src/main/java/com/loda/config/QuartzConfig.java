package com.loda.config;

import com.loda.job.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author loda
 * @Date 2022/11/20 23:09
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
//@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail1(){
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //每一秒执行一次
                .withIntervalInSeconds(1)
                //永久重复，一直执行下去
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail1())
                .build();
    }

    // 每两秒触发一次任务
    @Bean
    public Trigger trigger2(){
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .forJob(jobDetail1())
                .build();
    }
}

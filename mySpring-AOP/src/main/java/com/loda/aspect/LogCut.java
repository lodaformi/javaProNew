package com.loda.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author loda
 * @Date 2022/11/14 9:50
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Component // 将对象交给IOC容器去实例化
@Aspect     // 声明当前类是一个切面
public class LogCut {


    @Pointcut("execution(* com.loda.service.*.*(..))")
    public void cut() {

    }
    /**
     * 声明前置通知 并将通知应用到定义的切入点上
     * 目标类方法执行前 执行该通知
     */
    @Before(value = "cut()")
    public void before() {
        System.out.println("前置通知...");
    }

    /**
     * 声明返回通知 并将通知应用到定义的切入点上
     * 目标类方法（无异常）执行后 执行该通知
     */
    @AfterReturning(value = "cut()")
    public void afterReturn() {
        System.out.println("返回通知...");
    }

    /**
     * 声明最终通知 并将通知应用到定义的切入点上
     * 目标类方法（无异常或有异常）执行后 执行该通知
     */
    @After(value = "cut()")
    public void after() {
        System.out.println("最终通知...");
    }

    /**
     * 声明异常通知，并将通知应用到指定的切入点上
     *      目标类的方法在执行异常时，执行该通知
     */
    @AfterThrowing(value = "cut()", throwing = "e")
    public void afterThrow(Exception e) {
        System.out.println("异常通知...异常原因："+ e.getMessage() );
    }

    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("around前置通知...");
        Object obj = null;
        try {
            obj = pjp.proceed();
            System.out.println(pjp.getTarget() + "=====" + pjp.getSignature());
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("around异常通知...");
        }
        System.out.println("around最终通知...");

        return obj;
    }
}

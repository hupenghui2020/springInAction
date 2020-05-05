package com.hph.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author com.hph
 */
// @Aspect
public class Audience {

    /*@Pointcut("execution(* com.com.hph.demo.Performance.perform(..))")
    public void performance(){}*/

    // @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    // @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    // @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP !!!");
    }

    // @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    /*@Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {

        try {
            // before
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            // 调用被通知的方法
            joinPoint.proceed();
            // afterReturn
            System.out.println("CLAP CLAP CLAP !!!");
        }catch (Throwable throwable){
            // afterThrowing
            System.out.println("Demanding a refund");
        }
    }*/
}

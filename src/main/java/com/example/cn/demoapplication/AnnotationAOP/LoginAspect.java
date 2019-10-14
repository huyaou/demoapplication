package com.example.cn.demoapplication.AnnotationAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    private Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    @Pointcut(value = "execution(public * com.example.cn.demoapplication.controller.DemoController.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getName());
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getName());
    }
}

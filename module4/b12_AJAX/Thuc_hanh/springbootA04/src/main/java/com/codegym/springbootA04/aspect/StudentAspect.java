package com.codegym.springbootA04.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class StudentAspect {
    private Logger logger = Logger.getLogger(StudentAspect.class.getName());

    @Pointcut("execution(* com.codegym.springbootA04.repository.StudentRepository.*(..))")
    public void studentRepository(){};

    @After("studentRepository()")
    // advice
    public void writeLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: " + methodName);
    }


    @Before("studentRepository()")
    // advice
    public void writeLogBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: " + methodName);
    }

    @Around("execution(* com.codegym.springbootA04.repository.StudentRepository.createStudent(..))")
    public Object writeLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around: before call " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around: after call " + methodName);
        return result;
    }
}

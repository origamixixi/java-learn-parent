package org.example.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    //重用切入点表达式
    @Pointcut("execution(* org.example.aop.*.sayHello(..))")
    public void pointCut(){}

    //前置通知
    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Logger-->前置通知，方法名：{}，参数：{}", methodName, args);
    }

    //后置通知
    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("Logger-->后置通知，方法名：{}", methodName);
    }

    //返回通知
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        log.info("Logger-->返回通知，方法名：{}，结果：{}", methodName, result);
    }

    //异常通知
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        log.info("Logger-->异常通知，方法名：{}，异常：{}", methodName, ex.getMessage(), ex);
    }

    //环绕通知
	@Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            log.info("环绕通知-->目标对象方法执行之前");
            //目标对象（连接点）方法的执行
            result = joinPoint.proceed();
            log.info("环绕通知-->目标对象方法执行之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info("环绕通知-->目标对象方法出现异常");
        } finally {
            log.info("环绕通知-->目标对象方法执行完成");
        }
        return result;
    }
}

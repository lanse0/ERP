package com.qf.sys.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class LogAop {
    public Object around(ProceedingJoinPoint joinPoint){
        String className=  joinPoint.getTarget().getClass().getSimpleName();  //获取拦截的类的类名
        String methodName= joinPoint.getSignature().getName(); //获取拦截的方法的签名
        Object[] args= joinPoint.getArgs();   //拦截的方法的参数列表
        System.out.println(className+" 类的方法"+methodName+"参数："
                + Arrays.toString(args)+"被环绕通知拦截");
        Object result=null;
        try {
            //可以做前置通知
            System.out.println("环绕通知 里面的前置通知.....");
            result=joinPoint.proceed(args);  //调用目标对象的方法
            //可以做后置通知
            System.out.println("环绕通知 里面的后置通知.....");
        } catch (Throwable throwable) {   //可以做异常通知
            System.out.println("环绕通知 里面的异常通知.....");
            throwable.printStackTrace(); }
        return result;
    }
}

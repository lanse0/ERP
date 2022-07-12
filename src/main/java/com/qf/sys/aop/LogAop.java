package com.qf.sys.aop;

import com.qf.sys.po.Emp;

import com.qf.sys.po.Log;
import com.qf.sys.service.LogService;
import com.qf.utils.HttpContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 *
 */
@Component
@Aspect
public class LogAop {
    @Resource
    private LogService logService;

    @Pointcut("execution(* com.qf.sys.service.ModuleService.getEmpModules(..))")
    public void pcLogin(){}

    public Object around(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();  //获取拦截的类的类名
        String methodName = joinPoint.getSignature().getName(); //获取拦截的方法的签名
        Object[] args = joinPoint.getArgs();   //拦截的方法的参数列表
        System.out.println(className + " 类的方法" + methodName + " 参数："
                + Arrays.toString(args) + " 被环绕通知拦截");
        Object result = null;
        try {
            //前置通知
            System.out.println("环绕通知 里面的前置通知.....");
            result = joinPoint.proceed(args);  //调用目标对象的方法
            //后置通知
            System.out.println("环绕通知 里面的后置通知.....");
        } catch (Throwable throwable) {   //可以做异常通知
            System.out.println("环绕通知 里面的异常通知.....");
            throwable.printStackTrace();
        }
        return result;
    }

    //登陆日志
    @After("pcLogin()")
    public void login(){
        //获取session
        HttpSession session = HttpContextUtil.getRequest().getSession();
        //获取session中的登陆用户信息
        Emp emp = (Emp) session.getAttribute("user");
        if (emp!=null){
            System.out.println("用户："+emp.getEmpName()+" 登陆了系统===================================");
            Log log = new Log();
            log.setEmp(emp);
            log.setContent("登陆了系统");
            //插入日志到数据库
            try {
                logService.add(log);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

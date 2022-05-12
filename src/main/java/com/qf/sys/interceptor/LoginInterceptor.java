package com.qf.sys.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//定义一个拦截器 需要实现HandlerInterceptor 接口
public class LoginInterceptor implements HandlerInterceptor {
    @Override//在进入业务控制器之前需要执行的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
            request.setAttribute("error","请登录");
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }

    @Override//在业务控制器方法执行后 但在响应前
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//在业务控制器方法所有操作执行完成后 即视图解析器执行完成后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

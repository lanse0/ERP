package com.qf.sys.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * FileName: LoginFilter
 * Author: HWang
 * Date:2022/5/12 22:22
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String url = request.getContextPath();
        System.out.println(url);
        if (session.getAttribute("user")==null){
            response.sendRedirect("/login.jsp");
            return;
        }
        filterChain.doFilter(request,response);
    }
}

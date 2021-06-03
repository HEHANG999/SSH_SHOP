package com.project.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  用户过滤器
 * @Created: 何航
 * @Date: 2021/5/14
 * @Description:
 */
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute("user") == null){// 当前session是否存有用户
            String goUrl = request.getServletPath();
            String param = request.getQueryString();
            if (param != null) goUrl = goUrl +"?"+ param;
            request.getSession().setAttribute("goUrl",goUrl);// 保存用户想服务的url

            request.getSession().setAttribute("erroe","非法请求，跳转至登录页面！");
            response.sendRedirect(request.getContextPath() + "/ulogin.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

}

package com.project.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  �û�������
 * @Created: �κ�
 * @Date: 2021/5/14
 * @Description:
 */
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute("user") == null){// ��ǰsession�Ƿ�����û�
            String goUrl = request.getServletPath();
            String param = request.getQueryString();
            if (param != null) goUrl = goUrl +"?"+ param;
            request.getSession().setAttribute("goUrl",goUrl);// �����û�������url

            request.getSession().setAttribute("erroe","�Ƿ�������ת����¼ҳ�棡");
            response.sendRedirect(request.getContextPath() + "/ulogin.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

}

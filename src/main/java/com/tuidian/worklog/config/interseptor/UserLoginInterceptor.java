package com.tuidian.worklog.config.interseptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author HJF
 * @date 2018/12/6 13:11
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (null == session.getAttribute("TDUSER")) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}

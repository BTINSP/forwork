package com.forwork.bankend.config;

import com.forwork.bankend.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

public class LoginHandleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //  根据session 获取 user
        User user = (User)request.getSession().getAttribute("user");
        if (!Objects.isNull(user)){
            return true;
        }
        //  重定向到login
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

}

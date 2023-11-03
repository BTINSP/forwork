package com.forwork.bankend.service.Impl;

import com.forwork.bankend.mapper.UserMapper;
import com.forwork.bankend.model.User;
import com.forwork.bankend.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserMapper userMapper;


    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String Login(HttpServletRequest request, HttpServletResponse response, Model model, String username, String password) {
        if (Objects.equals(request.getMethod(), "GET")) {
            return "Login";
        } else {
            User user = userMapper.MatchUser(username, password);
            if (Objects.isNull(user)){
                model.addAttribute("msg","用户名或密码错误");
                return "Login";
            }
            //  设置session user
            request.getSession().setAttribute("user", user);
            return "redirect:/student/all";
        }

    }

    @Override
    public String Logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "redirect:/login";
    }
}

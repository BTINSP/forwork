package com.forwork.bankend.controller;

import com.forwork.bankend.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method={RequestMethod.POST,RequestMethod.GET})
    public String Login(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password
            )
    {
       return loginService.Login(request,response,model,username,password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout(HttpServletRequest request) {
        return loginService.Logout(request);
    }
}

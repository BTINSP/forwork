package com.forwork.bankend.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

public interface LoginService {

    String Login(HttpServletRequest request, HttpServletResponse response, Model model, String username, String password);

    String Logout(HttpServletRequest request);
}

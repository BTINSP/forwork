package com.forwork.bankend.controller;

import com.forwork.bankend.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/manage")
public class ManageController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Manage() {
        return "redirect:/student/all";
    }



}

package com.forwork.bankend.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface StudentService {
    String Students(Model model);

    String EditStudent(HttpServletRequest request, Model model, int id);

    String UpdateStudent(Model model, int id, String name, int sex, int classId);

    String AddStudent(HttpServletRequest request,Model model, String name, Integer sex, Integer classId);

    String DeleteStudent(Model model, int id);
}

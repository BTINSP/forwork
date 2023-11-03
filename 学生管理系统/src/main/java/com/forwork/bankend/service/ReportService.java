package com.forwork.bankend.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReportService {

    String GetAllReport(Model model,Integer course_id,Integer student_id);

    String EditReport(Model model, int id);

    String UpdateReport(Model model, int id, int student_id, int course_id,int point);

    String AddReport(HttpServletRequest request,  Model model, Integer student_id, Integer course_id, Integer point);
    String DeleteReport(Model model, int id);
}

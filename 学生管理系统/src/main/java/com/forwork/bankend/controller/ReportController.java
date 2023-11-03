package com.forwork.bankend.controller;

import com.forwork.bankend.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String GetAllReport(Model model, @RequestParam(required = false)Integer course_id, @RequestParam(required = false)Integer student_id) {
        return reportService.GetAllReport(model,course_id,student_id);
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String EditReport(Model model, @RequestParam()int id){
        return reportService.EditReport(model, id);
    };

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String UpdateReport(
            Model model,
            @RequestParam()int id,
            @RequestParam()int student_id,
            @RequestParam()int course_id,
            @RequestParam()int point
    ){
        return reportService.UpdateReport(model, id, student_id, course_id, point);
    }


    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String AddReport(
            HttpServletRequest request,
            Model model,
            @RequestParam(required = false)Integer student_id,
            @RequestParam(required = false)Integer course_id,
            @RequestParam(required = false)Integer point
    ) {
        return reportService.AddReport(request, model,student_id, course_id,point);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String DeleteReport(Model model, @RequestParam()int id){
        return reportService.DeleteReport(model, id);
    }
}

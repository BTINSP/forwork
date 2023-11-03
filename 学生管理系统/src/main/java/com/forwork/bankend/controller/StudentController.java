package com.forwork.bankend.controller;

import com.forwork.bankend.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller()
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String GetStudents(Model model) {
        return studentService.Students(model);
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String EditStudent(HttpServletRequest request, Model model, @RequestParam()int id){
        return studentService.EditStudent(request, model, id);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String UpdateStudent(
            Model model,
            @RequestParam()int id,
            @RequestParam()String name,
            @RequestParam()int sex,
            @RequestParam()int classId
    ){
      return studentService.UpdateStudent(model, id, name, sex, classId);
    }

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String AddStudent(
            HttpServletRequest request,
            Model model,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)Integer sex,
            @RequestParam(required = false)Integer classId
    ){
       return studentService.AddStudent(request, model, name, sex, classId);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String DeleteStudent(Model model, @RequestParam()int id) {
        return studentService.DeleteStudent(model, id);
    }
}

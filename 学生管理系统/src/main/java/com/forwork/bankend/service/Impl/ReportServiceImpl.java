package com.forwork.bankend.service.Impl;

import com.forwork.bankend.mapper.ClassMapper;
import com.forwork.bankend.mapper.CourseMapper;
import com.forwork.bankend.mapper.ReportMapper;
import com.forwork.bankend.mapper.StudentMapper;
import com.forwork.bankend.model.Class;
import com.forwork.bankend.model.Course;
import com.forwork.bankend.model.Report;
import com.forwork.bankend.model.Student;
import com.forwork.bankend.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    private final CourseMapper courseMapper;

    private final StudentMapper studentMapper;

    public ReportServiceImpl(ReportMapper reportMapper, CourseMapper courseMapper, StudentMapper studentMapper) {
        this.reportMapper = reportMapper;
        this.courseMapper = courseMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public String GetAllReport(Model model, Integer course_id, Integer student_id) {
        //  提前请求参数
        List<Student> students = studentMapper.GetAllStudent();
        List<Course> courses = courseMapper.GetAllCourse();
        model.addAttribute("students",students);
        model.addAttribute("courses",courses);

        //  如果没有请求参数
        if (Objects.isNull(course_id) || Objects.isNull(student_id)){
            List<Report> reports = reportMapper.GetAllReport();

            model.addAttribute("reports",reports);
            return "report/Reports";
        }

        List<Report> reports = reportMapper.GetReportByCourseIdAndStudentId(course_id, student_id);
        model.addAttribute("reports",reports);
        return "report/Reports";
    }

    @Override
    public String EditReport(Model model, int id) {
        List<Student> students = studentMapper.GetAllStudent();
        List<Course> courses = courseMapper.GetAllCourse();


        model.addAttribute("students",students);
        model.addAttribute("courses",courses);

        model.addAttribute("report_id", id);
        return "report/EditReport";
    }

    @Override
    public String UpdateReport(Model model, int id, int student_id, int course_id, int point) {
        reportMapper.UpdateReport(id,student_id,course_id,point);

        List<Student> students = studentMapper.GetAllStudent();
        List<Course> courses = courseMapper.GetAllCourse();


        model.addAttribute("students",students);
        model.addAttribute("courses",courses);

        model.addAttribute("report_id", id);

        model.addAttribute("msg", "更新成功.");
        return "report/EditReport";
    }

    @Override
    public String AddReport(HttpServletRequest request, Model model, Integer student_id, Integer course_id, Integer point) {
        //  获取课程和学生列表并加入attribute
        List<Student> students = studentMapper.GetAllStudent();
        List<Course> courses = courseMapper.GetAllCourse();
        model.addAttribute("students",students);
        model.addAttribute("courses",courses);

        //  如果POST进入
        if (Objects.equals(request.getMethod(), "POST")) {
            //  如果有一个参赛为空
            if (Objects.isNull(student_id) || Objects.isNull(course_id) || Objects.isNull(point)) {
                model.addAttribute("msg", "请填写完整.");
                return "report/AddReport";
            }
            //  添加report记录
            reportMapper.AddReport(student_id,course_id,point);

            model.addAttribute("msg", "添加完成.");
            return "report/AddReport";

        }

        return "report/AddReport";
    }

    @Override
    public String DeleteReport(Model model, int id) {
        reportMapper.DeleteReport(id);
        return "redirect:/report/all";
    }
}

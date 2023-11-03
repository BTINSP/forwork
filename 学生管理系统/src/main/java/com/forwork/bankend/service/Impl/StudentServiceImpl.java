package com.forwork.bankend.service.Impl;

import com.forwork.bankend.mapper.ClassMapper;
import com.forwork.bankend.mapper.StudentMapper;
import com.forwork.bankend.model.Class;
import com.forwork.bankend.model.Student;
import com.forwork.bankend.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentMapper studentMapper;
    private final ClassMapper classMapper;

    public StudentServiceImpl(StudentMapper studentMapper,ClassMapper classMapper) {
        this.studentMapper = studentMapper;
        this.classMapper = classMapper;
    }

    @Override
    public String Students(Model model) {
        List<Student> students = studentMapper.GetAllStudent();
        List<Class> classes = classMapper.GetAllClass();
        if (Objects.isNull(students) && Objects.isNull(classes)) {
            model.addAttribute("msg", "获取数据出错");
            return "student/Students";
        }

        model.addAttribute("students", students);
        model.addAttribute("classes", classes);
        return "student/Students";
    }

    @Override
    public String EditStudent(HttpServletRequest request, Model model, int id) {

        Student student = studentMapper.GetStudentById(id);
        List<Class> classes = classMapper.GetAllClass();
        //  如果未查询到
        if (Objects.isNull(student) && Objects.isNull(classes)) {
            model.addAttribute("student", null);
            model.addAttribute("classes", null);
            return "student/EditStudent";
        }

        model.addAttribute("student", student);
        model.addAttribute("classes", classes);
        return "student/EditStudent";
    }

    @Override
    public String UpdateStudent(Model model, int id, String name, int sex, int classId) {
        //  数字转性别，防止恶意攻击
       String strSex = numSexToString(sex);
        //  根据Id更新数据
        studentMapper.UpdateStudentById(id, name, strSex, classId);

        //  根据Id查Student
        Student student = studentMapper.GetStudentById(id);
        List<Class> classes = classMapper.GetAllClass();
        model.addAttribute("student", student);
        model.addAttribute("classes", classes);
        model.addAttribute("msg", "更新成功");
        //  更新成功
        return "student/EditStudent";
    }

    @Override
    public String AddStudent(HttpServletRequest request,Model model, String name, Integer sex, Integer classId) {
        //  获取班级列表
        List<Class> classes = classMapper.GetAllClass();
        model.addAttribute("classes", classes);

        if (Objects.equals(request.getMethod(), "GET")) {
            return "student/AddStudent";
        }

        if (Objects.equals(request.getMethod(), "POST")) {
            //  如果有一个参赛为空
            if (name.isEmpty() || Objects.isNull(sex) || Objects.isNull(classId)){
                System.out.println("name is null");
                model.addAttribute("msg", "请填写完整.");
                return "student/AddStudent";
            }

            String strSex = numSexToString(sex);
            studentMapper.AddStudent(name,strSex, classId);
            model.addAttribute("msg", "添加完成.");
            return "student/AddStudent";
        }

        model.addAttribute("msg", "请正确使用提交方式.");
        return "student/AddStudent";
    }

    @Override
    public String DeleteStudent(Model model, int id) {
        //  修改is_delete字段
        studentMapper.DeleteStudent(id);
        return "redirect:/student/all";
    }


    private String numSexToString(int sex) {
        String strSex = "";
        return switch (sex) {
            case 0 -> {
                strSex = "男";
                yield strSex;
            }
            case 1 -> {
                strSex = "女";
                yield strSex;
            }
            default -> {
                strSex = "神秘生物";
                yield strSex;
            }
        };
    }
}

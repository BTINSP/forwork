package com.forwork.bankend.mapper;

import com.forwork.bankend.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course")
    List<Course> GetAllCourse();
}

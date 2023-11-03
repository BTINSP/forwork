package com.forwork.bankend.mapper;

import com.forwork.bankend.model.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportMapper {

    @Select("select * from report where is_delete = 0")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "StudentId"),
            @Result(column = "course_id", property = "CourseId"),
            @Result(column = "point", property = "Point"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    List<Report> GetAllReport();

    @Update("update report set is_delete = 1 where id = #{id}")
    void DeleteReport(@Param("id")int id);

    @Update("update report set student_id = #{student_id}, course_id = #{course_id}, point = #{point} where id = #{id}")
    void UpdateReport(
            @Param("id")int id,
            @Param("student_id")int studentId,
            @Param("course_id")int courseId,
            @Param("point")int point
    );

    @Insert("insert into report (student_id, course_id, point, create_time, update_time) value (#{student_id}, #{course_id}, #{point}, now(), now())")
    void AddReport(
            @Param("student_id")int studentId,
            @Param("course_id")int courseId,
            @Param("point")int point
    );

    @Select("select * from report where course_id = #{course_id} and student_id = #{student_id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "StudentId"),
            @Result(column = "course_id", property = "CourseId"),
            @Result(column = "point", property = "Point"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    List<Report> GetReportByCourseIdAndStudentId(
            @Param("course_id")int courseId,
            @Param("student_id")int studentId
    );
}

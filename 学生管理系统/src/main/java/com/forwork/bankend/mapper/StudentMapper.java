package com.forwork.bankend.mapper;

import com.forwork.bankend.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student where is_delete = 0")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "Name"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "class_id", property = "ClassId"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    List<Student> GetAllStudent();

    @Select("select * from student where id = #{id} and is_delete = 0")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "Name"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "class_id", property = "ClassId"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")

    })
    Student GetStudentById(@Param("id")int id);
    @Update("update student set name = #{name}, sex = #{sex}, class_id = #{class_id} where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "Name"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "class_id", property = "ClassId"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    void UpdateStudentById(
            @Param("id")int id,
            @Param("name")String name,
            @Param("sex")String sex,
            @Param("class_id")int class_id
    );

    @Insert("insert into student (name, sex, class_id, create_time, update_time) value (#{name}, #{sex}, #{class_id},now(),now())")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "Name"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "class_id", property = "ClassId"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    void AddStudent(
            @Param("name")String name,
            @Param("sex")String sex,
            @Param("class_id")int class_id
    );

    @Update("update student set is_delete = 1 where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "Name"),
            @Result(column = "sex", property = "Sex"),
            @Result(column = "class_id", property = "ClassId"),
            @Result(column = "create_time", property = "CreateTime"),
            @Result(column = "update_time", property = "UpdateTime"),
            @Result(column = "is_delete", property = "IsDelete")
    })
    void DeleteStudent( @Param("id")int id);


}

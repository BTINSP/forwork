package com.forwork.bankend.mapper;

import com.forwork.bankend.model.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {

    @Select("select * from class")
    List<Class> GetAllClass();
}

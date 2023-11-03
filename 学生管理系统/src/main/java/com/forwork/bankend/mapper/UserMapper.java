package com.forwork.bankend.mapper;

import com.forwork.bankend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    User MatchUser(@Param("username") String username, @Param("password")String password);


}

package com.forwork.bankend.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Result;

import java.sql.Timestamp;

public class Student {
    private int Id;
    private String Name;
    private String Sex;

    private int ClassId;
    private Timestamp CreateTime;

    private Timestamp UpdateTime;

    private boolean IsDelete;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        UpdateTime = updateTime;
    }


}

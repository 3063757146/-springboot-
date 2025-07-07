package com.etoak.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

//------------12/10 11:38
@Data
@TableName(value = "sys_user")
public class SysUser {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    // real_name 表中
    // realName  实体类
    @TableField("real_name")
    private String realName;
    private Integer age;
    private Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private Integer status;
    // 在没有构造方法时候
    // 默认有一个无参构造
    //
    public SysUser(){

    }
    public SysUser(String username){
        this.username = username;
    }
    public SysUser(String username,String password){
        this.username = username;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getUsername() {
        return username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGender() {
        return gender;
    }
}

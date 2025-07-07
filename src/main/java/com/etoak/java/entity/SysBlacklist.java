package com.etoak.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@lombok.Data
@TableName(value = "sys_black_list")
public class SysBlacklist {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String studentId;
    private  String studentName;
    private String grade;
    private  String speciality;
    private String classes;
    private String entryReason;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;
    private Date releaseTime;
    private  Integer status;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName(){ return studentName;}

    public String getSpeciality() {
        return speciality;
    }
    public String getClasses() {return classes;}
    public String getEntryReason() {
        return entryReason;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setEntryTime(Date EntryTime) {
        this.entryTime = EntryTime;
    }

    public void setEntryReason(String EntryReason) { this.entryReason = EntryReason;}

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setclasses(String classes) {
        this.classes = classes;
    }

    public void setReleaseTime(Date releaseTime) {this.releaseTime = releaseTime;}

}

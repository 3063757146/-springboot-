package com.etoak.java.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName(value = "lending_management")
public class Lend {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "book_id")
    private Integer bookId;
    @TableField(value = "book_name")
    private String bookName;
    @TableField(value = "borrower_name")
    private String borrowerName;
    @TableField(value = "borrower_id")
    private Integer borrowerId;
    @TableField(value = "borrower_faculty")
    private String borrowerFaculty;
    @TableField(value = "borrower_grade")
    private String borrowerGrade;
    @TableField(value = "borrower_profession")
    private String borrowerProfession;
    @TableField(value = "borrower_class")
    private String borrowerClass;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lend_time")
    private Date lendTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "should_return_time")
    private Date shouldReturnTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "real_return_time")
    private Date realReturnTime;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerFaculty() {
        return borrowerFaculty;
    }

    public void setBorrowerFaculty(String borrowerFaculty) {
        this.borrowerFaculty = borrowerFaculty;
    }

    public String getBorrowerGrade() {
        return borrowerGrade;
    }

    public void setBorrowerGrade(String borrowerGrade) {
        this.borrowerGrade = borrowerGrade;
    }

    public String getBorrowerProfession() {
        return borrowerProfession;
    }

    public void setBorrowerProfession(String borrowerProfession) {
        this.borrowerProfession = borrowerProfession;
    }

    public String getBorrowerClass() {
        return borrowerClass;
    }

    public void setBorrowerClass(String borrowerClass) {
        this.borrowerClass = borrowerClass;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getShouldReturnTime() {
        return shouldReturnTime;
    }

    public void setShouldReturnTime(Date shouldReturnTime) {
        this.shouldReturnTime = shouldReturnTime;
    }

    public Date getRealReturnTime() {
        return realReturnTime;
    }

    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}

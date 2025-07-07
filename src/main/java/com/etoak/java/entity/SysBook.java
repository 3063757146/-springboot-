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
@TableName(value = "sys_book_manage")
public class SysBook {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String bookname;
    private String author;

    private String category;

    @TableField("book_introduction")
    private String bookIntroduction;

    private Integer integrity;

    @TableField("release_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date releaseTime;

    @TableField("storage_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    
    private Date storageTime;

//    @TableField("num_books")
//    private Integer numBooks;

    // 在没有构造方法时候
    // 默认有一个无参构造
    //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public String getcategory() {
        return category;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

}

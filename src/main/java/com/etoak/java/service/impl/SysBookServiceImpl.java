package com.etoak.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.java.entity.SysBook;
import com.etoak.java.mapper.SysBookMapper;
import com.etoak.java.service.ISysBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysBookServiceImpl
        extends ServiceImpl<SysBookMapper, SysBook>
        implements ISysBookService {

    @Autowired
    SysBookMapper sysBookMapper;

    public List<SysBook> login(String username,String password){
        QueryWrapper params = new QueryWrapper();
        params.eq("username",username);
        params.eq("password",password);

        List<SysBook> resultList
                = sysBookMapper.selectList(params);

        return resultList;
    }

    @Override
    public List<SysBook> getBookList(SysBook sysBook) {
//        System.out.println("------查询-----------------------");

        // 查询器对象 -> 添加一些查询条件
        QueryWrapper qw = new QueryWrapper();
        if(sysBook.getBookname()!= null && !"".equals(sysBook.getBookname())){
            // 证明前端输入了真实书名作为查询条件
            // 第一个参数 要与数据库中的列名保持一致，而不是和实体类中的属性名一致
            qw.like("bookname",sysBook.getBookname());
        }
        if(sysBook.getAuthor() != null){
            qw.like("author",sysBook.getAuthor());
        }
        // 通过Mapper接口查询用户列表
        List<SysBook> resultList
                = sysBookMapper.selectList(qw);
        return resultList;
    }
}

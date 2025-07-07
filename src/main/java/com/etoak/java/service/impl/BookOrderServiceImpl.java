package com.etoak.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.java.entity.BookOrder;
import com.etoak.java.mapper.BookOrderMapper;
import com.etoak.java.service.IBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrderServiceImpl extends ServiceImpl<BookOrderMapper, BookOrder>
        implements IBookOrderService {
    @Autowired
    BookOrderMapper bookOrderMapper;
    @Override
    public List<BookOrder> getUserList(BookOrder bookOrder) {
        // 查询器对象 -> 添加一些查询条件
        QueryWrapper qw = new QueryWrapper();
        if(bookOrder.getBookName() != null && !"".equals(bookOrder.getBookName())){
            qw.eq("book_name",bookOrder.getBookName());
        }
        if(bookOrder.getAuthor() != null && !"".equals(bookOrder.getAuthor())){
            qw.eq("gender",bookOrder.getAuthor());
        }
        // 通过Mapper接口查询用户列表
        List<BookOrder> resultList
                = bookOrderMapper.selectList(qw);
        return resultList;
    }

}

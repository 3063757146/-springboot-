package com.etoak.java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.java.entity.BookOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookOrderService extends IService<BookOrder> {
    public List<BookOrder> getUserList(BookOrder bookOrder);
}

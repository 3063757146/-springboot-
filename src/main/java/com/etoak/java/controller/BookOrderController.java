package com.etoak.java.controller;


import com.etoak.java.entity.BookOrder;
import com.etoak.java.service.impl.BookOrderServiceImpl;
import com.etoak.java.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class BookOrderController {
    @Autowired
    BookOrderServiceImpl bookOrderService;

    @RequestMapping("/list")//拦截所有类型请求
    public ResultVO getUserList(BookOrder bookOrder){
        try{
            //获取用户列表
            List<BookOrder> resultList
                    =bookOrderService.getUserList(bookOrder);
            //创建返回结果
            return ResultVO.success(resultList);
        }catch (Exception e){
            //打印日志->开发人员排除异常
            e.printStackTrace();
        }
        return ResultVO.fail();
    }

    @RequestMapping("/getById")
    public ResultVO getById(Integer id){
        return ResultVO.success(bookOrderService.getById(id));
    }

    @RequestMapping("/add")
    public ResultVO add(BookOrder bookOrder){
        boolean result =  bookOrderService.save(bookOrder);
        if(result){
            return ResultVO.success(null);
        }
        else{
            return ResultVO.fail();
        }
    }
    @RequestMapping("/delete")
    public ResultVO delete(Integer id){
        boolean result =
                bookOrderService.removeById(id);
        if(result) {
            return ResultVO.success(null);
        }else {
            return ResultVO.fail();
        }
    }
    @RequestMapping("/update")
    public ResultVO update(BookOrder bookOrder){
        boolean result = bookOrderService.updateById(bookOrder);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }
}

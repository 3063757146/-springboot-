package com.etoak.java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.java.entity.SysBook;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Author 高俊 QQ:1120934832
 * @Slogan 易途科技，精英启航
 */
@Service
public interface ISysBookService
        extends IService<SysBook> {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public List<SysBook> login(String username,String password);

    /**
     * 查询用户列表
     */
    public List<SysBook> getBookList(SysBook sysBook);
}

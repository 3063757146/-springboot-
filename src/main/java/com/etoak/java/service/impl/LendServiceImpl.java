package com.etoak.java.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.java.entity.Lend;
import com.etoak.java.mapper.LendMapper;
import com.etoak.java.service.ILendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendServiceImpl
        extends ServiceImpl<LendMapper, Lend>
        implements ILendService {
    @Autowired
    LendMapper lendMapper;

    @Override
    public List<Lend> getLendList(Lend lend) {
        // 查询器对象 -> 添加一些查询条件
        QueryWrapper qw = new QueryWrapper();
        if(lend.getBookId()!=null){
            qw.like("id",lend.getBookId());
        }
        if(lend.getBookName()!=null && !"".equals(lend.getBookName())){
            qw.like("book_name",lend.getBookName());
        }
        if(lend.getBorrowerName()!=null && !"".equals(lend.getBorrowerName())){
            qw.like("borrower_name",lend.getBorrowerName());
        }
        // 通过Mapper接口查询用户列表
        List<Lend> resultList
                = lendMapper.selectList(qw);
        return resultList;
    }
}

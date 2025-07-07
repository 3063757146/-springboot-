package com.etoak.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.java.entity.SysBlacklist;
import com.etoak.java.mapper.SysBlacklistMapper;
import com.etoak.java.service.ISysBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class SysBlacklistServiceImpl
        extends ServiceImpl<SysBlacklistMapper, SysBlacklist>
        implements ISysBlacklistService {
    @Autowired
    SysBlacklistMapper sysBlacklistMapper;
        public List<SysBlacklist> login(String username, String password){
            QueryWrapper params = new QueryWrapper();
            params.eq("username",username);
            params.eq("password",password);
           List<SysBlacklist> resultList=
                   sysBlacklistMapper.selectList(params);
           return resultList;
        }

    @Override
    public List<SysBlacklist> getUserList(SysBlacklist sysBlacklist) {

            QueryWrapper qw = new QueryWrapper();
            if(sysBlacklist.getStudentName() != null &&!"".equals(sysBlacklist.getStudentName())){
                qw.like("student_name", sysBlacklist.getStudentName());
            }
            if(sysBlacklist.getSpeciality()!=null){
                qw.like("speciality", sysBlacklist.getSpeciality());
            }
            List<SysBlacklist> resultlist
                    = sysBlacklistMapper.selectList(qw);
            return resultlist;

    }
    public boolean releaseById(SysBlacklist sysBlacklist){
        UpdateWrapper<SysBlacklist> updateWrapper = new UpdateWrapper<>();
        SysBlacklist sysBlacklist1 = new SysBlacklist();
        sysBlacklist1.setStatus(1);
        sysBlacklist1.setReleaseTime(new Date());
        updateWrapper.eq("id", sysBlacklist.getId());
        if(sysBlacklistMapper.update(sysBlacklist1,updateWrapper) == 1) return true;
        else return false;
    }
    public boolean HaveUser(String studentId) {
        QueryWrapper<SysBlacklist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId).eq("status", 0);
        SysBlacklist student = sysBlacklistMapper.selectOne(queryWrapper);
        return student != null;
    }

}

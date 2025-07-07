package com.etoak.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.java.entity.SysUser;
import com.etoak.java.mapper.SysUserMapper;
import com.etoak.java.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Author 高俊 QQ:1120934832
 * @Slogan 易途科技，精英启航
 */
@Service
public class SysUserServiceImpl
        extends ServiceImpl<SysUserMapper, SysUser>
        implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public List<SysUser> login(String username,String password){
        QueryWrapper params = new QueryWrapper();
        params.eq("username",username);
        params.eq("password",password);

        List<SysUser> resultList
                = sysUserMapper.selectList(params);

        return resultList;
    }

    @Override
    public List<SysUser> getUserList(SysUser sysUser) {
        // 查询器对象 -> 添加一些查询条件
        QueryWrapper qw = new QueryWrapper();
        if(sysUser.getRealName() != null && !"".equals(sysUser.getRealName())){
            // 证明前端输入了真实姓名作为查询条件
            // 第一个参数 要与数据库中的列名保持一致，而不是和实体类中的属性名一致
            qw.like("real_name",sysUser.getRealName());
        }
        if(sysUser.getAge() != null){
            qw.like("age",sysUser.getAge());
        }
        if(sysUser.getGender() != null){
            qw.like("gender",sysUser.getGender());
        }
        // 通过Mapper接口查询用户列表
        List<SysUser> resultList
                = sysUserMapper.selectList(qw);
        return resultList;
    }
    public SysUser getByUsername(String username)
    {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return sysUserMapper.selectOne(queryWrapper);
    }
    public boolean changePassword(String username,String password)
    {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        SysUser user = sysUserMapper.selectOne(queryWrapper);
        if (user != null) {
            System.out.println(user);
            System.out.println(password);

            user.setPassword(password);
            int updatedRows = sysUserMapper.update(user, queryWrapper);
            System.out.println(updatedRows);
            return updatedRows > 0;  //修改成功
        } else
        {
            return false; // 未找到用户
        }
    }
}

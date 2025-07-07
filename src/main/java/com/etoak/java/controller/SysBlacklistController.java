package com.etoak.java.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.etoak.java.entity.SysBlacklist;
import com.etoak.java.service.impl.SysBlacklistServiceImpl;
import com.etoak.java.vo.ResultVO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blacklist")
@CrossOrigin
public class SysBlacklistController
{
    @Autowired
    SysBlacklistServiceImpl sysUserService;

    @GetMapping("/login")
    public String login(@RequestParam Map<String,Object> params)
    {
        String username =(String) params.get("username");
        String password =(String) params.get("password");
        List<SysBlacklist> resultList=
                sysUserService.login(username,password);
        if(resultList != null && resultList.size() > 0){
            return "登陆成功";
        }else{
            return "账号或密码错误";
        }

    }

    @RequestMapping("/list")
    public ResultVO getUserList(SysBlacklist sysBlacklist){
       try {
           List<SysBlacklist> resultList
                   = sysUserService.getUserList(sysBlacklist);
           return ResultVO.success(resultList);
       }catch (Exception e){
           e.printStackTrace();//把错误信息打印到日志文件中，给开发人员看
       }
       return ResultVO.fail();
    }
    @RequestMapping("/add")
    public ResultVO add(SysBlacklist sysuser){
        sysuser.setEntryTime(new Date());
        Boolean result = sysUserService.save(sysuser);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }

    @RequestMapping("/delete")
    public ResultVO delete(Integer id){//新增方法接口
        boolean result =
                sysUserService.removeById(id);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }

    @RequestMapping("/release")
    public ResultVO release(@NotNull SysBlacklist sysBlacklist){//新增方法接口

        boolean result =
                sysUserService.releaseById(sysBlacklist);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }

    @RequestMapping("/getById")
    public ResultVO getById(Integer id){
        return ResultVO.success(sysUserService.getById(id));
    }
    @RequestMapping("/update")
    public ResultVO update(SysBlacklist sysuser){
        boolean result = sysUserService.updateById(sysuser);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }
    @RequestMapping("/HaveUser")
    public ResultVO HaveUser(String studentId)
    {//判断此学号是否在黑名单内 并且状态为0
        boolean result=sysUserService.HaveUser(studentId);
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }
}


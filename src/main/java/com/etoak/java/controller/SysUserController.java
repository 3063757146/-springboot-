package com.etoak.java.controller;

import com.etoak.java.entity.SysUser;
import com.etoak.java.service.impl.SysUserServiceImpl;
import com.etoak.java.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class SysUserController {
    /**
     * 依赖注入
     */
    @Autowired
    SysUserServiceImpl sysUserService;
    /**
     *
     * @param params
     * @return
     */

    @GetMapping ("/login")
    public ResultVO login(
            @RequestParam Map<String,Object> params){
        String username = (String)params.get("username");
        String password = (String)params.get("password");
        System.out.println(username+"   "+password);

        List<SysUser> resultList
                = sysUserService.login(username,password);
        if(resultList != null && resultList.size()>0){
            System.out.println("成功");
            return ResultVO.success(null);
        }else{
            System.out.println("失败");
            return ResultVO.fail();
        }

    }

    /**
     * 获取用户列表的接口
     * @return
     */
    @RequestMapping("/list")
    public ResultVO getUserList(SysUser sysUser){
        try {
            // 获取用户列表
            List<SysUser> resultList
                    = sysUserService.getUserList(sysUser);
            return ResultVO.success(resultList);
        }catch (Exception e){
            // 打印日志 -> 开发人员排除异常
            e.printStackTrace();
        }
        return ResultVO.fail();
    }

    //http://localhost:8081/user/add 可以访问此方法
    @RequestMapping("/add")
    public  ResultVO add(SysUser sysUser)
    {
        SysUser existingUser = sysUserService.getByUsername(sysUser.getUsername());
        if (existingUser != null) {  //数据库用户名不能重复 重复则添加失败
            return ResultVO.error();
        }
        sysUser.setCreateTime(new Date());
        boolean result=sysUserService.save(sysUser);

        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();
    }

    @RequestMapping("/delete")
    public ResultVO delete(Integer id)
    {

        boolean result=sysUserService.removeById(id);
        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();
    }
    @RequestMapping("/change")
    public ResultVO change(String username,String password)
    {
        boolean result=sysUserService.changePassword(username,password);
        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();
    }
}

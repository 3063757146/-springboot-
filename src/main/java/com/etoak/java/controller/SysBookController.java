package com.etoak.java.controller;

import com.etoak.java.entity.SysBook;
import com.etoak.java.service.impl.SysBookServiceImpl;
import com.etoak.java.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * @Author 高俊 QQ:1120934832
 * @Slogan 易途科技，精英启航
 */
@RestController
@RequestMapping("/book")
@CrossOrigin
public class SysBookController {
    /**
     * 依赖注入
     */
    @Autowired
    SysBookServiceImpl sysBookService;
    /**
     *
     * @param params
     * @return
     */
    @RequestMapping("/login")
    public String login(
            @RequestParam Map<String,Object> params){
        String username = (String)params.get("username");
        String password = (String)params.get("password");

        List<SysBook> resultList
                = sysBookService.login(username,password);
        if(resultList != null && resultList.size()>0){
            return "登录成功";
        }else{
            return "账号或密码错误！";
        }
    }

    /**
     * 获取用户列表的接口
     * @return
     */
    @RequestMapping("/list")
    public ResultVO getBookList(SysBook sysBook){
        try {
            // 获取用户列表
            List<SysBook> resultList
                    = sysBookService.getBookList(sysBook);
            return ResultVO.success(resultList);
        }catch (Exception e){
            // 打印日志 -> 开发人员排除异常
            e.printStackTrace();
        }
        return ResultVO.fail();
    }

    //http://localhost:8081/Book/add 可以访问此方法
    @RequestMapping("/add")
    public  ResultVO add(SysBook sysBook)
    {
        sysBook.setStorageTime(new Date());
        boolean result=sysBookService.save(sysBook);

        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();
    }

    @RequestMapping("/delete")
    public ResultVO delete(Integer id)
    {
        boolean result=sysBookService.removeById(id);
        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();
    }
    @RequestMapping("/getById")
    public ResultVO getById(Integer id)
    {
       // sysBookService.getBybookname;
       return  ResultVO.success(sysBookService.getById(id));
    }
    @RequestMapping("/update")
    public ResultVO update(SysBook sysBook)
    {
        boolean result=sysBookService.updateById(sysBook);
        if(result)return  ResultVO.success(null);
        else return ResultVO.fail();    }
}

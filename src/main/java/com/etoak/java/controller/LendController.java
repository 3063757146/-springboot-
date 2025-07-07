package com.etoak.java.controller;
import com.etoak.java.entity.Lend;
import com.etoak.java.service.impl.LendServiceImpl;
import com.etoak.java.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lend")
@CrossOrigin
public class LendController {
    @Autowired
    LendServiceImpl lendService;
    @RequestMapping("/list")
    public  ResultVO getLendList(Lend lend){
        try {
            // 获取用户列表
            List<Lend> resultList
                    = lendService.getLendList(lend);
            //Integer.parseInt("高");
            return ResultVO.success(resultList);
        }catch (Exception e){
            // 打印日志 -> 开发人员排除异常
            e.printStackTrace();
        }
        return ResultVO.fail();
    }
    @RequestMapping("/add")
    public ResultVO add(Lend lend){
        //todo 注册时间
        lend.setLendTime(new Date());
        boolean result= lendService.save(lend);
        if(result){return ResultVO.success(null);}
        else{return ResultVO.fail();}
    }
    @RequestMapping("/delete")
    public ResultVO delete(Lend lend){
        boolean result=lendService.removeById(lend.getId());
        if(result){
            return ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }
    @RequestMapping("/getById")
    public ResultVO getById(Integer id){
        return  ResultVO.success(lendService.getById(id));
    }
    @RequestMapping("/update")
    public ResultVO update(Lend lend){
        boolean result = lendService.updateById(lend);
        if(result){
            return  ResultVO.success(null);
        }else{
            return ResultVO.fail();
        }
    }
}

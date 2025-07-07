package com.etoak.java.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @Author 高俊 QQ:1120934832
 * @Slogan 易途科技，精英启航
 *
 *
 * 构造方法
 * SysUser sysUser = new SysUser();
 */
@Data // getter setter
@NoArgsConstructor // 添加无参构造
@AllArgsConstructor // 全参的构造
public class ResultVO<T> {

    /**
     * code = 200 成功
     * code = 500 业务逻辑代码有问题（接口报错）
     * code = 404 URL找不到，资源目录无法定位
     */
    private Integer code;

    /**
     * 响应的描述
     * 成功：success
     * 异常：接口请求超时，请稍后再试
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public static <T> ResultVO<T> success(T data){
        return new ResultVO<>(200,"SUCCESS",data);
    }

    public static <T> ResultVO<T> fail(){
        return new ResultVO<>(500,"系统异常",null);
    }
    public static <T> ResultVO<T> error(){
        return new ResultVO<>(700,"重复",null);
    }

}

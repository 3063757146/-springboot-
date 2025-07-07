package com.etoak.java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.java.entity.SysBlacklist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISysBlacklistService
    extends IService<SysBlacklist>{
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public List<SysBlacklist> login(String username, String password);

    public List<SysBlacklist> getUserList(SysBlacklist sysBlacklist);

}



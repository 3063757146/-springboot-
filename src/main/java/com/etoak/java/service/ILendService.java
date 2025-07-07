package com.etoak.java.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.java.entity.Lend;
//import com.etoak.java.entity.Library;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ILendService extends IService<Lend>{
    public List<Lend> getLendList(Lend lend);
}

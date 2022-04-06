package com.world.ordercar.service.ServiceImpl;

import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.mapper.LoginMapper;
import com.world.ordercar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public List<LoginEntity> selectAll(){
        List<LoginEntity> list = loginMapper.selectAll();
        return list;
    }


}

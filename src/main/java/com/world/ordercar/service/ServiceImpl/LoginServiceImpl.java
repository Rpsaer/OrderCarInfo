package com.world.ordercar.service.ServiceImpl;

import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;
import com.world.ordercar.mapper.LoginMapper;
import com.world.ordercar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public List<LoginEntity> selectAll(String account, String password) {
        return loginMapper.selectAll(account, password);
    }

    @Override
    public List<OrderCarEntity> selectAllPlaceInfo(int role) {
        if (role == 1) {
            return loginMapper.managerSelectAllPlaceInfo();
        }
        return loginMapper.userSelectAllPlaceInfo();
    }


    @Override
    @Transactional
    public void orderCarPlace(String account, String holder, String licenseNum) {
        LoginEntity body = loginMapper.selectName(account);
        loginMapper.updateOrderInfo(body.getName(), licenseNum, holder);
    }


}

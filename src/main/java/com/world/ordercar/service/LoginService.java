package com.world.ordercar.service;

import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;

import java.util.List;

public interface LoginService {

    List<LoginEntity> selectAll(String account, String password);

    List<OrderCarEntity> selectAllPlaceInfo(int role);

    void orderCarPlace(String account, String holder, String licenseNum);

}

package com.world.ordercar.service;

import com.world.ordercar.entity.LoginEntity;

import java.util.List;

public interface LoginService {

    List<LoginEntity> selectAll();
}

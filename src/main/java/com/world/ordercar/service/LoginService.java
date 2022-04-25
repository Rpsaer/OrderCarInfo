package com.world.ordercar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface LoginService extends IService<OrderCarEntity> {

    List<LoginEntity> selectAll(String account, String password);

    List<OrderCarEntity> selectAllPlaceInfo(int role);

    boolean orderCarPlace( String holder, String licenseNum);

    void openUserCarInfo(String account,String licenseNum,long holderPhone) throws ParseException;

    List<OrderCarEntity> checkAllOpenInfo();

    List<OrderCarEntity> selectById(int id);

    void refuseOrderInfo(int id) throws ParseException;

    void editOrderInfo(int canOrderId, int id, Date now);
}

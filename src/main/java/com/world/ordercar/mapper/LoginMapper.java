package com.world.ordercar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<OrderCarEntity> {

    List<LoginEntity> selectAll(@Param(value = "account") String account, @Param(value = "password") String password);

    List<OrderCarEntity> managerSelectAllPlaceInfo();

    List<OrderCarEntity> userSelectAllPlaceInfo();

    LoginEntity selectName(@Param(value = "account") String account);

    void updateOrderInfo(@Param(value = "name") String name, @Param(value = "licenseNum") String licenseNum, @Param(value = "holder") String holder);


}

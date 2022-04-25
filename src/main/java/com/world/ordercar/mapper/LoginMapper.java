package com.world.ordercar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<OrderCarEntity> {

    List<LoginEntity> selectAll(@Param(value = "account") String account, @Param(value = "password") String password);

    List<OrderCarEntity> managerSelectAllPlaceInfo();

    List<OrderCarEntity> userSelectAllPlaceInfo(@Param(value = "holderPhone")long holderPhone);

    LoginEntity selectName(@Param(value = "account") String account);

    void updateOrderInfo( @Param(value = "licenseNum") String licenseNum, @Param(value = "holder") String holder);

    List<OrderCarEntity> selectLists();

    OrderCarEntity selectInfo(@Param(value = "licenseNum") String licenseNum, @Param(value = "holder") String holder);

    List<OrderCarEntity> selectById(@Param(value = "id")int id);

    void refuseOrderInfo(@Param("updateTime")Date updateTime,@Param("id")int id);

    void editOrderInfo(@Param("canOrder")int canOrder,@Param("updateTime")Date updateTime,@Param("id")int id);

}

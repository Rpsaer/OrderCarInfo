package com.world.ordercar.mapper;

import com.world.ordercar.entity.LoginEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    List<LoginEntity> selectAll();

}

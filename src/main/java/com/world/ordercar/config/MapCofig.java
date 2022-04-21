package com.world.ordercar.config;


import com.world.ordercar.entity.LoginEntity;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MapCofig {

    public  final ConcurrentHashMap<String, LoginEntity> map = new ConcurrentHashMap<>();


}

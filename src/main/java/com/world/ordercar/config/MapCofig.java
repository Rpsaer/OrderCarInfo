package com.world.ordercar.config;


import com.world.ordercar.entity.LoginEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapCofig {

    public  final ConcurrentHashMap<String, LoginEntity> map = new ConcurrentHashMap<>();


}

package com.world.ordercar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.world.ordercar.mapper")
public class OrderCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCarApplication.class, args);
    }

}

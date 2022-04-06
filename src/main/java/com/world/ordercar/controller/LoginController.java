package com.world.ordercar.controller;


import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class LoginController {

    @Resource
    private LoginService loginService;


    @PostMapping(value = "/login")
    public List<LoginEntity> test(){
        return loginService.selectAll();
    }


}

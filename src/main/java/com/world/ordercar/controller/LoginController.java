package com.world.ordercar.controller;


import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;
import com.world.ordercar.service.LoginService;
import com.world.ordercar.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class LoginController {

    @Resource
    private LoginService loginService;


    /**
     * @Description 登录
     * @Author
     * @Date 2022/4/9 10:16
     */
    @PostMapping(value = "/login")
    public Result tologin(@RequestParam String account, @RequestParam String password) {
        List<LoginEntity> list = loginService.selectAll(account, password);
        if (list.size() == 0) return new Result(999, "用户不存在", -1);
        return new Result(200, "success", list.get(0).getRole());
    }


    /**
     * @Description  查询当前车位
     * @Author
     * @Date 2022/4/9 10:17
     */
    @PostMapping(value = "/check")
    public Result toCheck(@RequestParam int role) {
        List<OrderCarEntity> list = loginService.selectAllPlaceInfo(role);
        return new Result(200, "success", role,list);
    }


    /**
    * @Description  预定某一车位
    * @Author
    * @Date   2022/4/9 11:28
    */
    @PostMapping(value = "order")
    public Result toOrder(@RequestParam String account ,@RequestParam String holder,@RequestParam String licenseNum){
        loginService.orderCarPlace(account,holder,licenseNum);
        return new Result(200,"success",null);
    }


}

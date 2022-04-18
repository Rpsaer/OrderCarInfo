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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * @Description 查询当前车位
     * @Author
     * @Date 2022/4/9 10:17
     */
    @PostMapping(value = "/check")
    public Result toCheck(@RequestParam int role) {
        List<OrderCarEntity> list = loginService.selectAllPlaceInfo(role);
        return new Result(200, "success", role, list);
    }


    /**
     * @Description 预定某一车位
     * @Author
     * @Date 2022/4/9 11:28
     */
    @PostMapping(value = "/order")
    public Result toOrder(@RequestParam String account, @RequestParam String holder, @RequestParam String licenseNum) {
        loginService.orderCarPlace(account, holder, licenseNum);
        return new Result(200, "success", null);
    }

    /**
     * @Description 当前用户开放自己的车位信息去审批
     * @Author
     * @Date 2022/4/18 11:29
     */
    @PostMapping(value = "/toOpen")
    public Result openToOrder(@RequestParam String account, @RequestParam String licenseNum, @RequestParam long holderPhone) throws ParseException {
        loginService.openUserCarInfo(account, licenseNum, holderPhone);
        return new Result(200, "success", null);
    }

    /**
     * @Description 管理员查看所有要审批信息
     * @Author
     * @Date 2022/4/18 11:39
     */
    @PostMapping(value = "/checkOpenInfo")
    public Result checkOpenInfo() {
        return new Result(200, "success", 0, loginService.checkAllOpenInfo());
    }


    @PostMapping(value = "/dealOpenInfo")
    public Result dealOpenInfo(OrderCarEntity orderCarEntity) throws ParseException {
        Date nowDay = new Date();
        String str = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(str);
        Date now = sf.parse(sf.format(nowDay));
        orderCarEntity.setUpdate_time(now);
        orderCarEntity.setCar_order(0);
        loginService.saveOrUpdate(orderCarEntity);
        return new Result(200, "success", null);
    }


}

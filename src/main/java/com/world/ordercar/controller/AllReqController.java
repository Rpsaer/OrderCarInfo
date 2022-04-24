package com.world.ordercar.controller;


import com.world.ordercar.config.MapCofig;
import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.service.LoginService;
import com.world.ordercar.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class AllReqController {

    @RequestMapping("/login")
    public String toLogin() {
        return "Login";
    }


    @Resource
    private LoginService loginService;


    @Autowired
    private MapCofig mapCofig;


    /**
     * @Description 登录
     * @Author
     * @Date 2022/4/9 10:16
     */
    @PostMapping(value = "/login")
    public String tologin(@RequestParam String account, @RequestParam String password) {
        //md5加密
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        List<LoginEntity> list = loginService.selectAll(account, password);
        if (list.size() == 0) return "login";
        mapCofig.map.put("account", list.get(0));
        if (list.get(0).getRole() == 0) {
            return "index2";
        } else {
            return "index";
        }
    }

    @RequestMapping("index2")
    public String index2() {
        return "index2";
    }

    @RequestMapping("getListUser")
    public String Get2() {
        return "OrderCarListUser";
    }


    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("/getList")
    public String Get() {
        return "OrderCarList";
    }

    @RequestMapping("/getOpenList")
    public String GetOpenInfo() {
        return "ManCheckOpenInfo";
    }


}

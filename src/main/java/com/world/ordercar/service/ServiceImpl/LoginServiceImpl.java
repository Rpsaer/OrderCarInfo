package com.world.ordercar.service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.world.ordercar.config.MapCofig;
import com.world.ordercar.entity.LoginEntity;
import com.world.ordercar.entity.OrderCarEntity;
import com.world.ordercar.mapper.LoginMapper;
import com.world.ordercar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, OrderCarEntity> implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Autowired
    private MapCofig mapCofig;

    @Override
    public List<LoginEntity> selectAll(String account, String password) {
        return loginMapper.selectAll(account, password);
    }

    @Override
    public List<OrderCarEntity> selectAllPlaceInfo(int role) {
        long phone = mapCofig.map.get("account").getHolderPhone();
        if (role == 1) {
            return loginMapper.managerSelectAllPlaceInfo();
        }
        return loginMapper.userSelectAllPlaceInfo(phone);
    }


    @Override
    public boolean orderCarPlace( String holder, String licenseNum) {
        OrderCarEntity orderCarEntity= loginMapper.selectInfo(licenseNum,holder);
        if (orderCarEntity.getCar_order()!=0){
            return false;
        }else{
            loginMapper.updateOrderInfo( licenseNum, holder);
            return true;
        }
    }

    @Override
    public void openUserCarInfo(String account,String licenseNum,long holderPhone) throws ParseException {
        LoginEntity item = loginMapper.selectName(account);
        OrderCarEntity userInfo = new OrderCarEntity();
        userInfo.setUser("暂未开放使用");
        userInfo.setCar_order(3);
        userInfo.setUser_sex(item.getSex());
        userInfo.setHolder(item.getName());
        userInfo.setLicense_num(licenseNum);
        userInfo.setHolder_phone(holderPhone);
        Date nowDay = new Date();
        String str = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(str);
        Date now = sf.parse(sf.format(nowDay));
        userInfo.setCreate_time(now);
        userInfo.setUpdate_time(now);
        loginMapper.insert(userInfo);
    }

    @Override
    public List<OrderCarEntity> checkAllOpenInfo(){
//        QueryWrapper<OrderCarEntity> user = new QueryWrapper<>();
//        user.eq("can_order",3);
        List<OrderCarEntity> list = loginMapper.selectLists();
        return list;
    }





}

package com.world.ordercar.util;

import com.world.ordercar.entity.OrderCarEntity;

import java.util.List;

public class Result {
    int code;
    String msg;
    Object data;
    int role;
    List<OrderCarEntity> parking_info;

    public Result() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Result(int code, String msg, int role) {
        this.code = code;
        this.msg = msg;
        this.role = role;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg,int role, List<OrderCarEntity> parking_info) {
        this.code = code;
        this.msg = msg;
        this.role = role;
        this.parking_info = parking_info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<OrderCarEntity> getParking_info() {
        return parking_info;
    }

    public void setParking_info(List<OrderCarEntity> parking_info) {
        this.parking_info = parking_info;
    }
}

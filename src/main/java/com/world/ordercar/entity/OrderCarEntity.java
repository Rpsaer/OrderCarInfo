package com.world.ordercar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderCarEntity {

    private int id;
    private String license_num;
    private int holder_phone;
    private String holder;
    private String user;
    private int user_sex;
    private int can_order;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_num() {
        return license_num;
    }

    public void setLicense_num(String license_num) {
        this.license_num = license_num;
    }

    public int getHolder_phone() {
        return holder_phone;
    }

    public void setHolder_phone(int holder_phone) {
        this.holder_phone = holder_phone;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public int getCar_order() {
        return can_order;
    }

    public void setCar_order(int car_order) {
        this.can_order = car_order;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "OrderCarEntity{" +
                "id=" + id +
                ", license_num='" + license_num + '\'' +
                ", holder_phone=" + holder_phone +
                ", holder='" + holder + '\'' +
                ", user='" + user + '\'' +
                ", user_sex=" + user_sex +
                ", car_order=" + can_order +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

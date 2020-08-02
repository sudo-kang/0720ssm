package com.rengu.springboot.entity;

import java.io.Serializable;

/**
 * Created by kang on 2020/7/21.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 70067825752237137L;
    private int uId;
    private String uName;
    private String uage;
    private String addr;
    private String city;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uage='" + uage + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

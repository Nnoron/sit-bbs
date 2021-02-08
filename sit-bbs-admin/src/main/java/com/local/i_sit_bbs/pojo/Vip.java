package com.local.i_sit_bbs.pojo;

public class Vip {
    private Integer userId;

    public Vip(Integer userId) {
        this.userId = userId;
    }

    public Vip() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
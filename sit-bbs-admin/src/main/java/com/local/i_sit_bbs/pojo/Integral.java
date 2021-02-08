package com.local.i_sit_bbs.pojo;

public class Integral {
    private Integer userId;

    private Integer integral;

    public Integral(Integer userId, Integer integral) {
        this.userId = userId;
        this.integral = integral;
    }

    public Integral() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
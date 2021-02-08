package com.local.i_sit_bbs.pojo;

public class Follower {

    private Integer userId;

    //粉丝
    private Integer followerId;

    public Follower(Integer userId, Integer followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public Follower() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }
}
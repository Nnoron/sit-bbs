package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Follower;

import java.util.List;

public interface FollowerMapper {
    int insert(Follower record);

    int insertSelective(Follower record);

    int deleteConcern(Follower follower);

    List<Follower> getAllFans(Integer userId);

    List<Follower> getAllConcern(Integer userId);

    int ifConcern(Follower follower);

    int getFansNum(Integer userId);

    int getConcernNum(Integer followerId);
}
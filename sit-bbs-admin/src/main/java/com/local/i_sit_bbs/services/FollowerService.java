package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.Follower;
import com.local.i_sit_bbs.pojo.UserInfo;

import java.util.List;

public interface FollowerService {

    List<UserInfo> getAllFans(Integer userId);

    List<UserInfo> getAllConcern(Integer userId);

    int ifConcern(Follower follower);

    int addConcern(Follower follower);

    int deleteConcern(Follower follower);

    //userId->follower,查询粉丝
    int getFansNum(Integer userId);

    //follower->userId,查询关注
    int getConcernNum(Integer followerId);


}

package com.local.i_sit_bbs.services.servicesImp;

import com.local.i_sit_bbs.dao.FollowerMapper;
import com.local.i_sit_bbs.dao.UserInfoMapper;
import com.local.i_sit_bbs.pojo.Follower;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerServiceImp implements FollowerService {

    @Autowired
    FollowerMapper followerMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAllFans(Integer userId) {
        List<Follower> followers = followerMapper.getAllFans(userId);
        List<Integer> fansIds = new ArrayList<>();
        followers.forEach(follower -> fansIds.add(follower.getFollowerId()));
        if (fansIds.size() > 0) {
            return userInfoMapper.getUserInfoByIds(fansIds);
        } else return null;
    }

    @Override
    public List<UserInfo> getAllConcern(Integer userId) {
        List<Follower> followers = followerMapper.getAllConcern(userId);
        List<Integer> concernIds = new ArrayList<>();
        followers.forEach(follower -> concernIds.add(follower.getUserId()));
        if (concernIds.size() > 0) {
            return userInfoMapper.getUserInfoByIds(concernIds);
        } else return null;
    }


    @Override
    public int ifConcern(Follower follower) {
        return followerMapper.ifConcern(follower);
    }

    @Override
    public int addConcern(Follower follower) {
        return followerMapper.insertSelective(follower);
    }

    @Override
    public int deleteConcern(Follower follower) {
        return followerMapper.deleteConcern(follower);
    }

    @Override
    public int getFansNum(Integer userId) {
        return followerMapper.getFansNum(userId);
    }

    @Override
    public int getConcernNum(Integer followerId) {
        return followerMapper.getConcernNum(followerId);
    }
}

package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.vo.UserInfoVo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo getUserInfoById(Integer id);

    List<UserInfo> getUserInfo(UserInfo userInfo);

    UserInfo getUserByName(String userName);

    int editUserInfo(UserInfo userInfo);

    List<UserInfo> getUserInfoByIds(List<Integer> ids);

    int addArv(UserInfo userInfo);
}
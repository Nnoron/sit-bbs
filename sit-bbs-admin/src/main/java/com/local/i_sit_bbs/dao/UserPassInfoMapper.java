package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.UserPassInfo;
import com.local.i_sit_bbs.vo.RequestPassInfoVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPassInfoMapper {
    int insert(UserPassInfo record);

    int insertSelective(UserPassInfo record);

    UserPassInfo getUserPassInfo(RequestPassInfoVo requestPassInfoVo);

    int editUserPassInfo(UserPassInfo userPassInfo);
}
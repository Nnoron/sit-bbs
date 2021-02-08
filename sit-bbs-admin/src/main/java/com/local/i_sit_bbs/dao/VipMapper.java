package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Vip;
import org.springframework.stereotype.Repository;

@Repository
public interface VipMapper {
    int insert(Vip record);

    int insertSelective(Vip record);
}
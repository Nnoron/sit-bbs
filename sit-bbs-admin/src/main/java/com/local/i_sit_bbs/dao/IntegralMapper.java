package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Integral;
import com.local.i_sit_bbs.vo.IntegralVo;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegralMapper {
    int insert(Integral record);

    int insertSelective(Integral record);

    Integral getIntegral(Integer id);

    int editIntegral(IntegralVo integralVo);
}
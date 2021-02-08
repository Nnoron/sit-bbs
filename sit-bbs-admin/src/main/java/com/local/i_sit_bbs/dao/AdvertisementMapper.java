package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Advertisement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementMapper {
    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    int deleteAdv(Advertisement advertisement);

    int editAdv(Advertisement advertisement);

    List<Advertisement> getAdvs(Advertisement advertisement);
}
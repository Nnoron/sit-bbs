package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Dic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DicMapper {
    int insert(Dic record);

    int insertSelective(Dic record);

    List<Dic> getAllDic();
}
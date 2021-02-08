package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.Top;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopMapper {
    int insert(Top record);

    int insertSelective(Top record);

    List<Top> getTopsByParams(Top top);

    int getTopsNumThisWeek(String date);

    Top getTopById(Integer articleId);

    int deleteTop(Integer id);
}
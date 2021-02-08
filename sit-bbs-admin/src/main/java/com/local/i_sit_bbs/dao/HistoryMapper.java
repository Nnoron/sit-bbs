package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.History;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMapper {
    int insert(History record);

    int insertSelective(History record);
}
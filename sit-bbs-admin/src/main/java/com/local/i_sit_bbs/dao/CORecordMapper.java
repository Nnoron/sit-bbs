package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.CORecord;
import java.util.List;

public interface CORecordMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CORecord record);

    List<CORecord> selectAll();

    int updateByPrimaryKey(CORecord record);

    int ifExisted(CORecord coRecord);
}
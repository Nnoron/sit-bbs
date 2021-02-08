package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.CollectionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionInfoMapper {

    int insert(CollectionInfo record);

    int insertSelective(CollectionInfo record);

    int deleteCollection(CollectionInfo collectionInfo);

    List<CollectionInfo> getCollections(String userId);
}
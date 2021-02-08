package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.CollectionInfo;
import com.local.i_sit_bbs.vo.ArticleInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CollectionService {

    int addCollection(CollectionInfo collectionInfo);

    int deleteCollecticon(CollectionInfo collectionInfo);

    List<ArticleInfoVo> getCollections(String userId);
}

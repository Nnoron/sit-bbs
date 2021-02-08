package com.local.i_sit_bbs.services.servicesImp;

import com.local.i_sit_bbs.dao.ArticleInfoMapper;
import com.local.i_sit_bbs.dao.CollectionInfoMapper;
import com.local.i_sit_bbs.dao.UserInfoMapper;
import com.local.i_sit_bbs.pojo.ArticleInfo;
import com.local.i_sit_bbs.pojo.CollectionInfo;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.CollectionService;
import com.local.i_sit_bbs.vo.ArticleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CollectionServiceImp implements CollectionService {

    @Autowired
    CollectionInfoMapper collectionInfoMapper;
    @Autowired
    ArticleInfoMapper articleInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int addCollection(CollectionInfo collectionInfo) {
        Date date=new Date();
        SimpleDateFormat sldf=new SimpleDateFormat("yyyy-MM-dd");
        collectionInfo.setCollectTime(sldf.format(date));
        return collectionInfoMapper.insertSelective(collectionInfo);
    }

    @Override
    public int deleteCollecticon(CollectionInfo collectionInfo) {
        return collectionInfoMapper.deleteCollection(collectionInfo);
    }

    @Override
    public List<ArticleInfoVo> getCollections(String userId) {
        //查询收藏夹中所有articleId
        List<CollectionInfo> collectionInfoList=collectionInfoMapper.getCollections(userId);
        HashMap<Integer,String> collectTimeMap=new HashMap<>();
        List<Integer> articleIds=new ArrayList<>();
        for (CollectionInfo collectionInfo:collectionInfoList){
            if(!articleIds.contains(collectionInfo.getArticleId())){
                articleIds.add(collectionInfo.getArticleId());
            }
            collectTimeMap.put(collectionInfo.getArticleId(),collectionInfo.getCollectTime());
        }

        if(articleIds.size()>0){
            //批量查询articleInfo
            List<ArticleInfo> articleInfoList=articleInfoMapper.getArticlesByIds(articleIds);

            List<Integer> userIds = new ArrayList<>() ;
            //获取userId
            //并去重
            for(ArticleInfo articleInfo1:articleInfoList){
                if(!userIds.contains(articleInfo1.getAuthorId())){
                    userIds.add(articleInfo1.getAuthorId());
                }
            }

            HashMap<Integer,String> userNicksMap=new HashMap<>();
            HashMap<Integer,String> userHeadPath=new HashMap<>();
            List<UserInfo> userInfos=userInfoMapper.getUserInfoByIds(userIds);
            userInfos.forEach(userInfo->{
                userNicksMap.put(userInfo.getUserId(),userInfo.getNickName());
                userHeadPath.put(userInfo.getUserId(),userInfo.getHeadPath());
            });

            List<ArticleInfoVo> articleInfoVoList=new ArrayList<>();
            for(ArticleInfo articleInfo2:articleInfoList){
                ArticleInfoVo articleInfoVo=new ArticleInfoVo();
                articleInfoVo.setArticleId(articleInfo2.getArticleId());
                articleInfoVo.setArticleTitle(articleInfo2.getArticleTitle());
                articleInfoVo.setPublishTime(articleInfo2.getPublishTime());
                articleInfoVo.setReplierId(articleInfo2.getReplierId());
                articleInfoVo.setReplierNickname(articleInfo2.getReplierNickname());
                String labelString=articleInfo2.getLabels();
                String[] labels=labelString.split(",");
                articleInfoVo.setLabels(labels);
                articleInfoVo.setArticleClass(articleInfo2.getArticleClass());

                articleInfoVo.setAuthorId(articleInfo2.getAuthorId());
                articleInfoVo.setAuthorName(userNicksMap.get(articleInfo2.getAuthorId()));
                articleInfoVo.setImgUrl(userHeadPath.get(articleInfo2.getAuthorId()));

                articleInfoVo.setCollectTime(collectTimeMap.get(articleInfo2.getArticleId()));

                articleInfoVoList.add(articleInfoVo);
                return articleInfoVoList;
            }
        }
        return null;
    }
}

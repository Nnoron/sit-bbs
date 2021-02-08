package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.ArticleInfo;
import com.local.i_sit_bbs.pojo.ArticlePhoto;
import com.local.i_sit_bbs.pojo.Top;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleInfoMapper {
    int insert(ArticleInfo record);

    int insertPhoto(ArticlePhoto articlePhoto);

    int deletePhoto(String fileName);

    int insertSelective(ArticleInfo record);

    int deleteArticle(Integer articleId);

    int editArticle(ArticleInfo articleInfo);

    List<ArticleInfo> getArticles(ArticleInfo articleInfo);

    ArticleInfo getArticleById(Integer id);

    List<ArticleInfo> getArticlesByIds(List<Integer> ids);

    List<ArticleInfo> getHotThisWeek(String date);
}
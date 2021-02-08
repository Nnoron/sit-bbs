package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.ArticleInfo;
import com.local.i_sit_bbs.pojo.Top;
import com.local.i_sit_bbs.vo.ArticleInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ArticleService {

    int addArticle(ArticleInfo articleInfo);

    String addPhoto(MultipartFile file,int articleId);

    int deletePhoto(String fileName);

    void getPhoto(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException;

    int deleteArticle(Integer articleId);

    int updateArticle(ArticleInfo articleInfo);

    List<ArticleInfoVo> getArticles(ArticleInfo articleInfo);

    ArticleInfoVo getArticleById(Integer id);

    List<ArticleInfoVo> getHotThisWeek();

    List<ArticleInfoVo> getTopThisWeek(int type);

    List<ArticleInfoVo> getTopsByDate(String date);

    int getTopsNumThisWeek();

    Top getTopById(Integer articleId);

    int setTop(Integer articleId);

    int deleteTop(Integer articleId);
}

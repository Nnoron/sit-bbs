package com.local.i_sit_bbs.pojo;

import java.util.Date;

public class ArticleInfo {
    private Integer articleId;

    private Integer authorId;

    private String articleTitle;

    private String articleText;

    private String articlePictures;

    private String publishTime;

    private Integer articleClass;

    private Integer articleState;

    private String labels;

    private String commentTime;

    private String replierNickname;

    private Integer replierId;

    private Integer commentNum;

    public ArticleInfo(Integer articleId, Integer authorId, String articleTitle, String articleText, String articlePictures, String publishTime, Integer articleClass,
                       Integer articleState, String labels,String commentTime,String replierNickname,Integer replierId,Integer commentNum) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.articlePictures = articlePictures;
        this.publishTime = publishTime;
        this.articleClass = articleClass;
        this.articleState = articleState;
        this.labels = labels;
        this.commentTime=commentTime;
        this.replierNickname=replierNickname;
        this.replierId=replierId;
        this.commentNum=commentNum;
    }

    public ArticleInfo() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText == null ? null : articleText.trim();
    }

    public String getArticlePictures() {
        return articlePictures;
    }

    public void setArticlePictures(String articlePictures) {
        this.articlePictures = articlePictures == null ? null : articlePictures.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public Integer getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(Integer articleClass) {
        this.articleClass = articleClass;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels == null ? null : labels.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getReplierNickname() {
        return replierNickname;
    }

    public void setReplierNickname(String replierNickname) {
        this.replierNickname = replierNickname;
    }

    public Integer getReplierId() {
        return replierId;
    }

    public void setReplierId(Integer replierId) {
        this.replierId = replierId;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}
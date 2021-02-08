package com.local.i_sit_bbs.pojo;

public class History {
    private Integer userId;

    private Integer articleId;

    public History(Integer userId, Integer articleId) {
        this.userId = userId;
        this.articleId = articleId;
    }

    public History() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
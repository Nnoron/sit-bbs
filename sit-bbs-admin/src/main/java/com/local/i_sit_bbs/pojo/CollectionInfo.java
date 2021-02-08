package com.local.i_sit_bbs.pojo;

public class CollectionInfo {
    private Integer userId;

    private Integer articleId;

    private String collectTime;

    public CollectionInfo(Integer userId, Integer articleId,String collectTime) {
        this.userId = userId;
        this.articleId = articleId;
        this.collectTime=collectTime;
    }

    public CollectionInfo() {
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

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
}
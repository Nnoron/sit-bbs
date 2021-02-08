package com.local.i_sit_bbs.pojo;

public class Advertisement {

    private Integer advId;

    private String title;

    private String imgPath;

    private Integer articleId;

    public Advertisement(String title, String imgPath, Integer articleId) {
        this.title = title;
        this.imgPath = imgPath;
        this.articleId = articleId;
    }

    public Advertisement() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAdvId() {
        return advId;
    }

    public void setAdvId(Integer advId) {
        this.advId = advId;
    }
}
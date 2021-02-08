package com.local.i_sit_bbs.pojo;

public class Top {
    private Integer articleId;

    private String setTime;

    private Integer type;

    public Top(Integer articleId, String time,Integer type) {
        this.articleId = articleId;
        this.setTime = time;
        this.type=type;
    }

    public Top() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTime() {
        return setTime;
    }

    public void setTime(String time) {
        this.setTime = time == null ? null : time.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
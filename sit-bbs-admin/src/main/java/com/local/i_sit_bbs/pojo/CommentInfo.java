package com.local.i_sit_bbs.pojo;

public class CommentInfo {
    private Integer commentId;

    private Integer articleId;

    private String reviewerUsername;

    private String commentText;

    private String commentPictures;

    private String commentTime;

    private String isToken;

    private Integer support;

    private Integer oppose;

    private Integer ifSource;

    private Integer sourceId;

    private Integer parentId;

    public CommentInfo(Integer commentId,Integer articleId, String reviewerUsername, String commentText, String commentPictures, String commentTime,String isToken,
            Integer support,Integer oppose,Integer ifSource,Integer sourceId,Integer parentId) {
        this.commentId=commentId;
        this.articleId = articleId;
        this.reviewerUsername = reviewerUsername;
        this.commentText = commentText;
        this.commentPictures = commentPictures;
        this.commentTime = commentTime;
        this.isToken=isToken;
        this.support=support;
        this.oppose=oppose;
        this.ifSource=ifSource;
        this.sourceId=sourceId;
        this.parentId=parentId;
    }

    public CommentInfo() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public String getCommentPictures() {
        return commentPictures;
    }

    public void setCommentPictures(String commentPictures) {
        this.commentPictures = commentPictures == null ? null : commentPictures.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }

    public String getIsToken() {
        return isToken;
    }

    public void setIsToken(String isToken) {
        this.isToken = isToken;
    }

    public String getReviewerUsername() {
        return reviewerUsername;
    }

    public void setReviewerUsername(String reviewerUsername) {
        this.reviewerUsername = reviewerUsername;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getOppose() {
        return oppose;
    }

    public void setOppose(Integer oppose) {
        this.oppose = oppose;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getIfSource() {
        return ifSource;
    }

    public void setIfSource(Integer ifSource) {
        this.ifSource = ifSource;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}